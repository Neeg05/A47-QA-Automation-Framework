import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework27 extends BaseTest{
    private String message = "Updated playlist";

    @Test(dataProvider = "validCredentials", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail(email).enterPassword(password).clickSubmit();
        homePage.selectPlaylist().selectEdit().enterName("testPro123456");
        Assert.assertTrue(homePage.verifications().contains(message));
    }
}