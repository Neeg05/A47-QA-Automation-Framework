import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setup Class() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void logout() {

        driver.quit();
    }
    @DataProvider (name="CorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"neelam.gupta@testpro.io", "te$t$tudent1"}
        };
    }
    protected static void enterEmail(String email) throws InterruptedException{
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        //inputs valid email address into email input field
        emailInput.sendKeys(email);
        Thread.sleep(5000);
    }
    protected static void enterPassword(String password) throws InterruptedException {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.clear(); //inputs valid password for login into password field
        passwordInput.sendKeys(password);
    }
    public void clickSubmit() throws InterruptedException{
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("[type='submit']"))));
        loginButton.click();
    }
    @Test
    public void addSongToPlaylist(String email, String password) throws InterruptedException{
        String newSongAddedNotificationText = "Added 1 song into";
        //open url
        //openLoginUrl();
        //input email
        enterEmail(email);
        //input password
        enterPassword(password);
        //click submit
        clickSubmit();

        //search for song
        searchForSong("Dark Days");
        //click View All Btn
        clickViewAllBtn();
        // verify on search results page
        verifySearchUrl();
        //select the first song returned in the search
        selectFirstSongResult();
        //click Add To Btn
        clickAddToBtn();
        //choose Playlist to add the song to
        choosePlaylist();
        //checking for success message notification
    Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));

    }
    public void choosePlaylist() throws InterruptedException{
        WebElement testPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[15]")));
        testPlaylist.click();
    }
    public void
    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]")));
        firstResult.click();
    }
    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
    } viewAllBtn.click();
    public void verifySearchUrl() throws InterruptedException {
        WebElement songResultsWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']")));
        Assert.assertTrue(songResultsWrapper.isDisplayed());
    }
    public void searchForSong(String song) throws InterruptedException{
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);

    }
    public String getNotificationText () {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));
        return notificationElement.getText();
    }
}
