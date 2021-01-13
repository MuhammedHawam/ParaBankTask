package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainFunctionsUtils {
	public static void clickLogoutButton(RemoteWebDriver driver) {
		By logout = By.xpath("//a[text()='Log Out']");
		ActionUtils.clickOnElement(driver, logout);
	}
}