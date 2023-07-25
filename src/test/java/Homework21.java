import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String message ="Updated playlist";

    @Test(dataProvider = "validCredentials")
    public void renamePlaylist(String email, String password){

        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        selectPlaylist();
        selectEdit();
        renamePlaylist( "Favourite");
        Assert.assertTrue(validateAction().contains(message));
        driver.quit();
    }
}