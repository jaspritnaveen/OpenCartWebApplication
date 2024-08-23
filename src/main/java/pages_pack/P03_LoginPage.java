package pages_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_LoginPage {
    
    // Locators
    By User_Icon = By.xpath("//*[@id='top-links']/ul/li[2]");
    By Login = By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a");
    By Email = By.id("input-email");
    By Password = By.id("input-password");
    By Login_Btn = By.xpath("//*[@id='content']/div/div[2]/div/form/input");
    By Warning = By.xpath("//*[@id='account-login']/div[1]");
    
    // Driver Setup
    protected WebDriver driver;
    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to navigate to the login page
    public void NavigateToLogin() {
        driver.findElement(User_Icon).click();
        
        // Wait until the Login button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
        
        // Wait until the Login button is visible before interacting
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Btn)).click();
    }
    
    // Method to get the current URL
    public String GetUrl() {
    	String Url =  driver.getCurrentUrl();
    	return Url;
    }
    
    // Method to click the Login button
    public void LoginButtonClk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Login_Btn)).click();
    }
    
    // Method to enter email
    public String Email(String email) {
        WebElement txt = driver.findElement(Email);
        txt.sendKeys(email);
        return email;
    }
    
    // Method to enter password
    public String Password(String pass) {
        WebElement txt = driver.findElement(Password);
        txt.sendKeys(pass);
        return pass;
    }
    
    // Method to perform login with valid credentials
    public void loginWithValidCredentials(String email, String pass) {
        NavigateToLogin();
        Email(email);
        Password(pass);
        LoginButtonClk();
    }
}
