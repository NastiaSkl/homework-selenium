package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean isUserLoggedIn(String userName) {
        WebElement userInfo = driver.findElement(By.cssSelector("[href='#@" +userName+"']"));
        return userInfo.isDisplayed();
    }

    public NewArticlePage clickNewPost(){
        driver.findElement(By.cssSelector("[href='#editor']")).click();
        return new NewArticlePage(driver);
    }

    public ProfilePage openProfile(){
        driver.findElement(By.cssSelector("li:nth-child(4)")).click();
        return new ProfilePage(driver);
    }

    public SettingsPage openSettingsPage(){
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        return new SettingsPage(driver);
    }
}
