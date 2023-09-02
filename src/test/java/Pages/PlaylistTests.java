import Pages.HomePage;
import Pages.LoginPage;
import Pages.SongsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class PlaylistTests extends BaseTest {

    @Test(priority = 1)
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("neelam.gupta@testpro.io", "te$t$tudent1");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work123");
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test(priority = 4)
    public void deleteActivePlaylist() throws Exception{

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login("neelam.gupta@testpro.io", "te$t$tudent1");
        homePage.selectRandomPlaylistHomePg();
        homePage.clickDeleteButton();
        try{
            if (homePage.displayMessage().isDisplayed()) {
                Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
            }
        }
        catch(Exception e) {
            homePage.areYouSureBox().click();
            Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
        }
    }
    @Test(priority = 2)
    public void addSongToPlaylist() throws ElementNotInteractableException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        try{
            loginPage.login("neelam.gupta@testpro.io", "te$t$tudent1");
            songsPage.goToAllSongs().selectRandomSong().clickAddButton();
            songsPage.selectRandomPlaylistDrpDwn();}
        catch(ElementNotInteractableException e) {
            Assert.assertTrue(homePage.verificationMessage().contains("Added"));
        }
    }
    @Test(priority = 3)
    public void renamePlaylist (){
        String randomName = RandomStringUtils.randomAlphabetic(5);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login("neelam.gupta@testpro.io", "te$t$tudent1");
        homePage.contextRandomPlaylistHmPg();
        homePage.selectEdit().editName(randomName);
        Assert.assertTrue(homePage.verificationMessage().contains("Updated"));
    }
}