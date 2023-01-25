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
    public void successLogin(){
       Assert.assertTrue(new SearchScreen(driver)
               .openMoreOptions()
                .openFormLogin()
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isSearchScreenDisplaeyd());

//       new SearchScreen(driver)
//               .openMoreOptions()
//               .logout();


    }
    @Test
    public void successLoginModel(){
        Assert.assertTrue(new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin()
                .isSearchScreenDisplaeyd());



    }
    @AfterMethod
    public void posCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .logout();
    }
}
