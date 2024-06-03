package pages;

import com.movie.pages.HomePage;
import com.movie.pages.LoginPage;
import com.movie.pages.SearchPage;
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

public class SearchPageTest {
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
    public void SearchPage() throws Exception {
        SearchPage searchPage = new SearchPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton)).click();
        Thread.sleep(5000);
        searchPage.enterTextInSearch("Venom");
        Thread.sleep(5000);
        List<WebElement>  moviesCount = driver.findElements(By.xpath("//li[@class='movie-icon-item']"));
        System.out.println("moviesCount:"+moviesCount.size());
    }

}
