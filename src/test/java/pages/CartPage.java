package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;


    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public void removeBackpack() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBackpackButton)).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();    }
}