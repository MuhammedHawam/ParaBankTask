package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ActionUtils;

public class loginPage {
    RemoteWebDriver driver; //declare driver

    /***
     * constructor
     * @param driver
     */
    public loginPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    By userNameTxt = By.xpath("//*[@id='loginPanel']//*[@name='username']");
    By passwordTxt = By.xpath("//*[@id='loginPanel']//*[@name='password']");

    By logInBtn = By.xpath("//*[@id='loginPanel']//*[@value='Log In']");
   // By balance = By.xpath("(//*[@id='accountTable']//*[text()='"+amount+"'])[1]");
    By balance = By.xpath("(//*[@id='accountTable']//*[text()='Balance*'])");
    //By total = By.xpath("(//*[@id='accountTable']//*[text()='"+amount+"'])[3]");
    By total = By.xpath("(//*[@id='accountTable']//*[text()='Total'])");

    ////////////////////////////Functions//////////////////////

    public loginPage clickLoginBtn() {
        ActionUtils.clickOnElement(driver,logInBtn);
        return this;
    }
    public loginPage fillUsername(String userName) {
        ActionUtils.fillElement(driver,userNameTxt ,userName);
        return this;
    }
    public loginPage fillPassword(String password) {
        ActionUtils.fillElement(driver,passwordTxt ,password);
        return this;
    }
//    public Boolean verifyBalanceExist(String amountBalance){
//        amount = amountBalance;
//        return ActionUtils.verifyElementExists(driver,balance);
//    }
    public Boolean verifyBalanceExist(){
        return ActionUtils.verifyElementExists(driver,balance);
    }
//    public Boolean verifyTotalExist(String amountTotal){
//        amount = amountTotal;
//        return ActionUtils.verifyElementExists(driver,total);
//    }
    public Boolean verifyTotalExist(){
        return ActionUtils.verifyElementExists(driver,total);
    }
}
