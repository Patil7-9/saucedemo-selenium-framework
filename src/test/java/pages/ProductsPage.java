package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {


    private WebDriver driver;

    private By pageTitle = By.className("title");
    private By cartIcon = By.className("shopping_cart_link");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
