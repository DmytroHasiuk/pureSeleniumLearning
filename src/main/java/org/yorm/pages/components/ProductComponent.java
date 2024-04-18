package org.yorm.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yorm.enums.Product;

public class ProductComponent extends BaseComponent {

    private WebElement price;

    private WebElement minusQntBtn;

    private WebElement plusQntBtn;

    private WebElement quantity;

    private WebElement addToCartBtn;

    public ProductComponent(WebDriver driver, Product product) {
        super(driver);
        xpath = String.format("//div[@class='product']/h4[contains(text(), '%s')]/parent::div", product.getName());
    }

    public int getProductPrice() {
        price = driver.findElement(By.xpath(getXpath() + "/p"));
        return Integer.parseInt(price.getText());
    }

    public void clickPlusQntBtn() {
        plusQntBtn = driver.findElement(By.xpath(getXpath() + "//a[@class='increment']"));
        plusQntBtn.click();
    }

    public void clickMinusQntBtn() {
        minusQntBtn = driver.findElement(By.xpath(getXpath() + "//a[@class='decrement']"));
        minusQntBtn.click();
    }

    public void clickAddToCartBtn() {
        addToCartBtn = driver.findElement(By.xpath(getXpath() + "//button"));
        addToCartBtn.click();
    }

    public int getCurrentQnt() {
        quantity = driver.findElement(By.xpath(getXpath() + "//input"));
        return Integer.parseInt(quantity.getAttribute("value"));
    }
}
