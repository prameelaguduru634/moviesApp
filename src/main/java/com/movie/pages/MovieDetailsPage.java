package com.movie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsPage {

    public WebDriver driver;

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//img[@alt='No Time to Die']")
        public WebElement movieTab;

        @FindBy(xpath = "//p[@class='watch-time']")
        public WebElement movieDuration;

        @FindBy(xpath = "//p[@class='release-year']")
        public WebElement releaseYear;

        @FindBy(xpath = "//button[normalize-space()='Play']")
        public WebElement playButton;



}