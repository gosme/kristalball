package kristalballtests.ui_tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import kristalballtests.DriverManager;
import kristalballtests.pages.Wrappers;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Wrappers wrapper;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        driver = DriverManager.getDriver();
        wrapper = new Wrappers(driver);
        wrapper.navigateToURL(DriverManager.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}