import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Collection;
import java.util.List;

public class SongsTests extends BaseTest{
    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Sound bars']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    private void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playback']"))).click();
    }

    private void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    private void chooseAllSongsList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }
    @Test
    public void hoverOverPlayButton(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    @Test
    public void countSongsInPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        choosePlaylistByName("Happy Holidays");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    private void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found" + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }

    private void choosePlaylistByName(String playlistName ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains (text(),'Happy Holidays')]"))).click();
    }

}

