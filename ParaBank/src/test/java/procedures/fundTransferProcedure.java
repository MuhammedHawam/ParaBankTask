package procedures;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import page.transferFundPage;

import java.io.FileReader;
import java.io.IOException;

public class fundTransferProcedure {

    public JSONObject user;
    public JSONObject users;
    public String amount;
    public String fromAccount;
    public String toAccount;

    public void fundTransfer(RemoteWebDriver driver) throws IOException, ParseException, InterruptedException {
        transferFundPage page = new transferFundPage(driver);
        boolean result;

        getAccountData();

        page.clickTransferFundBtn();

        Thread.sleep(5000);
        //result = page.verifySelectFromAccLoaded();
        page.fillTransferedAmount(amount)
                .selectFromAcc()
                .selectToAcc()
                .clickTransferBtn();

        result = page.verifyTransferCompleted();
        Assert.assertEquals(result, true);

    }

    public void getAccountData() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/transferFund.json");
        Object obj = jsonParser.parse(reader);


        System.out.println(obj);

        users = (JSONObject) obj;

        System.out.println(users);//This prints every block - one json object

        user = (JSONObject) users.get("transferDetails");

        System.out.println(user); //This prints each data in the block


        amount = (String) user.get("amount");
        fromAccount = (String) user.get("fromAcc");
        toAccount = (String) user.get("toAcc");

    }
}
