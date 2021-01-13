package utils;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebDriverFactory {

    RemoteWebDriver driver;
    Properties properties = new Properties();

    public RemoteWebDriver setup() throws MalformedURLException {

            properties = PropertyReader.getProperties();
            new DesiredCapabilities();
            DesiredCapabilities caps = DesiredCapabilities.chrome();

            caps.setCapability("nativeEvents", false);
            caps.setCapability("unexpectedAlertBehaviour", "accept");
            caps.setCapability("ignoreProtectedModeSettings", true);
            caps.setCapability("disable-popup-blocking", true);
            caps.setCapability("enablePersistentHover", true);
            caps.setCapability("ignoreZoomSetting", true);


            ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless"); //if we want to run headless
//	        options.addArguments("--disable-gpu");
//	        options.addArguments("--window-size=1400,800");

            options.addArguments("--ignore-certificate-errors");
            caps.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new RemoteWebDriver(caps);
            driver.get(properties.getProperty(PropertyEnum.APP_URL.toString()));


            return driver;


    }


}
