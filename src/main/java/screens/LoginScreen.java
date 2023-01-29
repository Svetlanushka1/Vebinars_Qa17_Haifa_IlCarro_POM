package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "com.telran.ilcarro:id/editLoginEmail")
    MobileElement emailEditText;
    @FindBy(id = "com.telran.ilcarro:id/editLoginPassword")
    MobileElement passwordEditText;
    @FindBy(how = How.ID, using = "com.telran.ilcarro:id/loginBtn")
    MobileElement yallaButton;
    @FindBy(id = "android:id/message")
    MobileElement messageText;
    @FindBy(id = "android:id/button1")
    MobileElement okButton;

    public LoginScreen fillLoginForm(Auth auth) {
        should(emailEditText, 5);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        return this;
    }

    public LoginScreen fillEmail(String email) {
        should(emailEditText, 5);
        type(emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public SearchScreen submitLogin() {
        driver.hideKeyboard();
        yallaButton.click();
        return new SearchScreen(driver);
    }

    public LoginScreen submitLoginNegative() {
        driver.hideKeyboard();
        yallaButton.click();
        return this;
    }

    public boolean isErrorMessageTest(String message) {
        should(messageText, 5);
        if (messageText.getText().equals(message)) {
            okButton.click();
            pause(1000);
            driver.navigate().back();
            return true;
        }
        return false;
    }
}
 