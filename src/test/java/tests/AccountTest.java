package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;

public class AccountTest extends BaseTest {

    @Test
    public void testCreateAccount() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr658981", "avEgYzU");

        // Step 2: Go to New Account
        NewAccountPage accountPage = new NewAccountPage(driver);

        String customerId = System.getProperty("custId");

        if (customerId == null) {
            throw new RuntimeException("Customer ID is null. Run CustomerTest first.");
        }

        // =========================
        // ✅ CREATE FIRST ACCOUNT
        // =========================
        accountPage.clickNewAccount();
        accountPage.createAccount(customerId, "Savings", "5000");

        String msg1 = accountPage.getSuccessMessage();
        Assert.assertTrue(msg1.contains("Account Generated Successfully"));

        String accId1 = accountPage.getAccountId();
        System.out.println("Account1 ID: " + accId1);

        // =========================
        // ✅ CREATE SECOND ACCOUNT
        // =========================
        accountPage.clickNewAccount();
        accountPage.createAccount(customerId, "Savings", "5000");

        String msg2 = accountPage.getSuccessMessage();
        Assert.assertTrue(msg2.contains("Account Generated Successfully"));

        String accId2 = accountPage.getAccountId();
        System.out.println("Account2 ID: " + accId2);

        // =========================
        // ✅ STORE BOTH ACCOUNTS
        // =========================
        System.setProperty("accId1", accId1);
        System.setProperty("accId2", accId2);
    }
}