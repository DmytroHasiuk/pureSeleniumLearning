import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.yorm.enums.Currency;
import org.yorm.exceptions.NoSuchCurrencyException;
import org.yorm.pages.ClickJetPage;

import java.time.Duration;

public class ClickJetTests {
    WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(ClickJetTests.class);

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void staticDropdownTest(){
        ClickJetPage page = new ClickJetPage(driver);
        Assert.assertTrue(page.isPageOpened());
        try {
            page.selectCurrency(Currency.INR);
        } catch (NoSuchCurrencyException e) {
            LOGGER.error(e.getMessage());
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Currency.INR.getText(), page.getCurrentCurrencySelected());
        try {
            page.selectCurrency(Currency.AED);
        } catch (NoSuchCurrencyException e) {
            LOGGER.error(e.getMessage());
        }
        softAssert.assertEquals(Currency.AED.getText(), page.getCurrentCurrencySelected());
        try {
            page.selectCurrency(Currency.USD);
        } catch (NoSuchCurrencyException e) {
            LOGGER.error(e.getMessage());
        }
        softAssert.assertEquals(Currency.USD.getText(), page.getCurrentCurrencySelected());
        softAssert.assertAll();
    }

    @Test
    public void staticDropdownWithError(){
        ClickJetPage page = new ClickJetPage(driver);
        Assert.assertTrue(page.isPageOpened());
        try {
            page.selectCurrency(Currency.THB);
            Assert.fail("Such currency is give no exception");
        } catch (NoSuchCurrencyException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void endUp(){
        driver.quit();
    }
}
