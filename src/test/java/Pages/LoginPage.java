package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    protected String url;

    @FindBy(css = "[value='Register']")
    private WebElement regButton;
    @FindBy(css = "#hel")
    private WebElement registrationLink;
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public LoginPage getRegistered(){
        findElement(registrationLink);
        click(registrationLink);
        return this;
    }
    public WebElement registerButton(){
        return findElement(regButton);
    }

    public LoginPage enterEmail(String email){
        findElement(emailField);
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        findElement(passwordField);
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        click(submitButton);
        return this;
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
