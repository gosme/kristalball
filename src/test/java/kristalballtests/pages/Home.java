package kristalballtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    private WebDriver driver;
    private Wrappers wrapper;

    private final By getStartedButton = By.xpath("//div[@role='button']");

    public Home(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickGetStartedButton() {
        wrapper.click(getStartedButton);
    }
}
