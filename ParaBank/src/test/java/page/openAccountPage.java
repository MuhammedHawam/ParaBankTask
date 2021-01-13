package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ActionUtils;

public class openAccountPage {
    RemoteWebDriver driver; //declare driver


    public openAccountPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    By openNewAccBtn = By.xpath("//*[@id='leftPanel']//*[text()='Open New Account']");
    By openNewAccFormBtn = By.xpath("//*[@id='rightPanel']//*[@value='Open New Account']");
    By accOpenedSuccessMsg = By.xpath("//*[@id='rightPanel']//*[text()='Congratulations, your account is now open.']");
    By selectAccType = By.id("type");

    By selectFromAcc = By.xpath("//*[@id='fromAccountId']//option[1]");

    /////////////////////////Functions//////////////////////////////////
    public openAccountPage clickOpenNewAccBtn() {
        ActionUtils.clickOnElement(driver,openNewAccBtn);
        return this;
    }
    public openAccountPage selectAccType(String type) {
        ActionUtils.selectFromDropDown(driver,selectAccType,type);
        return this;
    }
    public openAccountPage selectFromAcc() {
        ActionUtils.clickOnElement(driver,selectFromAcc);
        return this;
    }
    public openAccountPage clickOpenNewAccFormBtn() {
        ActionUtils.clickOnElement(driver,openNewAccFormBtn);
        return this;
    }
    public boolean verifyAccountOpened() {
        return ActionUtils.verifyElementExists(driver,accOpenedSuccessMsg);

    }



}
