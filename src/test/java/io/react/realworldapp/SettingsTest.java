package io.react.realworldapp;

import org.testng.annotations.Test;
import page.object.HomePage;
import page.object.LoginPage;
import page.object.SettingsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingsTest extends TestBase {

    User user = UserData.defaultUser();

    @Test
    public void checkSettingsPage(){
        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        SettingsPage settingsPage = homePage.openSettingsPage();
        assertThat(settingsPage.getPageTitle()).isEqualTo("Your Settings");

    }
}
