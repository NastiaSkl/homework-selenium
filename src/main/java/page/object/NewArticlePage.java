package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticlePage extends BasePage{

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("form>fieldset>button");


    public NewArticlePage(WebDriver driver) {
        super(driver);
    }

    public void inputArticleTitle(String title){
        inputText(driver.findElement(titleField), title);
    }

    public void inputArticleAbout(String whatAbout){
        inputText(driver.findElement(whatAboutField), whatAbout);
    }

    public void inputArticle(String article){
        inputText(driver.findElement(articleBodyField), article);
    }

    public void inputArticleTags(String tags){
        inputText(driver.findElement(tagsField), tags);
    }

    public ArticleDetailsPage clickPublishArticleBtn(){
        driver.findElement(publishArticleBtn).click();
        return new ArticleDetailsPage(driver);
    }
}
