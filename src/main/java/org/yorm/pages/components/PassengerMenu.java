package org.yorm.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yorm.exceptions.MoreThanOneInfantException;

public class PassengerMenu extends BaseComponent{

    private WebElement adultMinusBtn;

    private WebElement adultPlusBtn;

    private WebElement currentAdultQuantity;

    private WebElement childrenMinusBtn;

    private WebElement childrenPlusBtn;

    private WebElement currentChildrenQuantity;

    private WebElement infantMinusBtn;

    private WebElement infantPlusBtn;

    private WebElement currentInfantQuantity;

    private WebElement doneBtn;

    private WebElement popUpMenu;

    public PassengerMenu(WebDriver driver, WebDriverWait explicitWait) {
        super(driver, explicitWait);
        xpath = "//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div[1]";
    }

    public boolean isPopUpMenuOpened(){
        popUpMenu = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getXpath() + "//div[@style='height: 250px;']")));
        return popUpMenu.isDisplayed();
    }

    public boolean isPopUpMenuClosed(){
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath(getXpath() + "//div[@style='height: 250px;']")));
    }

    public int getCurrentAdultsQnt(){
        currentAdultQuantity = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getXpath() + "//div[@data-testid='Adult-testID-minus-one-cta']/parent::div/div[2]")));
        return Integer.parseInt(currentAdultQuantity.getText());
    }

    public int getCurrentChildrenQnt(){
        currentChildrenQuantity = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getXpath() + "//div[@data-testid='Children-testID-minus-one-cta']/parent::div/div[2]")));
        return Integer.parseInt(currentChildrenQuantity.getText());
    }

    public int getCurrentInfantQnt(){
        currentInfantQuantity = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getXpath() + "//div[@data-testid='Infant-testID-minus-one-cta']/parent::div/div[2]")));
        return Integer.parseInt(currentInfantQuantity.getText());
    }

    public void clickDoneBtn(){
        doneBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='home-page-travellers-done-cta']")));
        doneBtn.click();
    }

    public void clickAdultMinusBtn(){
        adultMinusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Adult-testID-minus-one-cta']")));
        adultMinusBtn.click();
    }

    public void clickAdultPlusBtn(){
        adultPlusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Adult-testID-plus-one-cta']")));
        adultPlusBtn.click();
    }

    public void clickChildrenMinusBtn(){
        childrenMinusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Children-testID-minus-one-cta']")));
        childrenMinusBtn.click();
    }

    public void clickChildrenPlusBtn(){
        childrenPlusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Children-testID-plus-one-cta']")));
        childrenPlusBtn.click();
    }

    public void clickInfantMinusBtn(){
        infantMinusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Infant-testID-minus-one-cta']")));
        infantMinusBtn.click();
    }

    public void clickInfantPlusBtn(){
        infantPlusBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(getXpath() + "//div[@data-testid='Infant-testID-plus-one-cta']")));
        infantPlusBtn.click();
    }

    public void setAdultQuantity(int quantity){
        while (quantity != getCurrentAdultsQnt()){
            if (quantity > getCurrentAdultsQnt()) clickAdultPlusBtn();
            else clickAdultMinusBtn();
        }
    }

    public void setChildrenQuantity(int quantity){
        while (quantity != getCurrentChildrenQnt()){
            if (quantity > getCurrentChildrenQnt()) clickChildrenPlusBtn();
            else clickChildrenMinusBtn();
        }
    }

    public void setInfantQuantity(int quantity) throws MoreThanOneInfantException {
        if (quantity > 1) throw new MoreThanOneInfantException();
        else if (quantity == 1) clickInfantPlusBtn();
        else  clickInfantMinusBtn();
    }
}
