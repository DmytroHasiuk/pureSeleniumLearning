import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yorm.enums.Currency;
import org.yorm.pages.SpiceJetPage;

import java.time.Duration;

public class SpiceJetTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void chooseEachCurrency(){
        SpiceJetPage page = new SpiceJetPage(driver);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.INR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "Default currency is not INR");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.AED);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.AED.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "AED currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.USD);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.USD.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "USD currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.EUR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.EUR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "EUR currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.GBP);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.GBP.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "GBP currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.CAD);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.CAD.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "CAD currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.BDT);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.BDT.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "BDT currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.SGD);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.SGD.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "SGD currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.OMR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.OMR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "OMR currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.THB);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.THB.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "THB currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.CNY);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.CNY.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "CNY currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.HKD);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.HKD.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "HKD currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.MYR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.MYR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "MYR currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.SAR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.SAR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "SAR currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.LKR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.LKR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "LKR currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.KWD);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.KWD.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "KWD currency is not chosen");
        page.getCurrencyMenu().click();
        page.getCurrencyMenu().clickCurrency(Currency.INR);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(Currency.INR.getText(), page.getCurrencyMenu().getCurrentCurrency()),
                "INR currency is not chosen");

    }

    @AfterMethod
    public void endUp(){
        driver.quit();
    }
}
