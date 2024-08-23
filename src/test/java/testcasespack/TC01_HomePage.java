package testcasespack;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import pages_pack.P01_HomePage;

public class TC01_HomePage extends DriverSetup {

    @Test(description = "Verify that the logo is displayed on the home page")
    public void verifyLogoIsDisplayed() {
        P01_HomePage homePage = new P01_HomePage(driver);
        WebElement logo = homePage.getLogo();
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
    
    @Test(priority = 1, description = "Verify that the featured section is displayed on the home page")
    public void verifyFeaturedSectionIsDisplayed() {
        P01_HomePage homePage = new P01_HomePage(driver);
        WebElement featuredSection = homePage.getFeaturedSection();
        Assert.assertTrue(featuredSection.isDisplayed(), "Featured section is not displayed");
    }

    @Test(priority = 2, description = "Verify that the page title matches 'Your Store'")
    public void verifyPageTitle() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String title = homePage.getPageTitle();
        assertEquals(title, "Your Store", "Page title does not match");
    }

    @Test(priority = 3, description = "Verify that featured images are displayed on the home page")
    public void verifyFeaturedImagesAreDisplayed() {
        P01_HomePage homePage = new P01_HomePage(driver);
        boolean areImagesDisplayed = homePage.areFeaturedImagesDisplayed();
        Assert.assertTrue(areImagesDisplayed, "Featured images are not displayed");
    }

    @Test(priority = 4, description = "Verify that the footer is visible on the home page")
    public void verifyFooterIsVisible() {
        P01_HomePage homePage = new P01_HomePage(driver);
        boolean isFooterVisible = homePage.isFooterVisible();
        Assert.assertTrue(isFooterVisible, "Footer is not visible");
    }

    @Test(priority = 5, description = "Verify that the cart text displays '0 item(s) - $0.00'")
    public void verifyCartText() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String cartText = homePage.getCartText();
        assertEquals(cartText, "0 item(s) - $0.00", "Cart text does not match");
    }

    @Test(priority = 6, description = "Verify navigation to the Contact page and validate the URL")
    public void verifyNavigationToContactPage() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String actualUrl = homePage.navigateToContactPage();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=information/contact";
        assertEquals(actualUrl, expectedUrl, "URL of the Contact page does not match");
        driver.navigate().back();
    }

    @Test(priority = 7, description = "Verify navigation to the Register page and validate the URL")
    public void verifyNavigationToRegisterPage() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String actualUrl = homePage.navigateToRegisterPage();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/register";
        assertEquals(actualUrl, expectedUrl, "URL of the Register page does not match");
        driver.navigate().back();
    }

    @Test(priority = 8, description = "Verify navigation to the Login page and validate the URL")
    public void verifyNavigationToLoginPage() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String actualUrl = homePage.navigateToLoginPage();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/login";
        assertEquals(actualUrl, expectedUrl, "URL of the Login page does not match");
        driver.navigate().back();
    }

    @Test(priority = 9, description = "Verify that the search result title matches 'Search - iphone'")
    public void verifySearchProductTitle() {
        P01_HomePage homePage = new P01_HomePage(driver);
        String actualTitle = homePage.searchProduct("iphone");
        assertEquals(actualTitle, "Search - iphone", "Search result title does not match");
    }

    @Test(priority = 10, description = "Verify that the iPhone is visible in the search results")
    public void verifyIphoneVisibilityInSearchResults() {
        P01_HomePage homePage = new P01_HomePage(driver);
        boolean isIphoneVisible = homePage.isIphoneVisible();
        Assert.assertTrue(isIphoneVisible, "iPhone is not visible in the search results");
        driver.navigate().back();
    }
}