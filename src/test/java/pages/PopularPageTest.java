package pages;

import com.movie.pages.LoginPage;
import com.movie.pages.PopularPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopularPageTest {

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
    public void popularPage() throws Exception{
        PopularPage popularPage = new PopularPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(popularPage.popularButton)).click();
        driver.findElement(By.xpath("//div[@class='search-movies-container']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='Venom']")).isDisplayed();

    }
}
