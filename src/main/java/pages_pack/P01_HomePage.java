package pages_pack;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_HomePage {

    // Locators
    By featuredSectionLocator = By.xpath("//*[@id=\"content\"]/div[2]");
    By macTextLocator = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[1]");
    By logoLocator = By.xpath("//*[@id='logo']/a/img");
    By footerLocator = By.xpath("/html/body/footer");
    By cartLocator = By.xpath("//*[@id=\"cart-total\"]");
    By contactLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[1]/a");
    By navRegisterLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    By registerLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By loginLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
    By searchInputLocator = By.xpath("//*[@id=\"search\"]/input");
    By searchButtonLocator = By.xpath("//*[@id=\"search\"]/span/button");
    By textContainsLocator = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4");
    
    private WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if the Logo is displayed
    public WebElement getLogo() {
        return driver.findElement(logoLocator); 
    }

    // Get the Featured section element
    public WebElement getFeaturedSection() {
        return driver.findElement(featuredSectionLocator);
    }

    // Get the Mac text element
    public WebElement getMacText() {
        return driver.findElement(macTextLocator);
    }

    // Check the Title of the webpage
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Check if Featured Images are displayed
    public boolean areFeaturedImagesDisplayed() {
        WebElement container = driver.findElement(featuredSectionLocator);
        List<WebElement> images = container.findElements(By.tagName("img"));

        for (WebElement image : images) {
            if (image.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    // Check if the Footer is visible
    public boolean isFooterVisible() {
        WebElement footer = driver.findElement(footerLocator);
        return footer.isDisplayed();
    }

    // Get the Cart text
    public String getCartText() {
        WebElement cart = driver.findElement(cartLocator);
        return cart.getText();
    }

    // Navigate to the Contact page and return its URL
    public String navigateToContactPage() {
        WebElement contactLink = driver.findElement(contactLinkLocator);
        contactLink.click();
        return driver.getCurrentUrl();
    }

    // Navigate to the Register page and return its URL
    public String navigateToRegisterPage() {
        driver.findElement(navRegisterLocator).click();
        WebElement registerLink = driver.findElement(registerLinkLocator);
        registerLink.click();
        return driver.getCurrentUrl();
    }

    // Navigate to the Login page and return its URL
    public String navigateToLoginPage() {
        driver.findElement(navRegisterLocator).click();
        WebElement loginLink = driver.findElement(loginLinkLocator);
        loginLink.click();  
        return driver.getCurrentUrl();
    }

    // Search for a product and return the page title
    public String searchProduct(String searchText) {
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys(searchText);
        
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return driver.getTitle();
    }
    
    // Check if "iPhone" is visible on the page
    public boolean isIphoneVisible() {
        WebElement textElement = driver.findElement(textContainsLocator);
        String text = textElement.getText();
        return text.contains("iPhone");
    }
}
