package kristalballtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category {
    private WebDriver driver;
    private Wrappers wrapper;

    private final By itemCards = By.xpath("//div[contains(@class,'flex')]/a");

    public Category(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickPreferredItemCard(String name) {
        for (WebElement itemCard : wrapper.findElements(itemCards)) {
            if (itemCard.getText().equals(name)) {
                itemCard.click();
                break;
            }
        }
    }
}
