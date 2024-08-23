package testcasespack;

import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import io.qameta.allure.Step;
import pages_pack.P03_LoginPage;
import pages_pack.P05_YourCartPage;

public class TC05_AddToCart extends DriverSetup {

    @Test(priority = 1, description = "Login with valid credentials to access the shopping site")
    public void Login() throws InterruptedException {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.loginWithValidCredentials("kumar01@gmail.com", "Pass@123");
    }

    @Test(priority = 2, description = "Navigate to the Camera product page for verification")
    public void VerifyCamera() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/product&product_id=30");
    }
    @Step
    @Test(priority = 3, description = "Test dropdown option selection and add the selected item to the cart")
    public void testDropdownOptionSelection() {
        try {
            P05_YourCartPage YCP = new P05_YourCartPage(driver); // Create an instance
            // Select an option from the dropdown
            YCP.selectDropdownOption();

            // Assert the selected option is not the default
            String selectedValue = YCP.getSelectedOptionValue();
            Assert.assertNotEquals(selectedValue, "", "An option was not selected!");

            // Click the 'Add to Cart' button
            YCP.clickAddToCart();
        } catch (RuntimeException e) {
            System.out.println("No options Available");
        }
        driver.navigate().back();
    }

    @Test(priority = 4, description = "Add a monitor to the cart")
    public void AddtoCart() throws InterruptedException, AWTException {
        P05_YourCartPage YCP = new P05_YourCartPage(driver); // Create an instance
        YCP.NavigateToMonitor();
        YCP.AddToCart();
    }

    @Test(priority = 5, description = "Verify the cart to ensure the correct quantity of items is displayed")
    public void VerifyCart() throws InterruptedException {
        P05_YourCartPage YCP = new P05_YourCartPage(driver); // Create an instance
        Thread.sleep(2000);
        // Get the quantity of items from the cart text
        String actualQuantity = YCP.getCartItemQuantity();
        Thread.sleep(2000);
        // Define the expected quantity
        String expectedQuantity = "2";
        Assert.assertEquals(actualQuantity, expectedQuantity, "The quantity of items in the cart is not as expected.");
        Thread.sleep(1000);
    }
}