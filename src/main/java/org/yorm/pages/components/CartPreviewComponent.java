package org.yorm.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yorm.enums.Product;
import org.yorm.exceptions.CartIsEmptyException;
import org.yorm.pages.CheckOutPage;

public class CartPreviewComponent extends BaseComponent {

    private WebElement emptyCart;

    private WebElement proceedToCheckoutBtn;

    private CartItemComponent cartItemComponent;

    public CartPreviewComponent(WebDriver driver) {
        super(driver);
        xpath = "//div[contains(@class, 'cart-preview')]";
    }

    public boolean isCartEmpty() {
        try {
            emptyCart = driver.findElement(By.xpath(getXpath() + "//div[@class='empty-cart']"));
            return emptyCart.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public CheckOutPage clickProceedToCheckoutBtn() throws CartIsEmptyException {
        proceedToCheckoutBtn = driver.findElement(By.xpath(getXpath() + "//button"));
        if (!proceedToCheckoutBtn.isEnabled()) throw new CartIsEmptyException();
        proceedToCheckoutBtn.click();
        return new CheckOutPage(driver);
    }

    public boolean isCartPreviewComponentOpened() {
        WebElement component = driver.findElement(By.xpath(getXpath()));
        return component.getAttribute("class").contains("active");
    }

    public CartItemComponent getCartItemComponent(Product product) {
        return new CartItemComponent(driver, getXpath(), product);
    }
}
