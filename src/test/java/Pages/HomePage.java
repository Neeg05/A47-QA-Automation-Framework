package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement playlist;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement editSelection;
    @FindBy(css = "[name='name']")
    private WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement updateMessage;
    @FindBy(css = "img.avatar")
    private WebElement avatar;

    public HomePage selectPlaylist(){
        findElement(playlist);
        contextClick(playlist);
        return this;
    }
    public HomePage selectEdit(){
        findElement(editSelection);
        click(editSelection);
        return this;
    }
    public HomePage enterName(String name){
        findElement(editField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement avatarIcon(){
        return findElement(avatar);

    }
    public String verifications(){
        return findElement(updateMessage).getText();
    }
}

