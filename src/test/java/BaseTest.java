import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    static ChromeDriver driver;
    static WebDriverWait wait;
    static Actions actions;
    static String url;

    @DataProvider(name = "validCredentials")
    static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"neelam.gupta@testpro.io", "te$t$tudent1"},
        };
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        actions = new Actions(driver);

        url = BaseURL;
        driver.get(url);

    }

    void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    void selectPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));

        actions.contextClick(playlist).perform();
    }

    void selectEdit() {
        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")));
        edit.click();
    }
    void renamePlaylist(String name){
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newName.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        newName.sendKeys(name);
        newName.sendKeys(Keys.ENTER);
    }
    String validateAction(){
        WebElement validationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return validationText.getText();
    }
}
