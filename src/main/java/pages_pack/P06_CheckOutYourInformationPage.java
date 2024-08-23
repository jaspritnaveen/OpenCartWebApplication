package pages_pack;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;

public class P06_CheckOutYourInformationPage {

    // Locators
    By CheckoutBtn = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");
    By FirstName = By.id("input-payment-firstname");
    By LastName = By.id("input-payment-lastname");
    By Address1 = By.id("input-payment-address-1");
    By City = By.id("input-payment-city");
    By PinCode = By.id("input-payment-postcode");
    By State = By.xpath("//*[@id=\"input-payment-zone\"]");
    By BillingDetailsButton = By.id("button-payment-address");
    By Delivery_Details_Btn = By.id("button-shipping-address");
    By Delivery_Method_Btn = By.id("button-shipping-method");
    By Payment_Method_Btn = By.id("button-payment-method");
    By CheckBox = By.name("agree");
    By ConformOrderBtn = By.id("button-confirm");
    By OrderSuccessMessage = By.xpath("//h1[normalize-space()='Your order has been placed!']");
    
    
    private WebDriver driver;

    public P06_CheckOutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void OrderDetailsFromExcel(String filePath) throws IOException, InterruptedException {
        // Read the Excel file
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook wbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = wbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1); // Assuming you want to read the second row of the Excel sheet

        // Extract data from the cells
        DataFormatter dft = new DataFormatter();
        String firstName = dft.formatCellValue(row.getCell(0));
        String lastName = dft.formatCellValue(row.getCell(1));
        String address1 = dft.formatCellValue(row.getCell(2));
        String city = dft.formatCellValue(row.getCell(3));
        String pinCode = dft.formatCellValue(row.getCell(4));
         

        // Use the extracted data to fill in the form fields
        driver.findElement(CheckoutBtn).click();
        driver.findElement(FirstName).sendKeys(firstName);
        driver.findElement(LastName).sendKeys(lastName);
        driver.findElement(Address1).sendKeys(address1);
        driver.findElement(City).sendKeys(city);
        driver.findElement(PinCode).sendKeys(pinCode);
         
        WebElement StatePath = driver.findElement(State);
        Select state = new Select(StatePath);
        state.selectByIndex(2);
        
         
        
        
        Thread.sleep(3000);
        wbook.close();
        fis.close();
    }
    public void Buttons() throws InterruptedException {
    	driver.findElement(BillingDetailsButton).click();
    	driver.findElement(Delivery_Details_Btn).click();
    	Thread.sleep(1000);
    	driver.findElement(Delivery_Method_Btn).click();
    	Thread.sleep(1000);
    	driver.findElement(CheckBox).click();
    	Thread.sleep(1000);
    	driver.findElement(Payment_Method_Btn).click();
    	Thread.sleep(1000);
    	driver.findElement(ConformOrderBtn).click();
    	 
    }
    public String OrderSuccessMessage() throws InterruptedException {
    	//return driver.findElement(OrderSuccessMessage).getText();
    	Thread.sleep(2000);
    	return driver.getCurrentUrl();
    }
}
