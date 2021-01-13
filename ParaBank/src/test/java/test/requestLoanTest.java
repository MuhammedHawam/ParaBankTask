package test;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import procedures.loginProcedure;
import procedures.requestLoanProcedure;
import utils.MainFunctionsUtils;
import utils.WebDriverFactory;

import java.io.IOException;

public class requestLoanTest {
    RemoteWebDriver driver;


    @BeforeMethod
    public void beforeMethod(Object[] testData) throws InterruptedException, IOException, ParseException {


        WebDriverFactory m = new WebDriverFactory();
        driver = m.setup();
        driver.manage().window().maximize();
        loginProcedure login = new loginProcedure();
        login.customerLogin(driver);

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
    public void requestLoan()
            throws InterruptedException, IOException, ParseException {

        requestLoanProcedure requestLoanProc = new requestLoanProcedure();

        requestLoanProc.requestLoan(driver);

    }
}
