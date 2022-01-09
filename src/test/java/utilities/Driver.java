package utilities;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }


    public static WebDriver getDriver() {

        if (driver == null) {
            if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("safari")) {

                driver = new SafariDriver();

            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("ie")) {

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();

            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("headlessChrome")) {

                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-extensions");
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--proxy-server='direct://'");
                options.addArguments("--proxy-bypass-list=*");
                options.addArguments("--start-maximized");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);

            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;

    }


    public static void takesScreenshot(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
