package org.yorm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yorm.enums.Product;

public class CheckOutPage extends BasePage {

    private WebElement productName;

    private WebElement productQnt;

    private WebElement totalAmountOfProducts;

    private WebElement totalPrice;

    private WebElement placeOrderBtn;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPresentOnThePage(Product product) {
        String xpath = String.format("//p[contains(text(), '%s')]", product.getName());
        try {
            productName = driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getProductQnt(Product product) {
        String xpath = String.format("//p[contains(text(), '%s')]/parent::td/following-sibling::td[1]", product.getName());
        productQnt = driver.findElement(By.xpath(xpath));
        return Integer.parseInt(productQnt.getText());
    }

    public boolean isPageOpened() {
        placeOrderBtn = driver.findElement(By.xpath("//button[text()='Place Order']"));
        return placeOrderBtn.isDisplayed();
    }

    public CountryPage clickPlaceOrderBtn() {
        placeOrderBtn = driver.findElement(By.xpath("//button[text()='Place Order']"));
        placeOrderBtn.click();
        return new CountryPage(driver);
    }

    public int getTotalProductsQnt() {
        totalAmountOfProducts = driver.findElement(By.xpath("//div[@class='products']/div"));
        String totalAmount = totalAmountOfProducts.getText().split("\n")[1];
        return Integer.parseInt(String.valueOf(totalAmount.charAt(totalAmount.length() - 1)));
    }

    public int getTotalPrice() {
        totalPrice = driver.findElement(By.className("totAmt"));
        return Integer.parseInt(totalPrice.getText());
    }
}
