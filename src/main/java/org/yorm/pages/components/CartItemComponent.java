package org.yorm.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yorm.enums.Product;

public class CartItemComponent extends BaseComponent {

    private WebElement productQnt;

    private WebElement totalPrice;

    private WebElement deleteProduct;

    public CartItemComponent(WebDriver driver, String xpath, Product product) {
        super(driver);
        this.xpath = xpath +
                String.format("//li//p[contains(text(), '%s')]/parent::div/parent::li", product.getName());
    }

    public boolean isCartComponentExist() {
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath(getXpath()));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getQuantity() {
        productQnt = driver.findElement(By.xpath(getXpath() + "//p[@class='quantity']"));
        return Integer.parseInt(String.valueOf(productQnt.getText().charAt(0)));
    }

    public int getTotalPrice() {
        totalPrice = driver.findElement(By.xpath(getXpath() + "//p[@class='amount']"));
        String price = totalPrice.getText();
        return Integer.parseInt(price);
    }

    public void deleteProduct() {
        deleteProduct = driver.findElement(By.xpath(getXpath() + "//a"));
        deleteProduct.click();
    }
}
