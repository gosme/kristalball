package kristalballtests.ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import kristalballtests.pages.Home;
import kristalballtests.pages.Category;
import kristalballtests.pages.LoginModal;
import kristalballtests.pages.AgeModal;
import kristalballtests.DriverManager;

public class AccessControlTests extends BaseTest {
    
    @Test(priority = 1, groups = {"sanity"}, description = "Unrestricted Access", enabled = true)
    public void TestCase01() {
        Home homePage = new Home(driver);

        Assert.assertTrue(wrapper.navigateToURL(DriverManager.getBaseUrl()),"Landing Page is not loaded successfully");

        homePage.clickGetStartedButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/alcohol-types"),"Alcohol Types Page is not loaded successfully");
    }

    @Test(priority = 2, groups = {"sanity"}, description = "Login Interception", enabled = true)
    public void TestCase02() {
        Home homePage = new Home(driver);

        Assert.assertTrue(wrapper.navigateToURL(DriverManager.getBaseUrl()),"Landing Page is not loaded successfully");

        homePage.clickGetStartedButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/alcohol-types"),"Alcohol Types Page is not loaded successfully");
    
        Category categoryPage = new Category(driver);
        categoryPage.clickPreferredItemCard("Beer");

        Assert.assertTrue(wrapper.waitForUrlContains("/auth/products?alcoholType"),"Catalog Page for selected alcohol type is not loaded successfully");

        LoginModal loginModal = new LoginModal(driver);
        Assert.assertTrue(loginModal.isLoginModalVisible(),"Login Modal is not visible");
    }

    @Test(priority = 3, groups = {"sanity"}, description = "Anonymous Access", enabled = true)
    public void TestCase03() {
        Home homePage = new Home(driver);

        Assert.assertTrue(wrapper.navigateToURL(DriverManager.getBaseUrl()),"Landing Page is not loaded successfully");

        homePage.clickGetStartedButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/alcohol-types"),"Alcohol Types Page is not loaded successfully");
    
        Category categoryPage = new Category(driver);
        categoryPage.clickPreferredItemCard("Beer");

        Assert.assertTrue(wrapper.waitForUrlContains("/auth/products?alcoholType"),"Catalog Page for selected alcohol type is not loaded successfully");

        LoginModal loginModal = new LoginModal(driver);
        Assert.assertTrue(loginModal.isLoginModalVisible(),"Login Modal is not visible");

        loginModal.clickContinueWithoutAccountButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/products?alcoholType"),"Catalog Page for selected alcohol type is not loaded successfully");

        AgeModal ageModal = new AgeModal(driver);
        Assert.assertTrue(ageModal.isAgeModalVisible(),"Age Modal is not visible");
    }
}