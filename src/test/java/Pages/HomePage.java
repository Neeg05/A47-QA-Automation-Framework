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
    private WebElement contextPlaylist;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement clickEdit;
    @FindBy(css = "[name='name']")
    private WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement messageBox;

    public HomePage contextClick(){
        findElement(contextPlaylist);
        contextClick(contextPlaylist);
        return this;
    }
    public HomePage selectEdit(){
        findElement(clickEdit);
        click(clickEdit);
        return this;
    }
    public HomePage editName(String name){
        findElement(editField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public String popUP(){
        return findElement(messageBox).getText();


    }
}