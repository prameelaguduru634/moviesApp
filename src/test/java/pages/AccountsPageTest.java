package pages;

import com.movie.pages.AccountsPage;
import com.movie.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountsPageTest {

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
    public void accountsPage() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        AccountsPage accountsPage = new AccountsPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        loginPage.loginButton.click();
        accountsPage.profile.click();
        accountsPage.membershipHeading.isDisplayed();
        accountsPage.accountHeading.isDisplayed();
        accountsPage.membershipUsername.isDisplayed();
        accountsPage.membershipPassword.isDisplayed();
        accountsPage.planDetails.isDisplayed();
        accountsPage.logoutButton.click();





    }
}
