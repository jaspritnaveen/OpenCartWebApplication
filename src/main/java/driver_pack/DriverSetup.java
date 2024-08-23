package driver_pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
 

public class DriverSetup {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        Properties p = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\jaspr\\eclipse-workspace\\MiniProject\\src\\main\\java\\browser_pack\\data.properties");
            p.load(fis);

            String mybrowser = p.getProperty("browser");
            String myurl = p.getProperty("url");

            if (mybrowser == null) {
                throw new RuntimeException("Browser property is missing in the properties file.");
            }

            switch (mybrowser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspr\\OneDrive\\Desktop\\Selenium\\Driver\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\jaspr\\OneDrive\\Desktop\\Selenium\\Driver\\Firefox\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\jaspr\\OneDrive\\Desktop\\Selenium\\Driver\\Edge\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser specified in the properties file: " + mybrowser);
            }

            driver.get(myurl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        } catch (IOException e) {
            throw new RuntimeException("Failed to load the properties file: " + e.getMessage(), e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Failed to close FileInputStream: " + e.getMessage());
                }
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
