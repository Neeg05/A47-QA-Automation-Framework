package Pages;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement playlistSelection;
    @FindBy(css = "nav > ul > li:nth-child(1)")
    private WebElement editSelection;
    @FindBy(css = "[name='name']")
    protected WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement messageBox;
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;
    @FindBy(css = ".del.btn-delete-playlist")
    private WebElement deletePlaylist;
    @FindBy(css = "#playlists > h1 > i")
    private WebElement newPlaylist;
    @FindBy(css = "#playlists > nav > ul > li:nth-child(1)")
    private WebElement selectNewPlaylist;
    @FindBy(css = ".ok")
    private WebElement okDeleteButton;

    public WebElement avatar(){
        return findElement(avatarIcon);
    }

    public HomePage selectRandomPlaylistHomePg(){
        for (int i = 1; i < 2; i++){
            List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists >ul >li")));
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(3, size);
            listItems.get(randomNumber).click();
        }
        return this;
    }
    public HomePage contextRandomPlaylistHmPg(){
        for (int i = 1; i < 2; i++) {
            List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists >ul >li")));
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(3, size);
            contextClick(listItems.get(randomNumber));
        }
        return this;
    }
    public HomePage clickFirstPlaylist(){
        findElement(playlistSelection);
        click(playlistSelection);
        return this;
    }
    public HomePage contextPlaylist(){
        findElement(playlistSelection);
        contextClick(playlistSelection);
        return this;
    }
    public HomePage selectEdit(){
        findElement(editSelection);
        click(editSelection);
        return this;
    }
    public HomePage editName(String randomName){
        findElement(editField);
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(randomName);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage clickDeleteButton(){
        waitToClick(deletePlaylist);
        click(deletePlaylist);
        return this;
    }
    public HomePage createPlaylist(){
        findElement(newPlaylist);
        click(newPlaylist);
        return this;
    }
    public HomePage newPlaylistSelection(){
        findElement(selectNewPlaylist);
        click(selectNewPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName(String name){
        findElement(editField);
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement areYouSureBox(){
        return findElement(okDeleteButton);

    }
    public String verificationMessage(){
        return findElement(messageBox).getText();
    }

    public WebElement displayMessage(){
        return findElement(messageBox);
    }
}