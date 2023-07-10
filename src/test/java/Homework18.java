import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong(){
        openLoginUrl();
        enterEmail("neelam.gupta@testpro.io");
        enterPassword("te$t$tudent1");
        clickSubmit();
        clickPlayNextSongButton();
        clickPlayButton();
        WebElement soundBar = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    private void clickPlayNextSongButton() {
        WebElement playNextSongButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSongButton.click();
    }
    private void clickPlayButton() {
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playButton.click();
    }
}


