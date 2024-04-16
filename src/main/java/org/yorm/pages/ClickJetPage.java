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

    private WebElement familyAndFriendsCheckbox;

    private WebElement seniorCitizenCheckbox;

    private WebElement indianArmyForceCheckBox;

    private WebElement studentCheckbox;

    private WebElement unaccompaniedMinorCheckbox;

    public ClickJetPage(WebDriver driver) {
        super(driver);
        this.currencyDropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_DropDownListCurrency")));
        this.currencyDropdownSelect = new Select(currencyDropdown);
        this.flightSection = driver.findElement(By.className("book_flight"));
        this.countyInput = driver.findElement(By.id("autosuggest"));
        this.familyAndFriendsCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        this.seniorCitizenCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        this.indianArmyForceCheckBox = driver.findElement(By.id("ctl00_mainContent_chk_IndArm"));
        this.studentCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
        this.unaccompaniedMinorCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_Unmr"));
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

    public void clickFamilyAndFriendsCheckbox(){
        familyAndFriendsCheckbox.click();
    }

    public void clickSeniorCitizenCheckbox(){
        seniorCitizenCheckbox.click();
    }

    public void clickIndianArmedForcesCheckbox(){
        indianArmyForceCheckBox.click();
    }

    public void clickStudentCheckbox(){
        studentCheckbox.click();
    }

    public void clickUnaccompaniedMinorCheckbox(){
        unaccompaniedMinorCheckbox.click();
    }

    public boolean isFamilyAndFriendsCheckboxSelected(){
        return familyAndFriendsCheckbox.isSelected();
    }

    public boolean isSeniorCitizenCheckboxSelected(){
        return seniorCitizenCheckbox.isSelected();
    }

    public boolean isIndianArmedForcesCheckboxSelected(){
        return indianArmyForceCheckBox.isSelected();
    }

    public boolean isStudentCheckboxSelected(){
        return studentCheckbox.isSelected();
    }

    public boolean isUnaccompaniedMinorCheckboxSelected(){
        return unaccompaniedMinorCheckbox.isSelected();
    }
}
