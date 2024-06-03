package com.movie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

        public WebDriver driver;
        public SearchPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }


    @FindBy(xpath = "//input[@id='search']")
    public WebElement search;

    @FindBy(xpath = "//button[@class='search-empty-button']")
    public WebElement searchEmptyButton;

    @FindBy(xpath = "//button[@class='search-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//ul[@class='search-movies-container']")
    public WebElement moviesContainer;

    public void enterTextInSearch(String text) {
        searchEmptyButton.click();
        search.clear();
        search.sendKeys(text);
        searchButton.click();
    }
}
