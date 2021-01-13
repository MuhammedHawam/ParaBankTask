package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ActionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Muhamed.Hawam
 *
 */
public class RegisterPage {

    RemoteWebDriver driver; //declare driver
    public List<By> elements = new ArrayList<By>();
    /***
     * constructor
     * @param driver
     */
    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    By registerBtn = By.xpath("//*[@id='loginPanel']//*[text()='Register']");

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By addressStreet = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By repeatedPassword = By.id("repeatedPassword");

    By registerFormBtn = By.xpath("//*[@id='customerForm']//*[@value='Register']");
    By successMsg = By.xpath("//*[@id='rightPanel']//*[text()='Your account was created successfully. You are now logged in.']");

    public void prepareList()
    {
        elements.add(firstName);
        elements.add(lastName);
        elements.add(addressStreet);
        elements.add(city);
        elements.add(state);
        elements.add(zipCode);
        elements.add(phoneNumber);
        elements.add(ssn);
        elements.add(username);
        elements.add(password);
        elements.add(repeatedPassword);
    }
    ////////////////////////////Functions////////////////////////////

    public RegisterPage clickRegisterBtn() {
        ActionUtils.clickOnElement(driver,registerBtn);
        return this;
    }
    public RegisterPage fillRegisterForm(String[] data) {
        prepareList();

        for (int i = 0; i < data.length; i++)
        {
            ActionUtils.fillElement(driver, elements.get(i),data[i]);
        }

        ActionUtils.clickOnElement(driver,registerFormBtn);
        return this;
    }
    public Boolean verifySuccessMsg(){
            return ActionUtils.verifyElementExists(driver,successMsg);
    }
}
