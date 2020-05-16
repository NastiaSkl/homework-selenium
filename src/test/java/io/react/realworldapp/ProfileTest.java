package io.react.realworldapp;

import org.testng.annotations.Test;
import page.object.HomePage;
import page.object.LoginPage;
import page.object.ProfilePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileTest extends TestBase {

    User user = UserData.defaultUser();

    @Test
    public void checkPageOpened(){
        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        ProfilePage profilePage = homePage.openProfile();
        assertThat(profilePage.isPageOpened()).isTrue();
    }
}
