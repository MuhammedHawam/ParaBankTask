package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionUtils  {




	public static void clickOnElement(RemoteWebDriver driver, By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			while (!element.isDisplayed()) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
			driver.findElement(by).click();


		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error!! Could not find Clickable Element for the first time");


		}
	}

	/***
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */
	public static void fillElement(RemoteWebDriver driver, By element, String text) {
		if (text != null || text.equalsIgnoreCase("")) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

			try {
				while (!el.isDisplayed()) {
					el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				}

				el.clear();
				el.sendKeys(text);

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error!! Could not find visible element to enter text into it");

			}
		} else {
			System.out.println("The entered Text is null or empty !!");

		}
	}

	/***
	 * This function should return the existence of the element
	 * 
	 * @param driver
	 * @param element
	 * @return True if the element is found and false if not
	 * @author Moataz.Farid
	 */
	@SuppressWarnings("unused")
	public static Boolean verifyElementExists(RemoteWebDriver driver, By element) {
		WebElement elem = null;
		try {
			WebElement result = new WebDriverWait(driver, 20)
					.until(ExpectedConditions.visibilityOfElementLocated(element));
			elem = driver.findElement(element);

		} catch (Exception e) {

			return false;

		}
		if (elem != null) {

			return true;
		}

		return false;
	}



	/***
	 * 
	 * @param driver
	 * @param element
	 * @param type
	 */

	public static void selectFromDropDown(RemoteWebDriver driver, By element, String type) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

		while (!el.isDisplayed()) {
			el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}

		Select dropdown = new Select(driver.findElement(element));

		dropdown.selectByValue(type);

	}


	/**
	 * verify if page opened in specific time
	 * 
	 * @param driver
	 * @param element
	 * @param time
	 * @return
	 */
	public static boolean verifyPageOpened(RemoteWebDriver driver, By element, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			while (!el.isDisplayed()) {
				el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

			}
			// Adding To Report

			return true;
		} catch (Exception e) {
			// Adding To Report

			return false;
		}

	}


}