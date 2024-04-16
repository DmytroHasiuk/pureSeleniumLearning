package org.yorm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPractisePage extends BasePage{

    private WebElement alertBtn;

    private WebElement confirmBtn;

    private WebElement inputNameField;

    public AlertPractisePage(WebDriver driver) {
        super(driver);
        this.alertBtn = driver.findElement(By.id("alertbtn"));
        this.confirmBtn = driver.findElement(By.id("confirmbtn"));
        this.inputNameField = driver.findElement(By.id("name"));
    }

    public void clickAlertBtn(){
        alertBtn.click();
    }

    public void clickConfirmBtn(){
        confirmBtn.click();
    }

    public void typeToInputNameField(String text){
        inputNameField.sendKeys(text);
    }

    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }

    public void clickOkOnAlertWindow(){
        driver.switchTo().alert().accept();
    }

    public void clickDeclineOnAlertWindow(){
        driver.switchTo().alert().dismiss();
    }
}
