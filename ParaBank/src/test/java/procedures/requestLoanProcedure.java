package procedures;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import page.requestLoanPage;

import java.io.FileReader;
import java.io.IOException;

public class requestLoanProcedure {
    public JSONObject user;
    public JSONObject users;
    public String fromAccount;
    public String loanAmount;
    public String downPayment;

    public void requestLoan(RemoteWebDriver driver) throws IOException, ParseException, InterruptedException {
        requestLoanPage page = new requestLoanPage(driver);
        boolean result;

        getAccountData();

        page.clickRequestLoanBtn()
                .fillLoanAmount(loanAmount)
                .fillDownPayment(downPayment)
                .selectFromAccount(fromAccount)
                .clickApplyNowBtn();

        //There is an error happened and i can't verify if it's completed or not
        //This is the error details: An internal error has occurred and has been logged.


    }
    public void getAccountData() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/requestLoan.json");
        Object obj = jsonParser.parse(reader);


        System.out.println(obj);

        users = (JSONObject) obj;

        System.out.println(users);//This prints every block - one json object

        user = (JSONObject) users.get("loanInfo");

        System.out.println(user); //This prints each data in the block

        fromAccount = (String) user.get("fromAcc");
        loanAmount = (String) user.get("loanAmount");
        downPayment = (String) user.get("downPayment");


    }
}
