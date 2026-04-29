package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import base.BaseTest;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"mngr658981", "avEgYzU", true},
            {"wrongUser", "wrongPass", false}
        };
    }

    // ✅ Combined login test
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean isValid) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (isValid) {
            Assert.assertTrue(driver.getTitle().contains("Guru99 Bank"),
                    "Valid login failed");
        } else {
            Alert alert = loginPage.waitForAlert();
            Assert.assertTrue(alert.getText().toLowerCase().contains("not valid"));
            alert.accept();
        }
    }

    @Test
    public void testScreenshotDemo() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUser", "wrongPass");

        // ✅ Wait for alert
        Alert alert = loginPage.waitForAlert();

        String alertText = alert.getText();

        // ✅ Accept alert FIRST
        alert.accept();

        // ✅ THEN take screenshot
        ScreenshotUtil.captureScreenshot(driver, "InvalidLogin");

        // ✅ Validate
        Assert.assertTrue(alertText.toLowerCase().contains("not valid"));
    }

    // ✅ Alert Validation Test
    @Test
    public void testInvalidLoginAlert() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUser", "wrongPass");

        Alert alert = loginPage.waitForAlert();
        Assert.assertTrue(alert.getText().contains("not valid"));

        alert.accept();
    }
}