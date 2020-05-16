package io.react.realworldapp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.object.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ArticleTest extends TestBase {

    User user = UserData.defaultUser();
    Faker faker = new Faker();

    @Test
    public void addNewArticle() {

        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        NewArticlePage newArticlePage = homePage.clickNewPost();
        newArticlePage.inputArticleTitle("Atricle Title");
        newArticlePage.inputArticleAbout("Article about");
        newArticlePage.inputArticle("lorem ipsum dolor sit amet");
        newArticlePage.inputArticleTags("tags");

        ArticleDetailsPage articleDetailsPage = newArticlePage.clickPublishArticleBtn();
        assertThat(articleDetailsPage.isPageOpened()).isTrue();

    }


        @Test
        public void editArticle() throws InterruptedException {

            clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

            HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
            assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

            ProfilePage profilePage = homePage.openProfile();

            checkArticleIsDisplayed();
            openArticle();

            WebElement editArticleButton = driver.findElement(By.className("ion-edit"));
            editArticleButton.click();

            ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage(driver);
            articleDetailsPage.editArticleAbout("updated article description");
            articleDetailsPage.publishArticle();
        }


        @Test
        public void deleteArticle(){
            clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

            HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
            assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

            ProfilePage profilePage = homePage.openProfile();

            checkArticleIsDisplayed();
            openArticle();

            WebElement deleteArticleButton = driver.findElement(By.className("ion-trash-a"));
            deleteArticleButton.click();

        }

        public void checkArticleIsDisplayed(){
            assertThat(driver.findElement(By.cssSelector("[class=\"preview-link\"]")).isDisplayed()).isTrue();
         }

         public ArticleDetailsPage openArticle(){
            driver.findElement(By.cssSelector("a>h1")).click();
            return new ArticleDetailsPage(driver);
         }



}


