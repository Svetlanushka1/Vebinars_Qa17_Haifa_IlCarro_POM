package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH,using = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(how = How.XPATH,using = "//*[@text='Login']")
    MobileElement loginButton;
    //com.telran.ilcarro:id/content    // com.telran.ilcarro:id/title   com.telran.ilcarro:id/title
    @FindBy(how = How.XPATH,using = "//*[@text='Logout']")
    MobileElement logoutButton;
    @FindBy(how = How.ID,using = "com.telran.ilcarro:id/findTitle")
    MobileElement titlePage;

    public SearchScreen logout(){

        logoutButton.click();
        return this;
    }


    public SearchScreen openMoreOptions() {
        should(moreOptions,10);
        moreOptions.click();
        return this;
    }
    public LoginScreen openFormLogin(){
    loginButton.click();
    return new LoginScreen(driver);
    }

    public boolean isSearchScreenDisplaeyd(){
        should(titlePage,5);
        return titlePage.getText().equals("Find your car now!");
    }
}
