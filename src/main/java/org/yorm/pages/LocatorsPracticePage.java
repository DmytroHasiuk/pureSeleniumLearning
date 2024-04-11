package org.yorm.pages;

import org.apache.commons.lang3.StringUtils;
import org.yorm.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LocatorsPracticePage extends BasePage{

    private final WebElement inputLoginForm;

    private WebElement passwordForm;
    
    private WebElement signInButton;

    private WebElement signInTittle;

    private WebElement errorMessage;

    private WebElement forgotPassLink;

    private WebElement nameForm;

    private WebElement emailForm;

    private WebElement phoneNumberForm;

    private WebElement resetLoginBtn;

    private WebElement goToLoginBtn;

    private WebElement infoMsgWithPass;

    private WebElement logOutBtn;

    private WebElement titleWithUsername;

    private WebElement successfulLoginMsg;

    public LocatorsPracticePage(WebDriver driver) {
        super(driver);
        this.inputLoginForm = this.driver.findElement(By.id("inputUsername"));
        this.passwordForm = this.driver.findElement(By.name("inputPassword"));
        this.forgotPassLink = this.driver.findElement(By.linkText("Forgot your password?"));
    }

    public void clickSignInButton(){
        signInButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
        try {
            signInButton.click();
        }
        catch (ElementClickInterceptedException e) {
            signInButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
            signInButton.click();
        }
    }

    public void clickLogOutBtn(){
        logOutBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("logout-btn")));
        logOutBtn.click();
    }

    public void clickForgotPassLink(){
        forgotPassLink.click();
    }

    public String getPassword(){
        infoMsgWithPass = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("infoMsg")));
        return infoMsgWithPass.getText().split("'")[1];
    }

    private void enterNameToInputForm(String name){
        nameForm = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
        nameForm.sendKeys(name);
    }

    private void enterEmailToInputForm(String email){
        emailForm = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        emailForm.sendKeys(email);
    }

    private void enterPhoneNumberInputForm(String phoneNumber){
        phoneNumberForm = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone Number']")));
        phoneNumberForm.sendKeys(phoneNumber);
    }

    public void clickResetLoginButton(){
        resetLoginBtn = this.explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("reset-pwd-btn")));
        resetLoginBtn.click();
    }

    public void clickGoToLoginButton(){
        goToLoginBtn = explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("go-to-login-btn")));
        goToLoginBtn.click();
    }

    public void enterUserDataToLogin(User user){
        enterTextToInputForm(user.getName());
        enterTextToPasswordForm(user.getPassword());
    }

    public void enterUserDataToRestorePass(User user){
        enterNameToInputForm(user.getName());
        enterEmailToInputForm(user.getEmail());
        enterPhoneNumberInputForm(user.getPhoneNumber());
    }

    public boolean isPageLoaded(){
        signInTittle = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form.form h1")));
        return  signInTittle.isDisplayed();
    }

    public boolean isUserLogin(){
        successfulLoginMsg = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/p")));
        return successfulLoginMsg.isDisplayed();
    }

    public boolean isUsernameCorrect(User user){
        titleWithUsername = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-container h2")));
        return StringUtils.containsIgnoreCase(titleWithUsername.getText(), user.getName());
    }

    private void enterTextToInputForm(String text){
        inputLoginForm.sendKeys(text);
    }

    private void enterTextToPasswordForm(String text){
        passwordForm.sendKeys(text);
    }

    public boolean isErrorMessageDisplayed(){
        errorMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
        return errorMessage.isDisplayed();
    }
}
