package com.movie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        public WebDriver driver;
        public LoginPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//img[@alt='login website logo']")
        public WebElement logo;

        @FindBy(xpath = "//h1[normalize-space()='Login']")
        public WebElement loginText;

        @FindBy(xpath = "//label[normalize-space()='USERNAME']")
        public WebElement usernameText;

        @FindBy(xpath = "//input[@id='usernameInput']")
        public WebElement usernameInput;

        @FindBy(xpath = "//label[normalize-space()='PASSWORD']")
        public WebElement passwordText;

        @FindBy(xpath = "//input[@id='passwordInput']")
        public WebElement passwordInput;

        @FindBy(xpath = "//button[normalize-space()='Login']")
        public WebElement loginButton;

        public void checkLogo(WebElement element) {
                if (element.isDisplayed()) {
                        System.out.println("Logo Displayed");
                }else{
                        System.out.println("Logo not Displayed");
                }

        }

        public void checkLoginText(WebElement element) {
                if (element.isDisplayed()) {
                        System.out.println("Login Text Displayed");
                }else {
                        System.out.println("Login Text Not Displayed");
                }
        }

        public void enterLoginDetails(String username, String password) {
                usernameInput.clear();
                passwordInput.clear();
                usernameInput.sendKeys(username);
                passwordInput.sendKeys(password);
        }

}

