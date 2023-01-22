package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id ='com.telran.ilcarro:id/versionText']")
    MobileElement versionTextView;

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
}
