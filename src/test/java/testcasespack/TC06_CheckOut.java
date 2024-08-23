package testcasespack;

import org.testng.Assert;
import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import pages_pack.P03_LoginPage;
import pages_pack.P06_CheckOutYourInformationPage;

import java.io.IOException;

public class TC06_CheckOut extends DriverSetup {

	@Test(priority = 1, description = "Login with valid credentials to access the checkout page")
    public void login() throws InterruptedException {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.loginWithValidCredentials("kumar01@gmail.com", "Pass@123");
    }

	@Test(priority = 2, description = "Navigate to the checkout cart and input order details from an Excel file")
    public void CheckOut() throws IOException, InterruptedException {
        P06_CheckOutYourInformationPage CYIP = new P06_CheckOutYourInformationPage(driver);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=checkout/cart");

        // Provide the path to your Excel file
        String filePath = "C:\\Users\\jaspr\\eclipse-workspace\\MiniProject\\src\\Excel\\OrderData.xlsx";
        CYIP.OrderDetailsFromExcel(filePath);
        
        Thread.sleep(2000);
    }
    
	@Test(priority = 3, description = "Click on the necessary buttons to proceed with the checkout")
    public void ClickButtons() throws InterruptedException {
    	P06_CheckOutYourInformationPage CYIP = new P06_CheckOutYourInformationPage(driver);
    	CYIP.Buttons();
    }
	 @Test(priority = 4, description = "Verify that the order was successfully placed by checking the success message")
    public void VerifyOrderPlaced() throws InterruptedException {
    	 P06_CheckOutYourInformationPage CYIP = new P06_CheckOutYourInformationPage(driver);
    	String Actual_Message =  CYIP.OrderSuccessMessage();
    	String Expected_Message = "https://awesomeqa.com/ui/index.php?route=checkout/success";
    	Assert.assertEquals(Actual_Message, Expected_Message);
    	 
    	 
    	
    }
}