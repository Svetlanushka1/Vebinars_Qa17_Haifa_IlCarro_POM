package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
//
//{
//        "platformName": "Android",
//        "deviceName": "Qa",
//        "platformVersion": "8.0",
//        "appPackage": "com.telran.ilcarro",
//        "appActivity": ".SplashActivity"
//        }
public class AppiumConfig {

    public static AppiumDriver <MobileElement>driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName", "Qa");
        capabilities.setCapability("appPackage", "com.telran.ilcarro");
        capabilities.setCapability("appActivity", ".SplashActivity");
        capabilities.setCapability("automationName","Appium");
        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
