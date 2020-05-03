import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;


public class seleniumTest {

    private WebDriver webDriver;

    @BeforeClass

    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public void initialize(){
        webDriver = new ChromeDriver();
    }

    @AfterMethod

    public void quit(){
        webDriver.quit();
        System.out.println("Site is closed.");
    }

    @Test(priority = 1)
    public void siteOpen(){
        webDriver.get("https://www.selenium.dev/");
        String title = webDriver.getTitle();
        System.out.println("Site is opened at " + title);
        assertThat(title).isEqualTo("SeleniumHQ Browser Automation");

    }

    @Test(priority = 2)
    public void navigateToDownloads(){
        webDriver.navigate().to("https://www.selenium.dev/downloads/");
        String title = webDriver.getTitle();
        System.out.println("You are navigated to " + title);
        assertThat(title).isEqualTo("Downloads");
    }

    @Test(priority = 3)
    public void navigateToProjects(){
        webDriver.navigate().to("https://www.selenium.dev/projects/");
        WebElement element = webDriver.findElement(By.className("product-logo-container"));
        String title = webDriver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("Selenium Projects");
    }

    @Test(priority = 4)
    public void navigateToDocumentation(){
        webDriver.navigate().to("https://www.selenium.dev/documentation/en/");
        String title = webDriver.getTitle().toUpperCase();
        System.out.println(title);
        assertThat(title).isEqualTo("THE SELENIUM BROWSER AUTOMATION PROJECT :: DOCUMENTATION FOR SELENIUM");
    }

    @Test(priority = 5)
    public void navigateToSupport(){
        webDriver.navigate().forward();
        String title = webDriver.getTitle();
        assertThat(title).isEqualTo("");
    }

    @Test(priority = 6)
    public void navigateToBlog(){
        webDriver.navigate().forward();
        String title = webDriver.getTitle();
        assertThat(title).isEqualTo("");

    }



}
