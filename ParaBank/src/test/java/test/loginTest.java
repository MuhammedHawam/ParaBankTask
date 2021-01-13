package test;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import procedures.loginProcedure;
import utils.MainFunctionsUtils;
import utils.WebDriverFactory;

import java.io.IOException;

public class loginTest {
    RemoteWebDriver driver;

    @BeforeMethod
    public void beforeMethod(Object[] testData) throws InterruptedException, IOException {


        WebDriverFactory m = new WebDriverFactory();
        driver = m.setup();
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void afterMethod() throws Exception {
        try {
            MainFunctionsUtils.clickLogoutButton(driver);
            driver.quit();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            driver.quit();

        }
    }

    /****
     *
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void Login()
            throws InterruptedException, IOException, ParseException {

        loginProcedure login = new loginProcedure();

        login.customerLogin(driver);

    }

}
