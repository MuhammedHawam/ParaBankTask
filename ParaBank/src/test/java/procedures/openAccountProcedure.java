package procedures;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import page.openAccountPage;

import java.io.FileReader;
import java.io.IOException;

public class openAccountProcedure {
    public JSONObject user;
    public JSONObject users;
    public String accountType;
    public String fromAccount;

    public void openAccount(RemoteWebDriver driver) throws IOException, ParseException, InterruptedException {
        openAccountPage page = new openAccountPage(driver);
        boolean result;

        getAccountData();

        page.clickOpenNewAccBtn();

        Thread.sleep(4000);
        page.selectAccType(accountType)
                .selectFromAcc()
                .clickOpenNewAccFormBtn();

        result = page.verifyAccountOpened();
        Assert.assertEquals(result,true);

    }
    public void getAccountData() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/account.json");
        Object obj = jsonParser.parse(reader);


        System.out.println(obj);

        users = (JSONObject) obj;

        System.out.println(users);//This prints every block - one json object

        user = (JSONObject) users.get("accountInfo");

        System.out.println(user); //This prints each data in the block


        accountType = (String) user.get("accType");
        fromAccount = (String) user.get("fromAcc");


    }
}
