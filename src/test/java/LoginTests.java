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