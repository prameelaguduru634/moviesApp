package com.movie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//button[@class = 'home-movie-play-button']")
    public WebElement playButton;

    @FindBy(xpath = "//p[@class = 'contact-us-paragraph']")
    public WebElement contactUs;

    @FindBy(xpath = "//h1[normalize-space()='Trending Now']")
    public WebElement trendingNow;

    public void checkElementHead(WebElement element) {
        System.out.println("Home Button is Displayed:" +element.isDisplayed());
    }

    public void checkAnyElementFindOrNot(WebElement element) {
        if(element.isDisplayed()) {
            System.out.println("Element Found:" + element.getText()+" is Displayed");
        }else{
            System.out.println("Element not Found:" + element.getText()+" is not Displayed");
        }

    }

}
