package pages;

import com.movie.pages.AccountsPage;
import com.movie.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HeaderSectionTest {

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
    public void headerSectionUI() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        loginPage.loginButton.click();
        driver.findElement(By.xpath("//img[@alt='website logo']")).isDisplayed();
        driver.findElement(By.xpath("//nav[@class='nav-header ']")).isDisplayed();
        List<WebElement> headerList = driver.findElements(By.xpath("//li[@class='list-item']"));
        for (WebElement webElement: headerList) {
            System.out.println(webElement.getText());
        }
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.logout();

    }

    @Test
    public void headerSectionFunctionalities() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        loginPage.loginButton.click();
        driver.findElement(By.xpath("//a[normalize-space()='Popular']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//img[@alt='profile']")).click();
        driver.navigate().back();
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.logout();
    }

}
