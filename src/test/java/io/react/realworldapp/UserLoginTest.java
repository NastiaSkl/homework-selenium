package io.react.realworldapp;

import org.testng.annotations.Test;


public class UserLoginTest extends TestBase {

    private User user = UserData.defaultUser();

    @Test
    public void userLogin(){

        clickLoginButton();

        checkPage("Sign In");

        userLogin();

        userShouldBeLoggedIn(user.getUserName());

    }

}
