package pages_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_RegisterAccountPage {

    // Locators
    By userIcon = By.xpath("//*[@id=\"top-links\"]/ul/li[2]");
    By registerLink = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By firstNameInput = By.id("input-firstname");
    By lastNameInput = By.id("input-lastname");
    By emailInput = By.id("input-email");
    By telephoneInput = By.id("input-telephone");
    By passwordInput = By.id("input-password");
    By confirmPasswordInput = By.id("input-confirm");
    By privacyPolicyCheckbox = By.name("agree");
    By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    By emailErrorMsg = By.xpath("//div[contains(@class, 'text-danger')]");

    // WebDriver setup
    private WebDriver driver;

    public P02_RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the Register page
    public void navigateToRegister() {
        driver.findElement(userIcon).click();
        driver.findElement(registerLink).click();
    }

    // Enter First Name
    public void enterFirstName(String firstName) {
        WebElement firstNameField = driver.findElement(firstNameInput);
        firstNameField.sendKeys(firstName);
    }

    // Enter Last Name
    public void enterLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastNameInput);
        lastNameField.sendKeys(lastName);
    }

    // Enter Email
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.sendKeys(email);
    }

    // Enter Telephone
    public void enterTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(telephoneInput);
        telephoneField.sendKeys(telephone);
    }

    // Enter Password
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.sendKeys(password);
    }

    // Enter Confirm Password
    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(confirmPasswordInput);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    // Agree to Privacy Policy
    public void agreeToPrivacyPolicy() {
        WebElement privacyPolicy = driver.findElement(privacyPolicyCheckbox);
        privacyPolicy.click();
    }

    // Click Continue Button
    public void clickContinue() {
        WebElement continueBtn = driver.findElement(continueButton);
        continueBtn.click();
    }

    // Get Current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
