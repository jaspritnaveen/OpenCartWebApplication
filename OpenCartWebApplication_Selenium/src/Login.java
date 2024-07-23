import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
 

public class Login {

    public static void main(String[] args) throws Exception {
        
        // Driver Properties 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspr\\OneDrive\\Desktop\\Selenium\\Driver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://awesomeqa.com/ui/");
        
        // Login
        WebElement UserRegister = driver.findElement(By.className("dropdown"));
        UserRegister.click();
        Thread.sleep(2000);
        
        WebElement Register = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        Register.click();
        Thread.sleep(2000);
        
        WebElement E_Mail_Address = driver.findElement(By.id("input-email"));
        E_Mail_Address.sendKeys("Naveenkumar668@gmail.com");
        Thread.sleep(2000);
        
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("Test@123");
        Thread.sleep(2000);
        
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        Login.click();
        Thread.sleep(2000);
        
        // Navigate to the Monitors
        WebElement Components_Dropdown = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a"));
        Components_Dropdown.click(); 
        Thread.sleep(2000);
        
        WebElement Monitors = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a"));
        Monitors.click(); 
        Thread.sleep(2000);
        
        // Navigate to the Monitor Samsung
        WebElement Samsung_Monitors = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[1]/a/img"));
        Samsung_Monitors.click();
        Thread.sleep(2000);
        
        // Add to Wishlist
        WebElement Samsung_AddtoWishlist = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]"));
        Samsung_AddtoWishlist.click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the alert message element is visible
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));

        // Extract the full text of the alert message
        String fullMessageText = alertMessage.getText();
        
        // Split the text to remove the close button "×"
        String alertText = fullMessageText.split("\n")[0];  
        
        System.out.println("Alert Message: " + alertText);
        Thread.sleep(2000);
        
        // Add to Cart
        WebElement Samsung_AddtoCart = driver.findElement(By.id("button-cart"));
        Samsung_AddtoCart.click();
        Thread.sleep(2000);
        
        // Navigate to Cart
        WebElement Shopping = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a"));
        Shopping.click();
        Thread.sleep(2000);
        
        // Checkout
        WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a"));
        Checkout.click();
        Thread.sleep(2000);
        
        // Fill Payment Details
        WebElement firstNamePayment = driver.findElement(By.id("input-payment-firstname"));
        firstNamePayment.sendKeys("John");
        Thread.sleep(2000);

        WebElement lastNamePayment = driver.findElement(By.id("input-payment-lastname"));
        lastNamePayment.sendKeys("Doe");
        Thread.sleep(2000);

        WebElement companyPayment = driver.findElement(By.id("input-payment-company"));
        companyPayment.sendKeys("RandomCompany");
        Thread.sleep(2000);

        WebElement address1Payment = driver.findElement(By.id("input-payment-address-1"));
        address1Payment.sendKeys("123 Main Street");
        Thread.sleep(2000);

        WebElement address2Payment = driver.findElement(By.id("input-payment-address-2"));
        address2Payment.sendKeys("Apt 4B");
        Thread.sleep(2000);

        WebElement cityPayment = driver.findElement(By.id("input-payment-city"));
        cityPayment.sendKeys("RandomCity");
        Thread.sleep(2000);

        WebElement postcodePayment = driver.findElement(By.id("input-payment-postcode"));
        postcodePayment.sendKeys("12345");
        Thread.sleep(2000);

        // Select country
        Select countryDropdown = new Select(driver.findElement(By.id("input-payment-country")));
        countryDropdown.selectByVisibleText("United States");
        Thread.sleep(2000);
        
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]"));
        dropdownElement.click();
        dropdownElement.sendKeys(Keys.DOWN);
        dropdownElement.sendKeys(Keys.DOWN);
        dropdownElement.sendKeys(Keys.DOWN);
        dropdownElement.sendKeys(Keys.DOWN);

        // Send Enter key to select the option
        dropdownElement.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement Address_Conformation = driver.findElement(By.id("button-payment-address"));
        Address_Conformation.click();
        Thread.sleep(2000);
        
        WebElement Delivery_Details = driver.findElement(By.id("button-shipping-address"));
        Delivery_Details.click();
        Thread.sleep(2000);
        
        WebElement Delivery_Method = driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]"));
        Delivery_Method.click();
        Thread.sleep(2000);
        
        WebElement Checkbox = driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));
        Checkbox.click();
        Thread.sleep(2000);
        
        WebElement Checkbox_Below_Button = driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]"));
        Checkbox_Below_Button.click();
        Thread.sleep(2000);
        
        WebElement Last_Conformation = driver.findElement(By.xpath("//*[@id=\"button-confirm\"]"));
        Last_Conformation.click();
        Thread.sleep(2000);
        
        WebElement headingElement = driver.findElement(By.xpath("//*[@id='content']/h1"));

        // Get the text of the element
        String headingText = headingElement.getText();

        // Print the text
        System.out.println("Heading text: " + headingText);
    }
}
