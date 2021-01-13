package procedures;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import page.loginPage;

import java.io.FileReader;
import java.io.IOException;

public class loginProcedure {

    public JSONObject user;
    public JSONObject users;
    public String username;
    public String password;

    public void customerLogin(RemoteWebDriver driver) throws IOException, ParseException {
        loginPage page = new loginPage(driver);
        boolean result;
        getLoginData();

        page.fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();

        result = page.verifyBalanceExist();
        Assert.assertEquals(result,true);

        result = page.verifyTotalExist();
        Assert.assertEquals(result,true);

    }

    public void getLoginData() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/login.json");
        Object obj = jsonParser.parse(reader);


        System.out.println(obj);

        users = (JSONObject) obj;

        System.out.println(users);//This prints every block - one json object

        user = (JSONObject) users.get("login");

        System.out.println(user); //This prints each data in the block


        username = (String) user.get("userName");
        password = (String) user.get("password");


    }
}
