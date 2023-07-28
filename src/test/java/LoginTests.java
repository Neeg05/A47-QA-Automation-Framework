import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

        //      Added ChromeOptions argument below to fix websocket error
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}