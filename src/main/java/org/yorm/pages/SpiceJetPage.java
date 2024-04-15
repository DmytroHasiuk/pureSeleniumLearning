package org.yorm.pages;

import org.openqa.selenium.WebDriver;
import org.yorm.pages.components.CurrencyMenu;
import org.yorm.pages.components.PassengerMenu;

public class SpiceJetPage extends BasePage{

    CurrencyMenu currencyMenu;

    PassengerMenu passengerMenu;

    public SpiceJetPage(WebDriver driver) {
        super(driver);
        currencyMenu = new CurrencyMenu(driver, explicitWait);
        passengerMenu = new PassengerMenu(driver, explicitWait);
    }

    public CurrencyMenu getCurrencyMenu() {
        return currencyMenu;
    }

    public PassengerMenu getPassengerMenu() {
        return passengerMenu;
    }
}
