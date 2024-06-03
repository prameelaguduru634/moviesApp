package pages;

import com.movie.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

     public void checkHeadingText(WebElement element, String textString){

         Assert.assertEquals(element.getText(), textString, "Please verify once");
     }

     public void checkusername(WebElement element, String nameString) {

         Assert.assertEquals(element.getText(), nameString, "Please verify once");
     }

     public void checkpassword(WebElement element, String passwordString) {

         Assert.assertEquals(element.getText(), passwordString, "Please verify once");
     }

     public void checkErrorMessageOccured(WebElement element) {
         System.out.println(element.getText());
     }

    public WebDriver driver;
     public LoginPage loginpage;

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
    public void loginPageUI() throws Exception {

        loginpage = new LoginPage(driver);
        loginpage.checkLogo(loginpage.logo);
        checkHeadingText(loginpage.loginText,"Login");
        checkusername(loginpage.usernameText,"USERNAME");
        checkpassword(loginpage.passwordText,"PASSWORD");


    }

    @Test
    public void loginPage() throws Exception {
        loginpage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.loginButton)).click();
        checkErrorMessageOccured(driver.findElement(By.xpath("//p[@class='error-message']")));
        loginpage.enterLoginDetails("Prameela", "prameela123");
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.loginButton)).click();
        checkErrorMessageOccured(driver.findElement(By.xpath("//p[@class='error-message']")));
        loginpage.enterLoginDetails("rahul", "rahul@2021");
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.loginButton)).click();

    }
}
