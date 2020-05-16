package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleDetailsPage extends BasePage{

   private By articlePage = By.cssSelector(".article-page");

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>text");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("form>fieldset>button");


    public ArticleDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return driver.findElement(articlePage).isDisplayed();
    }

    public void editArticleTitle(String title){
        inputText(driver.findElement(titleField), title);
    }

    public void editArticleAbout(String whatAbout){
        inputText(driver.findElement(whatAboutField), whatAbout);
    }

    public void publishArticle(){
        driver.findElement(publishArticleBtn).click();
    }
}
