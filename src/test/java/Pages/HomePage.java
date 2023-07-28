package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement selectPlaylist;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement selectEdit;
    @FindBy(css = "[name='name']")
    private WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement updateMessage;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage contextClickFirstPlaylist(){
        findElement(selectPlaylist);
        contextClick(selectPlaylist);
        return this;
    }
    public HomePage editSelection(){
        click(selectEdit);
        return this;
    }
    public HomePage editName(String name){
        findElement(editField);
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public String verificationMessage(){
        return findElement(updateMessage).getText();
    }
}