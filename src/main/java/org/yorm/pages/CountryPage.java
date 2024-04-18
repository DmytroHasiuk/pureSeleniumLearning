package org.yorm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountryPage extends BasePage {

    private WebElement chooseCountryLabel;

    public CountryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        chooseCountryLabel = driver.findElement(By.tagName("label"));
        return chooseCountryLabel.isDisplayed();
    }
}
