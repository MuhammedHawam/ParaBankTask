
package test;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import procedures.registerProcedure;
import utils.WebDriverFactory;

import java.io.IOException;

/**
 * @author Muhamed.Hawam
 *
 */

public class RegisterTest {

    RemoteWebDriver driver;

    @BeforeMethod
    public void beforeMethod(Object[] testData) throws InterruptedException, IOException {


        WebDriverFactory m = new WebDriverFactory();
        driver = m.setup();
        driver.manage().window().maximize();
        // login to the system

    }

    @AfterMethod
    public void afterMethod() throws Exception {
        try {
            //MainFunctionsUtils.clickLogoutButton(driver);
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
    public void Register()
            throws InterruptedException, IOException, ParseException {

        registerProcedure register = new registerProcedure();

        register.prepareTestData();
        register.registerAndFillForm(driver);
    }

}
