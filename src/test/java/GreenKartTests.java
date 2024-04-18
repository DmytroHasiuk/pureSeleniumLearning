import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yorm.enums.Product;
import org.yorm.exceptions.CartIsEmptyException;
import org.yorm.exceptions.NoSuchProductException;
import org.yorm.pages.CheckOutPage;
import org.yorm.pages.CountryPage;
import org.yorm.pages.GreenCardPage;
import org.yorm.pages.components.ProductComponent;

import java.time.Duration;

public class GreenKartTests {

    private static final Logger LOGGER = LogManager.getLogger(ClickJetTests.class);
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    public void productsPriceCheck() {
        GreenCardPage page = new GreenCardPage(driver);
        try {
            Assert.assertEquals(200, page.getProductComponent(Product.ALMONDS).getProductPrice());
            Assert.assertEquals(48, page.getProductComponent(Product.CUCUMBER).getProductPrice());
        } catch (NoSuchProductException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Test
    public void buyProductsTest() {
        GreenCardPage page = new GreenCardPage(driver);
        Assert.assertTrue(page.isPageOpened());
        page.clickCartBtn();
        Assert.assertTrue(page.getCartPreviewComponent().isCartPreviewComponentOpened());
        Assert.assertTrue(page.getCartPreviewComponent().isCartEmpty());
        page.clickCartBtn();
        Assert.assertFalse(page.getCartPreviewComponent().isCartPreviewComponentOpened());
        try {
            ProductComponent watermelon = page.getProductComponent(Product.WATER_MELON);
            watermelon.clickPlusQntBtn();
            watermelon.clickAddToCartBtn();
            page.clickCartBtn();
            Assert.assertEquals(1, page.getItemsInCartQuantity());
            Assert.assertEquals(56, page.getPriceCartCost());
            Assert.assertTrue(page.getCartPreviewComponent().isCartPreviewComponentOpened());
            Assert.assertFalse(page.getCartPreviewComponent().isCartEmpty());
            page.clickCartBtn();
            Assert.assertFalse(page.getCartPreviewComponent().isCartPreviewComponentOpened());
            ProductComponent apple = page.getProductComponent(Product.APPLE);
            apple.clickAddToCartBtn();
            Assert.assertEquals(2, page.getItemsInCartQuantity());
            Assert.assertEquals(128, page.getPriceCartCost());
            page.clickCartBtn();
            Assert.assertTrue(page.getCartPreviewComponent().isCartPreviewComponentOpened());
            page.clickCartBtn();
            ProductComponent orange = page.getProductComponent(Product.ORANGE);
            orange.clickPlusQntBtn();
            orange.clickMinusQntBtn();
            Assert.assertEquals(1, orange.getCurrentQnt());
            orange.clickAddToCartBtn();
            page.clickCartBtn();
            Assert.assertTrue(page.getCartPreviewComponent().getCartItemComponent(Product.ORANGE).isCartComponentExist());
            Assert.assertTrue(page.getCartPreviewComponent().getCartItemComponent(Product.APPLE).isCartComponentExist());
            Assert.assertTrue(page.getCartPreviewComponent().getCartItemComponent(Product.WATER_MELON).isCartComponentExist());
            Assert.assertFalse(page.getCartPreviewComponent().getCartItemComponent(Product.MUSHROOM).isCartComponentExist());
            Assert.assertEquals(1, page.getCartPreviewComponent().getCartItemComponent(Product.ORANGE).getQuantity());
            Assert.assertEquals(75, page.getCartPreviewComponent().getCartItemComponent(Product.ORANGE).getTotalPrice());
            page.getCartPreviewComponent().getCartItemComponent(Product.ORANGE).deleteProduct();
            Assert.assertFalse(page.getCartPreviewComponent().getCartItemComponent(Product.ORANGE).isCartComponentExist());
            CheckOutPage checkOutPage = page.getCartPreviewComponent().clickProceedToCheckoutBtn();
            Assert.assertTrue(checkOutPage.isPageOpened());
            Assert.assertTrue(checkOutPage.isProductPresentOnThePage(Product.WATER_MELON));
            Assert.assertEquals(2, checkOutPage.getProductQnt(Product.WATER_MELON));
            Assert.assertTrue(checkOutPage.isProductPresentOnThePage(Product.APPLE));
            Assert.assertEquals(1, checkOutPage.getProductQnt(Product.APPLE));
            Assert.assertEquals(2, checkOutPage.getTotalProductsQnt());
            Assert.assertEquals(128, checkOutPage.getTotalPrice());
            CountryPage countryPage = checkOutPage.clickPlaceOrderBtn();
            Assert.assertTrue(countryPage.isPageOpened());

        } catch (NoSuchProductException | CartIsEmptyException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void endUp() {
        driver.quit();
    }
}
