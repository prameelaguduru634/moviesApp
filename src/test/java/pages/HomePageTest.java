package pages;

import com.movie.pages.HomePage;
import com.movie.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageTest {

    public WebDriver driver;

    @BeforeTest
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }

    @AfterTest
    public void end() {
        driver.close();
    }

    @Test
    public void homePage() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton)).click();
        Thread.sleep(5000);
        homePage.checkElementHead(homePage.homeButton);
        homePage.checkAnyElementFindOrNot(homePage.playButton);
        homePage.checkAnyElementFindOrNot(homePage.contactUs);
        List<WebElement> details = driver.findElements(By.xpath("//img[@class='poster']"));
        for (WebElement webElement : details) {
            System.out.println("Movie name:"+webElement.getAttribute("alt"));
        }
        homePage.checkAnyElementFindOrNot(driver.findElement(By.xpath("//img[@class='poster']")));
    }
}
