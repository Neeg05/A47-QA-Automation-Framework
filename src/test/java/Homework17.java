import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        String successNotificationText = "Added 1 song into ";
        openLoginUrl();
        enterEmail("neelam.gupta@testpro.io");
        enterPassword("te$t$tudent1");
        clickSubmit();
        searchSong();
        clickViewAllButton();
        selectFirstSongInList();
        clickAddToButton();
        clickAddToPlaylist();
        Assert.assertTrue(getNotificationText().contains(successNotificationText));
    }
    private void searchSong() {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Pluto");
        searchField.sendKeys(Keys.RETURN);

    }
    public void clickViewAllButton() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    private void selectFirstSongInList() {
        WebElement firstSongInAList = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongInAList.click();
    }
    private void clickAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToButton.click();

    }

    private void clickAddToPlaylist() {
        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), \"abc\")]"));
        myPlaylist.click();

    }

    private String getNotificationText() {
        WebElement successNotification = driver.findElement(By.cssSelector("div.success.show"));
        return successNotification.getText();

    }
}



