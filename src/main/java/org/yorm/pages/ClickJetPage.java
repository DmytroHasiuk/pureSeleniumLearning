package org.yorm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.yorm.enums.Currency;
import org.yorm.exceptions.NoSuchCountryException;
import org.yorm.exceptions.NoSuchCurrencyException;

import java.util.List;
import java.util.stream.Collectors;

public class ClickJetPage extends BasePage{

    private WebElement currencyDropdown;

    private Select currencyDropdownSelect;

    private WebElement countyInput;

    private WebElement flightSection;

    public ClickJetPage(WebDriver driver) {
        super(driver);
        this.currencyDropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_DropDownListCurrency")));
        this.currencyDropdownSelect = new Select(currencyDropdown);
        this.flightSection = driver.findElement(By.className("book_flight"));
        this.countyInput = driver.findElement(By.id("autosuggest"));
    }

    public void selectCurrency(Currency currency) throws NoSuchCurrencyException {
        switch (currency){
            case INR:
            case AED:
            case USD:
                currencyDropdownSelect.selectByValue(currency.getText());
                break;
            default:
                throw new NoSuchCurrencyException();
        }
    }

    public String getCurrentCurrencySelected(){
        return currencyDropdownSelect.getFirstSelectedOption().getText();
    }

    public boolean isPageOpened(){
        flightSection = explicitWait.until(ExpectedConditions.visibilityOf(flightSection));
        return flightSection.isDisplayed();
    }

    public void typeTextToCountyInput(String text){
        countyInput.clear();
        countyInput.sendKeys(text);
    }

    public String getTextFromCountryInput(){
        return countyInput.getAttribute("value");
    }

    public void selectCountryFromAutocompleteDropdown(String country) throws NoSuchCountryException {
        List<WebElement> countries = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("li.ui-menu-item a")));
        List<String> textCountries = countries.stream().map(WebElement::getText).collect(Collectors.toList());
        if (!textCountries.contains(country)) throw new NoSuchCountryException();
        else countries.stream().filter(el -> el.getText().equalsIgnoreCase(country)).collect(Collectors.toList()).get(0).click();
    }
}
