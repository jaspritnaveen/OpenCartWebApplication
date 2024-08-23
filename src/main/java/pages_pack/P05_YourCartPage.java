package pages_pack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class P05_YourCartPage {

    // Locators
    static By dropdown = By.id("input-option226");
    static By addToCartButton = By.id("button-cart");
    By Component = By.linkText("Components");
    By Monitor = By.partialLinkText("Monitors (2)");
    By AddTocart = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/i");
    By RadioButton = By.xpath("//*[@id=\"input-option218\"]/div[1]/label/input");
    By CheckBox = By.name("option[223][]");
    By Text = By.id("input-option208");
    By select = By.xpath("//*[@id=\"input-option217\"]");
    By TextArea = By.id("input-option209");
    By Upload = By.id("button-upload222");
    By CartBtn = By.id("button-cart");
    By ItemBtn = By.xpath("//*[@id=\"cart-total\"]");
    
    private WebDriver driver; // Changed to non-static

    public P05_YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDropdownOption() { // Changed to non-static
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);

        if (select.getOptions().size() > 1) {
            select.selectByIndex(1);  
        } else {
            throw new RuntimeException("No options available to select.");
        }
    }

    // Method to click the 'Add to Cart' button
    public void clickAddToCart() { // Changed to non-static
        driver.findElement(addToCartButton).click();
    }

    // Method to check the selected option's value
    public String getSelectedOptionValue() { // Changed to non-static
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void NavigateToMonitor() {
        Actions actions = new Actions(driver);

        WebElement componentsMenu = driver.findElement(Component);
        actions.moveToElement(componentsMenu).perform();

        WebElement monitorsOption = driver.findElement(Monitor);
        monitorsOption.click();
    }

    public void AddToCart() throws InterruptedException, AWTException {
        driver.findElement(AddTocart).click();
        driver.findElement(RadioButton).click();
        driver.findElement(CheckBox).click();
        driver.findElement(Text).clear();
        driver.findElement(Text).sendKeys("SampleText");

        Select dropdown = new Select(driver.findElement(select));
        dropdown.selectByIndex(2);

        driver.findElement(TextArea).sendKeys("Hi broooo");
        driver.findElement(Upload).click();
        StringSelection selection = new StringSelection("C:\\Users\\jaspr\\Downloads\\TestLeaf Logo.png");
        Thread.sleep(2000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(CartBtn).click();
    }

    // Method to extract the quantity of items from the cart text
    public String getCartItemQuantity() {
        String cartText = driver.findElement(ItemBtn).getText();
        // Define a regex pattern to match the quantity of items
        Pattern pattern = Pattern.compile("(\\d+) item\\(s\\)");
        Matcher matcher = pattern.matcher(cartText);

        if (matcher.find()) {
            // Return the matched quantity
            return matcher.group(1);
        } else {
            throw new RuntimeException("Quantity of items not found in the cart text.");
        }
    }
}