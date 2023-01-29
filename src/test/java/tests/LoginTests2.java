package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class LoginTests2 extends AppiumConfig {
    @Test
    public void successLogin(){
       new SearchScreen(driver)
               .openMoreOptions()
                .openFormLogin()
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isSearchScreenDisplaeydAssert()
               .openMoreOptions()
               .logout();


    }
    @Test
    public void successLoginModel(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin()
                .isSearchScreenDisplaeydAssert()
                .openMoreOptions()
                .logout();



    }
    @Test
    public void loginNegativeEmailModel(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(Auth.builder().email("noagmail.com").password("Nnoa12345$").build())
                .submitLoginNegative()
                .isErrorMessageTest("Login or Password incorrect");

    }

}
