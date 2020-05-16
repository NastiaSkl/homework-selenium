package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) {
        super(driver);
    }


    public String getPageTitle(){
       return driver.findElement(By.cssSelector("div>h1")).getText();
    }
}
