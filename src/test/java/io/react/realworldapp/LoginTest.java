package io.react.realworldapp;

import org.testng.annotations.Test;
import page.object.HomePage;
import page.object.LoginPage;


import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {

    private User user = UserData.defaultUser();

    @Test
    public void loginTest(){
        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();


    }

}
