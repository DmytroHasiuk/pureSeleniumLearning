package org.yorm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yorm.enums.Product;
import org.yorm.exceptions.NoSuchProductException;
import org.yorm.pages.components.CartPreviewComponent;
import org.yorm.pages.components.ProductComponent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreenCardPage extends BasePage {

    private WebElement logo;

    private ProductComponent productComponent;

    private WebElement itemsCartQuantity;

    private WebElement priceCartCost;

    private WebElement cartItemsBtn;

    private CartPreviewComponent cartPreviewComponent;

    public GreenCardPage(WebDriver driver) {
        super(driver);
        this.cartPreviewComponent = new CartPreviewComponent(driver);
    }

    public int getItemsInCartQuantity() {
        itemsCartQuantity = driver.findElement(
                By.xpath("//div[@class='cart-info']//td[contains(text(), 'Items')]/following-sibling::td[2]/strong"));
        return Integer.parseInt(itemsCartQuantity.getText());
    }

    public int getPriceCartCost() {
        priceCartCost = driver.findElement(
                By.xpath("//div[@class='cart-info']//td[contains(text(), 'Price')]/following-sibling::td[2]"));
        return Integer.parseInt(priceCartCost.getText());
    }

    public void clickCartBtn() {
        cartItemsBtn = driver.findElement(By.cssSelector("img[alt='Cart']"));
        cartItemsBtn.click();
    }

    public ProductComponent getProductComponent(Product product) throws NoSuchProductException {
        List<Product> products = Arrays.stream(Product.values()).collect(Collectors.toList());
        if (!products.contains(product)) throw new NoSuchProductException();
        return new ProductComponent(driver, product);
    }

    public boolean isPageOpened() {
        logo = driver.findElement(By.cssSelector(".brand.greenLogo"));
        return logo.isDisplayed();
    }

    public CartPreviewComponent getCartPreviewComponent() {
        return cartPreviewComponent;
    }
}
