package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;


public class LoginTests extends BaseTest {


    @Test(priority=1)
    public void validLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Test(priority=2)
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"));
    }

    @Test(priority=3)
    public void lockedOutUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    @Test(priority=4)
    public void emptyCredentialsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test(priority=5)
    public void logout() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        new ProductsPage(driver).logout();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
    }
}
