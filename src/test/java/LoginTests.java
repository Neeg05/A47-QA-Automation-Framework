import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    public void registrationNavigation(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getRegistered();
        Assert.assertTrue(loginPage.registerButton().isDisplayed());
    }
    @Test
    public void loginValidCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterEmail("neelam.gupta@testpro.io").enterPassword("te$t$tudent1").clickSubmit();
        Assert.assertTrue(homePage.avatar().isDisplayed());
    }
    @Test(dataProvider = "regressionTests", dataProviderClass = BaseTest.class)
    public void loginInvalidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(email).enterPassword(password).clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}