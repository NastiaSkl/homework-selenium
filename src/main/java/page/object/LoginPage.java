package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    public HomePage login(String email, String password){
        inputPassword(password);
        inputEmail(email);
        return clickSignInButton();
    }

    public String getPageTitle() {
        return driver.findElement(By.cssSelector(".auth-page h1")).getText();
    }

    public void inputEmail(String email){
        WebElement emailField = signUpForm().findElement(By.cssSelector("input[type='email']"));
        inputText(emailField, email);
    }

    public void inputPassword(String password){
        WebElement passwordField = signUpForm().findElement(By.cssSelector("input[type='password']"));
        inputText(passwordField, password);
    }

    public HomePage clickSignInButton() {
        WebElement signInButton = signUpForm().findElement(By.cssSelector("button[type='submit']"));
        signInButton.click();
        return new HomePage(driver);
    }

    protected WebElement signUpForm() {
        return driver.findElement(By.cssSelector(".auth-page form"));
    }




}
