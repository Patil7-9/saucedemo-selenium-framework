package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
}