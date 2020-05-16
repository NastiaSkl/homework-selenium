package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By profilePage = By.className("user-img");

    public boolean isPageOpened(){
        return driver.findElement(profilePage).isDisplayed();
    }


    }
