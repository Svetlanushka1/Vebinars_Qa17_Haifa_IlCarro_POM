package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void successLogin() {
        Assert.assertTrue(new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin()
                .isSearchScreenDisplaeyd());

//       new SearchScreen(driver)
//               .openMoreOptions()
//               .logout();


    }

    @Test
    public void successLoginModel() {
        Assert.assertTrue(new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder()
                        .email("haifa@gmail.com")
                        .password("Haifa082022$")
                        .build())
                .submitLogin()
                .isSearchScreenDisplaeyd());


    }

    @Test
    public void loginNegativeEmailModel() {
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noagmail.com").password("Nnoa12345$").build())
                .submitLoginNegative()
                .isErrorMessageTest("Login or Password incorrect");

    }
    @Test
    public void loginNegativePasswordModel() {
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345").build())
                .submitLoginNegative()
                .isErrorMessageTest("Login or Password incorrect");

    }
    @AfterMethod
    public void posCondition() {
        new SearchScreen(driver)
                .openMoreOptions()
                .logout();
    }
}
