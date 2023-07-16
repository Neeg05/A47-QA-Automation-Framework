import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test(dataProvider = "IncorrectLoginProviders")
    public void LoginEmptyEmailPasswordTest(String email, String password) {
//     Added ChromeOptions argument below to fix websocket error
        openLoginUrl();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void LoginValidEmailPasswordTest(String email, String password) {
       // Added ChromeOptions argument below to fix websocket error
//        openLoginUrl();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        WebElement userAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar")));
//        WebElement userAvatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(userAvatar.isDisplayed());
    }
}
