import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static final ThreadLocal<WebDriver>threadDriver = new ThreadLocal<>();
    protected static String url;

    @DataProvider(name = "validCredentials")
    protected static Object[][] getDataFromDataProvider() {
        return new Object[][]{{"neelam.gupta@testpro.io", "te$t$tudent1"},};
    }
    protected static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.75:444";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");

        switch ("browser") {
            case "chrome":
                return driver = new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions foxOptions = new FirefoxOptions();
                foxOptions.addArguments("--disable-notifications");
                return driver = new FirefoxDriver(foxOptions);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver(chromeOptions);
        }
    }
        protected static WebDriver lambdaTest () throws MalformedURLException {
            String hubURL = "https://hub.lambdatest.com/wd/hub";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("macOS ventura");
            browserOptions.setBrowserVersion("114.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "neelam.gupta");
            ltOptions.put("accessKey", "NK3ATSralEHfiZHRDOyJ1eQtzOnxBa7LjA7Tso3FoPRs42Yi35");
            ltOptions.put("project", "Untitled");
            ltOptions.put("selenium_version", "4.11.0");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);
            return driver = new RemoteWebDriver(new URL(hubURL), browserOptions);
        }
        protected static WebDriver getDriver () {
            return threadDriver.get();
        }
        @BeforeMethod
        @Parameters({"BaseURL"})
        public void launchBrowser (String BaseURL) throws MalformedURLException {
            threadDriver.set(pickBrowser(System.getProperty("browser")));
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getDriver().manage().window().maximize();
            url = BaseURL;
            getDriver().get(url);
        }
        @AfterMethod
        public void closeBrowser () {
            getDriver().close();
            threadDriver.remove();
        }
    }

