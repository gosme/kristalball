package kristalballtests.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import java.util.List;

public class Wrappers {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean navigateToURL(String url) {
        try {
            if (!driver.getCurrentUrl().equals(url)) {
                driver.get(url);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForUrlContains(String text) {
        try {
            return wait.until(ExpectedConditions.urlContains(text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement findElementWithLocator(By locator) {
        RuntimeException lastException = null;
        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        try {
            return fWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            lastException = new NoSuchElementException("Unable to find element after retry: " + locator, e);
        }

        throw lastException == null
                ? new NoSuchElementException("Unable to find element after retry: " + locator)
                : lastException;
    }

    public boolean click(By locator) {
        try {
            WebElement element = findElementWithLocator(locator);
            element.click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean clearAndSendKeys(By locator, String text) {
        try {
            WebElement element = findElementWithLocator(locator);
            element.clear();
            element.sendKeys(text);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String randomEmail() {
        return System.currentTimeMillis() + "@abc.com";
    }

}