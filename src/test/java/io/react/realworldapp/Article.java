package io.react.realworldapp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class Article extends TestBase {

    User user = UserData.defaultUser();
    Faker faker = new Faker();

    @Test
    public void addNewArticle() {

        clickLoginButton();
        checkPage("Sign In");
        userLogin();
        userShouldBeLoggedIn(user.getUserName());

        WebElement newPost = driver.findElement(By.cssSelector("#main > div > nav > div > ul > li:nth-child(2) > a"));
        assertThat(driver.getCurrentUrl().contains("editor"));
        newPost.click();

        articleTitle().sendKeys(faker.harryPotter().spell());

        articleDescription().sendKeys(faker.harryPotter().book());

        articleText().sendKeys(faker.harryPotter().quote());

        articleTags().sendKeys(faker.harryPotter().character());

        clickPublishArticle();



    }


        @Test  (dependsOnMethods = {"addNewArticle"}, priority = 1)
        public void editArticle() throws InterruptedException {

            clickLoginButton();
            checkPage("Sign In");
            userLogin();
            userShouldBeLoggedIn(user.getUserName());

            clickOnUserName();
            checkArticleIsDisplayed();

            clickOnArticle();
            assertThat(driver.getCurrentUrl().contains("article"));

            WebElement editArticleButton = driver.findElement(By.className("ion-edit"));
            editArticleButton.click();

            articleTitle().clear();
            articleTitle().sendKeys(faker.twinPeaks().character());

            clickPublishArticle();

        }


        @Test(dependsOnMethods = {"addNewArticle"}, priority = 2)
        public void deleteArticle(){
            clickLoginButton();
            checkPage("Sign In");
            userLogin();
            userShouldBeLoggedIn(user.getUserName());

            clickOnUserName();
            checkArticleIsDisplayed();

            clickOnArticle();
            assertThat(driver.getCurrentUrl().contains("article"));

            WebElement deleteArticleButton = driver.findElement(By.className("ion-trash-a"));
            deleteArticleButton.click();

        }



    protected WebElement articleTitle(){
        return driver.findElement(By.cssSelector("#main > div > div > div > div > div > form > fieldset > fieldset:nth-child(1) > input"));
    }

    protected WebElement articleDescription(){
        return driver.findElement(By.cssSelector("#main > div > div > div > div > div > form > fieldset > fieldset:nth-child(2) > input"));
    }

    protected WebElement articleText(){
        return driver.findElement(By.cssSelector("#main > div > div > div > div > div > form > fieldset > fieldset:nth-child(3) > textarea"));
    }

    protected WebElement articleTags(){
        return driver.findElement(By.cssSelector("#main > div > div > div > div > div > form > fieldset > fieldset:nth-child(4) > input"));
    }

    protected void clickOnUserName(){
        WebElement mainPage = driver.findElement(By.cssSelector("#main > div > nav > div > ul > li:nth-child(4) > a"));
        mainPage.click();
    }

    protected void clickPublishArticle(){
        WebElement publishArticleButton = driver.findElement(By.cssSelector("#main > div > div > div > div > div > form > fieldset > button"));
        publishArticleButton.click();
    }

    protected void checkArticleIsDisplayed(){
        WebElement articlePreview = driver.findElement(By.className("article-preview"));
        assertThat(articlePreview.isDisplayed()).isTrue();
    }


    protected void clickOnArticle(){
        WebElement articleTitle = driver.findElement(By.cssSelector("#main > div > div > div.container > div > div > div:nth-child(2) > div > a > h1"));
        articleTitle.click();
    }



}


