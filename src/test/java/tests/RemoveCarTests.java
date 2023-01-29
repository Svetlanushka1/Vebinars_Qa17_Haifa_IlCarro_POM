package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class RemoveCarTests extends AppiumConfig {
    @BeforeMethod
    public void preCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin();
    }

    @Test
    public void removeCarSuccessTest(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openMyCarsList()
                .removeCar();
    }
}
