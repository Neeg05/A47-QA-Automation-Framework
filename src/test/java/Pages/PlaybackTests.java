import Pages.HomePage;
import Pages.LoginPage;
import Pages.SongsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaybackTests extends BaseTest{

    @Test
    public void playSongDoubleClick(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login("neelam.gupta@testpro.io" ,"te$t$tudent1");
        songsPage.goToAllSongs().doubleClickRandomSong();
        Assert.assertTrue(songsPage.songIsPlaying().isDisplayed());
    }
}
