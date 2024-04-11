import org.apache.commons.lang3.StringUtils;
import org.yorm.pages.LocatorsPracticePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.yorm.constants.Constants.USER_WITHOUT_PASS;
import static org.yorm.constants.Constants.USER_WITH_CORRECT_PASS;
import static org.yorm.constants.Constants.USER_WITH_WRONG_PASS;

public class LoginTests {

    private static final String NEEDED_PASSWORD = "rahulshettyacademy";

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void errorMassageAppearance() {
        LocatorsPracticePage page = new LocatorsPracticePage(driver);
        Assert.assertTrue(page.isPageLoaded());
        page.enterUserDataToLogin(USER_WITH_WRONG_PASS);
        page.clickSignInButton();
        Assert.assertTrue(page.isErrorMessageDisplayed());

    }

    @Test
    public void getResetLogin(){
        LocatorsPracticePage page = new LocatorsPracticePage(driver);
        Assert.assertTrue(page.isPageLoaded());
        page.clickForgotPassLink();
        page.enterUserDataToRestorePass(USER_WITHOUT_PASS);
        page.clickResetLoginButton();
        Assert.assertTrue(StringUtils.equalsIgnoreCase(NEEDED_PASSWORD, page.getPassword()));
    }

    @Test
    public void successfulLogin(){
        LocatorsPracticePage page = new LocatorsPracticePage(driver);
        Assert.assertTrue(page.isPageLoaded());
        page.enterUserDataToLogin(USER_WITH_CORRECT_PASS);
        page.clickSignInButton();
        Assert.assertTrue(page.isUserLogin());
        Assert.assertTrue(page.isUsernameCorrect(USER_WITH_CORRECT_PASS));
    }

    @Test
    public void successfulLogout(){
        LocatorsPracticePage page = new LocatorsPracticePage(driver);
        Assert.assertTrue(page.isPageLoaded());
        page.enterUserDataToLogin(USER_WITH_CORRECT_PASS);
        page.clickSignInButton();
        page.clickLogOutBtn();
        Assert.assertTrue(page.isPageLoaded());
    }

    @Test
    public void resetUserAndLogIn(){
        LocatorsPracticePage page = new LocatorsPracticePage(driver);
        Assert.assertTrue(page.isPageLoaded());
        page.clickForgotPassLink();
        page.enterUserDataToRestorePass(USER_WITHOUT_PASS);
        page.clickResetLoginButton();
        USER_WITHOUT_PASS.setPassword(page.getPassword());
        page.clickGoToLoginButton();
        Assert.assertTrue(page.isPageLoaded());
        page.enterUserDataToLogin(USER_WITHOUT_PASS);
        page.clickSignInButton();
        Assert.assertTrue(page.isUserLogin());
        Assert.assertTrue(page.isUsernameCorrect(USER_WITHOUT_PASS));
    }

    @AfterMethod
    public void endUp(){
        driver.quit();
    }
}
