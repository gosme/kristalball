package kristalballtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static final String DEFAULT_APPLICATION_URL = "https://smartpad-customer-feedback.vercel.app";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1080");
            
            // Run headless in CI environment
            if (System.getenv("CI") != null || Boolean.getBoolean("headless")) {
                options.addArguments("--headless=new");
            }

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static String getBaseUrl() {
        return DEFAULT_APPLICATION_URL;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}