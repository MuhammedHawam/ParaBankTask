package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ActionUtils;

public class requestLoanPage {
    RemoteWebDriver driver; //declare driver

    /***
     * constructor
     * @param driver
     */
    public requestLoanPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    By requestLoanBtn = By.xpath("//*[@id='leftPanel']//*[text()='Request Loan']");
    By applyNowBtn = By.xpath("//*[@id='rightPanel']//*[@value='Apply Now']");
    By loanAmount = By.id("amount");
    By downPayment = By.id("downPayment");

    ////////////////////////////////////Functions///////////////////////////////
    public requestLoanPage clickRequestLoanBtn() {
        ActionUtils.clickOnElement(driver,requestLoanBtn);
        return this;
    }
    public requestLoanPage clickApplyNowBtn() {
        ActionUtils.clickOnElement(driver,applyNowBtn);
        return this;
    }
    public requestLoanPage selectFromAccount(String account) {
        By fromAccount = By.xpath("//*[@id=\"fromAccountId\"]//option["+account+"]");
        ActionUtils.clickOnElement(driver,fromAccount);
        return this;
    }
    public requestLoanPage fillLoanAmount(String amount) {
        ActionUtils.fillElement(driver,loanAmount ,amount);
        return this;
    }
    public requestLoanPage fillDownPayment(String downPaymentAmount) {
        ActionUtils.fillElement(driver,downPayment ,downPaymentAmount);
        return this;
    }

}
