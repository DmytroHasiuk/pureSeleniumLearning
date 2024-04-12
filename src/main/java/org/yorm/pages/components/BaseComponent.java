package org.yorm.pages.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yorm.exceptions.NullXpathException;

public abstract class BaseComponent {
    private static final Logger LOGGER = LogManager.getLogger(BaseComponent.class);

    protected String xpath;

    protected WebDriver driver;

    protected WebDriverWait explicitWait;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    public BaseComponent(WebDriver driver, WebDriverWait explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }

    protected String getXpath() {
        if (StringUtils.isEmpty(xpath)) try {
            throw new NullXpathException();
        } catch (NullXpathException e) {
            LOGGER.warn(e.getMessage());
        }
        return xpath;
    }

    public void click(){
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(getXpath()))).click();
    }
}
