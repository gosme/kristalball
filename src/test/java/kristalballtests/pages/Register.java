package kristalballtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
    private WebDriver driver;
    private Wrappers wrapper;

    private final By nameField = By.xpath("//div[contains(@class,'flex')]//input[contains(@placeholder,'name')]");
    private final By emailField = By.xpath("//div[contains(@class,'flex')]//input[contains(@placeholder,'email')]");
    private final By passwordField = By.xpath("(//div[contains(@class,'flex')]//input[contains(@placeholder,'password')])[1]");
    private final By confirmPasswordField = By.xpath("(//div[contains(@class,'flex')]//input[contains(@placeholder,'password')])[2]");
    private final By privacyPolicyCheckbox = By.xpath("//input[@type='checkbox']");
    private final By signupButton = By.xpath("//div[@role='button']/p[contains(text(),'Signup')]");
    private final By OTPField = By.xpath("//div[contains(@class,'flex')]//input[contains(@placeholder,'OTP')]");
    private final By verifyButton = By.xpath("//div[@role='button']/p[contains(text(),'Verify')]");

    public Register(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        wrapper.clearAndSendKeys(nameField, name);
    }

    public void enterEmail(String email) {
        wrapper.clearAndSendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        wrapper.clearAndSendKeys(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        wrapper.clearAndSendKeys(confirmPasswordField, confirmPassword);
    }

    public void clickPrivacyPolicyCheckbox() {
        wrapper.click(privacyPolicyCheckbox);
    }

    public void clickSignupButton() {
        wrapper.click(signupButton);
    }

    public void signupUser(String name, String email, String password, String confirmPassword) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickPrivacyPolicyCheckbox();
        clickSignupButton();
    }

    public boolean isOTPScreen() {
        if (wrapper.findElementWithLocator(OTPField).isDisplayed() && wrapper.findElementWithLocator(verifyButton).isDisplayed()) {
            return true;
        }
        return false;
    }

    public void verifyOTP() {
        wrapper.clearAndSendKeys(OTPField, "123456");
        wrapper.click(verifyButton);
    }

    public boolean isSignupSuccessful() {
        return wrapper.waitForUrlContains("/auth/products");
    }
}
