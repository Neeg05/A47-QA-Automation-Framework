import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        String deletedPlaylistMessage = "Deleted playlist \"" + "my playlist.\"";
        enterEmail("neelam.gupta@testpro.io");
        enterPassword("te$t$tudent1");
        clickSubmit();
        clickOnMyPlaylist();
        clickDeleteButton();
        getDeletedPlaylistMessage();
        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlaylistMessage));

    }
    private String getDeletedPlaylistMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }
      private void clickDeleteButton() {
        WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='del btn-delete-playlist']")));
        deleteButton.click();
    }

    private void clickOnMyPlaylist() {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[contains(text(),'my playlist')]")));
        myPlaylist.click();
    }
}