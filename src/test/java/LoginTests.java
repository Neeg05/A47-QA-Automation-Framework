import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test(dataProvider = "IncorrectLoginProviders")
    public void LoginEmptyEmailPasswordTest(String email, String password) {

//      Added ChromeOptions argument below to fix websocket error
        enterEmail(email);
        enterPassword(password);
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void LoginValidEmailPasswordTest() {
//        openLoginUrl();
        enterEmail("neelam.gupta@testpro.io");
        enterPassword("te$t$tudent1");
        clickSubmit();
        WebElement userAvatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(userAvatar.isDisplayed());
    }
}

