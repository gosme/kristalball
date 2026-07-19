package kristalballtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgeModal {
    private WebDriver driver;
    private Wrappers wrapper;

    private final By warning = By.xpath("//div[contains(@class,'flex')]/div[normalize-space()='Are you 21 or older ?']");
    private final By yesButton = By.xpath("//div[contains(@class,'flex')]/button[normalize-space()='Yes']");
    private final By noButton = By.xpath("//div[contains(@class,'flex')]/button[normalize-space()='No']");

    public AgeModal(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAgeModalVisible() {
        return wrapper.isElementVisible(warning);
    }

    public void clickYesButton() {
        wrapper.click(yesButton);
    }

    public void clickNoButton() {
        wrapper.click(noButton);
    }

}