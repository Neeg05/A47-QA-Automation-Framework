package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage enterEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submitButton.click();
        return this;
    }
}