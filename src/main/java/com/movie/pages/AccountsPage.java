package com.movie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

    public WebDriver driver;
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='profile']")
    public WebElement profile;

    @FindBy(xpath = "//button[@class='logout-button']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h1[@class ='account-heading']")
    public WebElement accountHeading;

    @FindBy(xpath = "//p[@class = 'membership-heading']")
    public WebElement membershipHeading;

    @FindBy(xpath = "//p[@class = 'membership-username']")
    public WebElement membershipUsername;

    @FindBy(xpath = "//p[@class='membership-password']")
    public WebElement membershipPassword;

    @FindBy(xpath = "//p[@class='plan-details']")
    public WebElement planDetails;


    public void logout() {
        profile.click();
        logoutButton.click();
    }
}
