package testcasespack;

import org.testng.annotations.Test;
import driver_pack.DriverSetup;
import pages_pack.P03_LoginPage;
import pages_pack.P04_ProductsPage;

public class TC04_Products extends DriverSetup {

    @Test(priority = 1, description = "Login with valid credentials")
    public void Login() throws InterruptedException {
        P03_LoginPage LP = new P03_LoginPage(driver);
        LP.loginWithValidCredentials("kumar01@gmail.com", "Pass@123");
    }

    @Test(priority = 2, description = "Navigate to the Desktop products section")
    public void Desktop() {
        P04_ProductsPage PP = new P04_ProductsPage(driver);
        PP.NavigateDesktop();
        // Uncomment the following lines if you want to print the text from the products page
        // String as = PP.Text();
        // System.out.println(as);
    }

    @Test(priority = 3, description = "Verify visibility of products and add them to the wishlist")
    public void VerifyProductVisibility() throws InterruptedException {
        P04_ProductsPage PP = new P04_ProductsPage(driver);
        PP.Products();  

        PP.WishList(PP.WishList1);
        driver.navigate().refresh();
        PP.WishList(PP.WishList2);
        driver.navigate().refresh();
        PP.WishList(PP.WishList3);
        driver.navigate().refresh();
        PP.WishList(PP.WishList4);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/wishlist");
        PP.Count();
    }    

    @Test(priority = 4, description = "Check the count of items in the wishlist")
    public void CheckCount() {
        P04_ProductsPage PP = new P04_ProductsPage(driver);
        PP.Count();  
        driver.navigate().back();
    }
    
    @Test(priority = 5, description = "Add products to the comparison list")
    public void AddToComparision() {
        P04_ProductsPage PP = new P04_ProductsPage(driver);
        PP.comparison(PP.CompareList1);
        driver.navigate().refresh();
        PP.comparison(PP.CompareList2);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/compare");
    }
    
    @Test(priority = 6, description = "Compare the prices of products in the comparison list")
    public void ComparePrice() {
        P04_ProductsPage PP = new P04_ProductsPage(driver);
        PP.Price();
    }
}