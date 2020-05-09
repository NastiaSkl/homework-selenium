package io.react.realworldapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {

    protected WebDriver driver;
    User user = UserData.defaultUser();

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.get("https://react-redux.realworld.io/");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

    protected void clickSignUp(){
        WebElement signUpButton = driver.findElement(By.linkText("Sign up"));
        signUpButton.click();
    }

    protected void checkPage(String pageHeader) {
        WebElement singUpHeader = driver.findElement(By.cssSelector(".auth-page h1"));
        assertThat(singUpHeader.getText()).isEqualTo(pageHeader);
    }

    protected WebElement signUpForm() {
        return driver.findElement(By.cssSelector(".auth-page form"));
    }

    protected WebElement userNameField() {
        return signUpForm().findElement(By.cssSelector("input[type='text']"));
    }


    protected WebElement emailField() {
        return signUpForm().findElement(By.cssSelector("input[type='email']"));
    }

    protected WebElement passwordField() {
        return signUpForm().findElement(By.cssSelector("input[type='password']"));
    }

    protected void clickSignInButton() {
        WebElement signInButton = signUpForm().findElement(By.cssSelector("button[type='submit']"));
        signInButton.click();
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void userShouldBeLoggedIn(String userName) {
        WebElement userInfo = driver.findElement(By.cssSelector("[href='#@" +userName+"']"));
        assertThat(userInfo.isDisplayed()).isTrue();
    }

    protected void clickLoginButton(){
        WebElement signUpButton = driver.findElement(By.cssSelector("a[href='#login']"));
        signUpButton.click();
    }

    protected void userLogin(){
        inputText(emailField(), user.getEmail());
        inputText(passwordField(), user.getPassword());
        clickSignInButton();
    }


}
