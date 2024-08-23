package pages_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_ProductsPage{

	//Locators
	By Desktop = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a");
	By AllDesktops = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a");
	By Product1 = By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a");
	By Product2 = By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[1]/h4/a");
	public By WishList1 =	By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[2]/i");
	public By WishList2 =   By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[2]/i");
	public By WishList3 =   By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[2]/i");
	public By WishList4 =    By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[2]/div[2]/button[2]/i");
	By Success_Mes = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By TableBody = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody");
	public	By CompareList1 = By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[3]/i");
	public By CompareList2 = By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[3]/i");
	public By Price1 = By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[3]/td[2]");
	public By Price2 = By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[3]/td[3]");


	//Driver Setup
	private WebDriver driver;
	public P04_ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void NavigateDesktop() {
		driver.findElement(Desktop).click();
		driver.findElement(AllDesktops).click();
	}



	public String Text() {
		WebElement txt =	driver.findElement(Product1);
		return txt.getText();
	}


	public void Products() {
		By[] productXpaths = {
				By.xpath("//*[@id='content']/div[4]/div[1]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[2]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[3]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[4]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[5]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[6]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[7]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[8]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[9]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[10]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[11]/div/div[2]/div[1]/h4/a"),
				By.xpath("//*[@id='content']/div[4]/div[12]/div/div[2]/div[1]/h4/a"),
		};

		for (By xpath : productXpaths) {
			try {
				// Locate the element using the XPath
				WebElement productElement = driver.findElement(xpath);

				// Check if the element is visible
				if (productElement.isDisplayed()) {
					System.out.println("Product is visible.");
				} else {
					System.out.println("Product not visible.");
				}
			} catch (Exception e) {

				System.out.println("Product at XPath  is not present or not visible.");
			}
		}
	}

	
		//Add to WishList

		public void WishList(By wishlistitems) throws InterruptedException {
			driver.findElement(wishlistitems).click();
			WebElement msg =  driver.findElement(Success_Mes);
			String txt = msg.getText();
			txt = txt.replace("×", "").trim();
			System.out.println(txt);
			Thread.sleep(2000);
		}
		
		public void Count() {
		    WebElement body = driver.findElement(TableBody);
		    java.util.List<WebElement> rows = body.findElements(By.tagName("tr"));
		    int rowCount = rows.size();
		    System.out.println(rowCount);
		}

	
		//Add to Product comparison!
	
		public void comparison(By CompareProducts) {
			driver.findElement(CompareProducts).click();
			WebElement msg = driver.findElement(Success_Mes);
			String txt = msg.getText();
			txt = txt.replace("×", "").trim();
			System.out.println(txt);
			
			
		}
	 
	public int ExtractPrice(String Text) {
		Text =  Text.replace("$", "").replace(".00", "").replace(" ", "");
        // Convert the string to an integer
		 
        return Integer.parseInt(Text);
         

		
	}
		public void Price() {
			String msg1 = driver.findElement(Price1).getText();
			String msg2 = 	driver.findElement(Price2).getText();
			
			int price1 = ExtractPrice(msg1);
			int price2 = ExtractPrice(msg2);
			
			
			System.out.println(msg1);
			System.out.println(msg2);
			
			if (price1 > price2) {
	            System.out.println("Product 1 has a higher price: " + price1);
	        } else if (price2 > price1) {
	            System.out.println("Product 2 has a higher price: " + price2);
	        } else {
	            System.out.println("Both products have the same price: " + price1);
	        }
		}
	
	
	
	
	
	
	
	
	
	
	

	//Add to WishList
	/*public void WishList() {
	    By[] WishListXpath  = {
	        By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[2]/button[2]/i"),
	        By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[2]/i"),
	        By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[2]/i"),
	        By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[2]/div[2]/button[2]/i"),
	    };

	    StringBuilder allMessages = new StringBuilder();
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (By xpath : WishListXpath) {
	        WebElement productElement = driver.findElement(xpath);
	        js.executeScript("arguments[0].click();", productElement);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        js.executeScript("window.scroll(0, 100);"); 
	        WebElement mesg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        String txt = mesg.getText().replace("×", "").trim();
	        allMessages.append(txt).append("  ");
	    }

	    System.out.println(allMessages.toString().trim());
	}
	 */

	
	/* public String Url() {
		String url = driver.getCurrentUrl();
		return url;
	} */
	
	
	
	
	
	
	

}