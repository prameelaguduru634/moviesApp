package pages;

import com.movie.pages.LoginPage;
import com.movie.pages.MovieDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {

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
    public void moviesDetailsPageTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        MovieDetailsPage movieDetailsPage = new MovieDetailsPage(driver);
        loginPage.enterLoginDetails("rahul", "rahul@2021");
        loginPage.loginButton.click();
        movieDetailsPage.movieTab.click();
        movieDetailsPage.movieDuration.isDisplayed();
        movieDetailsPage.releaseYear.isDisplayed();
        movieDetailsPage.playButton.isDisplayed();

    }
}
