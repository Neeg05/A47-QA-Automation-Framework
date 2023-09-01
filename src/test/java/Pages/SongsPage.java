package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SongsPage extends BasePage{

    @FindBy(css = "#sidebar > section.music > ul > li:nth-child(3) > a")
    private WebElement allSongs;
    @FindBy(css = "#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title ")
    private WebElement fistSongSelection;
    @FindBy(css = "div.bars")
    private WebElement playBars;
    @FindBy(css = ".btn-add-to")
    private WebElement addButton;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")
    private WebElement playlistSelection;
    @FindBy(css = "table.items > tr")
    private String allSongList;

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SongsPage selectRandomPlaylistDrpDwn(){
        for (int i = 0; i < 2; i++) {
            List<WebElement> listItems = driver.findElements(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul >li.playlist"));
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(1, size);
            listItems.get(randomNumber).click();
        }
        return this;
    }
    public SongsPage selectRandomSong() {
        for(int i = 0; i < 2; i++){
            List<WebElement> listItems = findListByLocator(allSongList);
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(1,size);
            listItems.get(randomNumber).click();
        }
        return this;
    }
    public SongsPage doubleClickRandomSong(){
        for(int i = 0; i < 2; i++) {
            List<WebElement> listItems = driver.findElements(By.cssSelector("table.items > tr"));
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(1, size);
            doubleClick(listItems.get(randomNumber));
        }
        return this;
    }
    public SongsPage goToAllSongs(){
        findElement(allSongs);
        click(allSongs);
        return this;
    }
    public SongsPage doubleClickSong(){
        waitToClick(fistSongSelection);
        doubleClick(fistSongSelection);
        return this;
    }
    public SongsPage clickFirstSong(){
        findElement(fistSongSelection);
        click(fistSongSelection);
        return this;
    }
    public SongsPage clickAddButton(){
        findElement(addButton);
        click(addButton);
        return this;
    }
    public SongsPage addToPlaylistSelection(){
        findElement(playlistSelection);
        click(playlistSelection);
        return this;
    }
    public WebElement songIsPlaying(){
        return findElement(playBars);
    }
}
