package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ActionUtils;

public class transferFundPage {
    RemoteWebDriver driver; //declare driver

    /***
     * constructor
     * @param driver
     */
    public transferFundPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    By transferFundBtn = By.xpath("//*[@id='leftPanel']//*[text()='Transfer Funds']");
    By transferBtn = By.xpath("//*[@id='rightPanel']//*[@value='Transfer']");
    By transferComplete = By.xpath("//*[@id='rightPanel']//*[text()='Transfer Complete!']");
    By transferedAmount = By.id("amount");
    By fromAccount = By.xpath("//*[@id=\"fromAccountId\"]//option[1]");
    By ToAccount = By.xpath("//*[@id=\"toAccountId\"]//option[2]");

    ///////////////////////////////////Functions///////////////////////////////////
    public transferFundPage clickTransferFundBtn() {
        ActionUtils.clickOnElement(driver,transferFundBtn);
        return this;
    }
    public transferFundPage clickTransferBtn() {
        ActionUtils.clickOnElement(driver,transferBtn);
        return this;
    }
    public transferFundPage fillTransferedAmount(String amount) {
        ActionUtils.fillElement(driver,transferedAmount,amount);
        return this;
    }
    public transferFundPage selectFromAcc() {
        ActionUtils.clickOnElement(driver,fromAccount);
        return this;
    }
//    public Boolean verifySelectFromAccLoaded() {
//        return ActionUtils.verifyPageOpened(driver,fromAccount,10);
//    }
    public transferFundPage selectToAcc() {
        ActionUtils.clickOnElement(driver,ToAccount);
        return this;
    }
    public Boolean verifyTransferCompleted() {
       return ActionUtils.verifyElementExists(driver,transferComplete);
    }

}
