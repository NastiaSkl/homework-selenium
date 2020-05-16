package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

}
