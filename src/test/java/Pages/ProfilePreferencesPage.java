package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePreferencesPage extends BasePage{

    @FindBy(css = ".logout.control")
    protected WebElement logoutBtn;

    public ProfilePreferencesPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public BasePage logUserOut(){
        findElement(logoutBtn);
        click(logoutBtn);
        return this;
    }
}