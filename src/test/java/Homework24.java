import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{

    String message = "Updated playlist";
    @Test(dataProvider = "validCredentials", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail(email).enterPassword(password).clickSubmit();
        homePage.contextClickFirstPlaylist().editSelection().editName("Happy Songs");

        Assert.assertTrue(homePage.verificationMessage().contains(message));

    }
}