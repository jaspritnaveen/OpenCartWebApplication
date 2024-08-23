package testcasespack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import pages_pack.P02_RegisterAccountPage;

public class TC02_Register extends DriverSetup {

    @BeforeMethod
    public void setupRegisterPage() {
        P02_RegisterAccountPage registerPage = new P02_RegisterAccountPage(driver);
        registerPage.navigateToRegister();
    }

    @Test(priority = 1, description = "Register With Invalid Email ID")
    public void testInvalidEmailRegistration() {
        P02_RegisterAccountPage registerPage = new P02_RegisterAccountPage(driver);
        registerPage.enterFirstName("Naveen");
        registerPage.enterLastName("Kumar");
        registerPage.enterEmail("invalidEmail");
        registerPage.enterTelephone("1225");
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");
        registerPage.agreeToPrivacyPolicy();
        registerPage.clickContinue();
        String currentUrl = registerPage.getCurrentUrl();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/success";
        Assert.assertNotEquals(currentUrl, expectedUrl);
    }

    @Test(priority = 2, description = "Register With Invalid Password")
    public void testInvalidPasswordRegistration() {
        P02_RegisterAccountPage registerPage = new P02_RegisterAccountPage(driver);
        registerPage.enterFirstName("Naveen");
        registerPage.enterLastName("Kumar");
        registerPage.enterEmail("Test@gmail.com");
        registerPage.enterTelephone("1225");
        registerPage.enterPassword("1");
        registerPage.enterConfirmPassword("2");
        registerPage.agreeToPrivacyPolicy();
        registerPage.clickContinue();
        String currentUrl = registerPage.getCurrentUrl();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/success";
        Assert.assertNotEquals(currentUrl, expectedUrl);
    }

    @Test(priority = 3, description = "Register With Valid Data")
    public void testValidRegistration() throws InterruptedException {
        P02_RegisterAccountPage registerPage = new P02_RegisterAccountPage(driver);
        registerPage.enterFirstName("Naveen");
        registerPage.enterLastName("Kumar");
        registerPage.enterEmail("kumar01@gmail.com");
        registerPage.enterTelephone("1225");
        registerPage.enterPassword("Pass@123");
        registerPage.enterConfirmPassword("Pass@123");
        registerPage.agreeToPrivacyPolicy();
        registerPage.clickContinue();
        String currentUrl = registerPage.getCurrentUrl();
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/success";
        Assert.assertEquals(currentUrl, expectedUrl);
        System.out.println("Your Account Has Been Created!");
        
    }
}
