import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}