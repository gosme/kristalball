package kristalballtests.ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import kristalballtests.pages.Home;
import kristalballtests.pages.Category;
import kristalballtests.pages.LoginModal;
import kristalballtests.pages.AgeModal;
import kristalballtests.pages.Register;
import kristalballtests.DriverManager;

public class AuthenticationTests extends BaseTest {

    @Test(priority = 9, groups = {"sanity"}, description = "Anonymous Access")
    public void TestCase09() {
        Home homePage = new Home(driver);

        Assert.assertTrue(wrapper.navigateToURL(DriverManager.getBaseUrl()),"Landing Page is not loaded successfully");

        homePage.clickGetStartedButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/alcohol-types"),"Alcohol Types Page is not loaded successfully");
    
        Category categoryPage = new Category(driver);
        categoryPage.clickPreferredItemCard("Beer");

        Assert.assertTrue(wrapper.waitForUrlContains("/auth/products?alcoholType"),"Catalog Page for selected alcohol type is not loaded successfully");

        LoginModal loginModal = new LoginModal(driver);
        Assert.assertTrue(loginModal.isLoginModalVisible(),"Login Modal is not visible");

        loginModal.clickRegisterButton();

        Assert.assertTrue(wrapper.waitForUrlContains("/signup"),"Signup Page is not loaded successfully");

        AgeModal ageModal = new AgeModal(driver);
        Assert.assertTrue(ageModal.isAgeModalVisible(),"Age Modal is not visible");
        ageModal.clickYesButton();

        Register registerPage = new Register(driver);
        registerPage.signupUser("John Doe", wrapper.randomEmail(), "password", "password");    
        Assert.assertTrue(registerPage.isOTPScreen(),"OTP Screen is not visible");
        
    }
}