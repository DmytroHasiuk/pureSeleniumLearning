import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yorm.pages.AlertPractisePage;

import java.time.Duration;

public class AlertTests {

    WebDriver driver;

    private final String NAME = "Dima";

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void alertTest(){
        AlertPractisePage page = new AlertPractisePage(driver);
        page.typeToInputNameField(NAME);
        page.clickAlertBtn();
        Assert.assertTrue(StringUtils.containsIgnoreCase(page.getTextFromAlert(), NAME));
        page.clickOkOnAlertWindow();
        page.typeToInputNameField(NAME);
        page.clickConfirmBtn();
        Assert.assertTrue(StringUtils.containsIgnoreCase(page.getTextFromAlert(), NAME));
        page.clickDeclineOnAlertWindow();
    }

    @AfterMethod
    public void endUp(){
        driver.quit();
    }
}
