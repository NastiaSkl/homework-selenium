import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
        System.out.println("Site is opened at " + webDriver.getTitle());
    }

    @Test(priority = 2)
    public void navigateToDownloads(){
        webDriver.navigate().to("https://www.selenium.dev/downloads/");
        System.out.println("You are navigated to " + webDriver.getTitle());
    }

    @Test(priority = 3)
    public void navigateToProjects(){
        webDriver.navigate().to("https://www.selenium.dev/projects/");
        System.out.println(webDriver.getTitle());
        WebElement element = webDriver.findElement(By.className("product-logo-container"));
        System.out.println(element);
    }

    @Test(priority = 4)
    public void navigateToDocumentation(){
        webDriver.navigate().to("https://www.selenium.dev/documentation/en/");
        System.out.println(webDriver.getTitle().toUpperCase());
        System.out.println("Current URL = " + webDriver.getCurrentUrl());
    }

    @Test(priority = 5)
    public void navigateToSupport(){
        webDriver.navigate().forward();
        System.out.println(webDriver.getTitle());
    }

    @Test(priority = 6)
    public void navigateToBlog(){
        webDriver.navigate().forward();
        System.out.println(webDriver.getTitle());
    }



}
