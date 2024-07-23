

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspr\\OneDrive\\Desktop\\Selenium\\Driver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://awesomeqa.com/ui/");
        
        WebElement UserRegister = driver.findElement(By.className("dropdown"));
        UserRegister.click();
        
       
        	WebElement Register = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        	Register.click();
        	
        	WebElement Firstname = driver.findElement(By.id("input-firstname"));
        	Firstname.sendKeys("Naveenkumar");
        	
        	WebElement Lastname = driver.findElement(By.id("input-lastname"));
        	Lastname.sendKeys("r");
        	
        	WebElement Email = driver.findElement(By.id("input-email"));
        	Email.sendKeys("Naveenkumar668@gmail.com");
        	
        	WebElement Telephone = driver.findElement(By.id("input-telephone"));
        	Telephone.sendKeys("6985231202");
        	
        	WebElement Password = driver.findElement(By.id("input-password"));
        	Password.sendKeys("Test@123");
        	
        	WebElement ConformPassword = driver.findElement(By.id("input-confirm"));
        	ConformPassword.sendKeys("Test@123");
        	
        	WebElement PPCheckbox = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        	PPCheckbox.click();
        	
        	WebElement Continue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        	Continue.click();
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        
    }
}
