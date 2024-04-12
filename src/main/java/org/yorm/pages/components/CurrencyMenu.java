package org.yorm.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yorm.enums.Currency;

public class CurrencyMenu extends BaseComponent{

    private WebElement currentCurrency;

    private WebElement currencyToChoose;


    public CurrencyMenu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        xpath = "//div[@style='flex: 0.3 1 0%; margin-left: 10px;']";
    }

    public String getCurrentCurrency(){
        currentCurrency =driver.findElement(By.xpath(getXpath() + "//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']"));
        return currentCurrency.getText();
    }

    public void clickCurrency(Currency currency){
        String xpath = String.format("%s//div[@style='height: 200px; width: 140px;']//div[contains(text(), '%s')]", getXpath(), currency.getText());
        currencyToChoose = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        currencyToChoose.click();
    }
}
