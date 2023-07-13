import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {
        String deletedPlaylistMessage = "Deleted playlist";
        //get url
        //login email
        enterEmail(email);
        //login password
        enterPassword(password);
        //click submit
        clickSubmit();
        //choose playlist
        openPlaylist();
        // click delete that playlist
        clickDeleteBtn();

        //gets deletion text
        getDeletionText();
        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((getDeletionText().contains(deletedPlaylistMessage)));
    }
    private void openPlaylist() throws InterruptedException{
        WebElement openedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[5]/a")));
        openedPlaylist.click();
}
    public String getDeletionText() throws InterruptedException{
        WebElement deletePlaylistConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']")));
        return deletePlaylistConfirm.getText();

    }
    public void clickDeleteBtn() throws InterruptedException{
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistBtn.click();


        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
        confirmDeleteBtn.click();
    }
    }
