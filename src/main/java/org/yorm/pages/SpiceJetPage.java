package org.yorm.pages;

import org.openqa.selenium.WebDriver;
import org.yorm.pages.components.CurrencyMenu;

public class SpiceJetPage extends BasePage{

    CurrencyMenu currencyMenu;

    public SpiceJetPage(WebDriver driver) {
        super(driver);
        currencyMenu = new CurrencyMenu(driver, explicitWait);
    }

    public CurrencyMenu getCurrencyMenu() {
        return currencyMenu;
    }
}
