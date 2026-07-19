package kristalballtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModal {
    private WebDriver driver;
    private Wrappers wrapper;

    private final By emailField = By.xpath("//div[contains(@class,'flex')]//input[contains(@placeholder,'email')]");
    private final By passwordField = By.xpath("//div[contains(@class,'flex')]//input[contains(@placeholder,'password')]");
    private final By registerButton = By.xpath("//div[@role='button' and contains(text(), 'have an account')]");
    private final By loginButton = By.xpath("//div[@role='button']/p[contains(text(),'Login')]");
    private final By continueWithoutAccountButton = By.xpath("//div[contains(@role,'button') and (normalize-space()='Continue without an account')]");

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginModalVisible() {
        return wrapper.isElementVisible(loginButton);
    }

    public void clickRegisterButton() {
        wrapper.click(registerButton);
    }

    public void clickLoginButton() {
        wrapper.click(loginButton);
    }

    public void clickContinueWithoutAccountButton() {
        wrapper.click(continueWithoutAccountButton);
    }
}
