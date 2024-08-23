package testcasespack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import pages_pack.P03_LoginPage;

public class TC03_Login extends DriverSetup {

    @BeforeMethod
    public void Login() throws InterruptedException {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.NavigateToLogin();
    }

    public void InValidUrl() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        String Current_Url = LP.GetUrl();
        String Expected_Url = "https://awesomeqa.com/ui/index.php?route=account/account";
        Assert.assertNotEquals(Current_Url, Expected_Url);
    }

    public void ValidUrl() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        String Current_Url = LP.GetUrl();
        String Expected_Url = "https://awesomeqa.com/ui/index.php?route=account/account";
        Assert.assertEquals(Current_Url, Expected_Url);
    }

    @Test(priority = 1, description = "Login With Invalid Mail ID and valid Password")
    public void TestData1() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("ashanna12@gmail.com");
        LP.Password("Test@123");
        LP.LoginButtonClk();
        InValidUrl();
    }

    @Test(priority = 2, description = "Login With Valid Mail ID and Invalid Password")
    public void TestData2() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("Naveenkumar1@gmail.com");
        LP.Password("Test123");
        LP.LoginButtonClk();
        InValidUrl();
    }

    @Test(priority = 3, description = "Login With Invalid Mail ID and Invalid Password")
    public void TestData3() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("testzz.com");
        LP.Password("Test@123");
        LP.LoginButtonClk();
        InValidUrl();
    }

    @Test(priority = 4, description = "Login With Invalid Mail ID and valid Password")
    public void TestData4() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("test@12g.com");
        LP.Password("Test@123");
        LP.LoginButtonClk();
        InValidUrl();
    }

    @Test(priority = 5, description = "Login With Null")
    public void TestData6() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("");
        LP.Password("");
        LP.LoginButtonClk();
        InValidUrl();
    }

    @Test(priority = 6, description = "Login With valid Mail ID and valid Password")
    public void TestData5() {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.Email("kumar01@gmail.com");
        LP.Password("Pass@123");
        LP.LoginButtonClk();
        ValidUrl();
    }
}
