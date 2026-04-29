package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.FundTransferPage;
public class FundTransferTest extends BaseTest {

    @Test
    public void testFundTransfer() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr658981", "avEgYzU");

        // Step 2: Go to Fund Transfer
        FundTransferPage fundPage = new FundTransferPage(driver);
        fundPage.clickFundTransfer();

        // ⚠️ IMPORTANT: Replace with real account numbers later
        String payerAccount = System.getProperty("accId1");
        String payeeAccount = System.getProperty("accId2");
        // Step 3: Transfer
        fundPage.transferFund(payerAccount, payeeAccount, "1000", "Test Transfer");

        // Step 4: Validate
        String msg = fundPage.getSuccessMessage();

        Assert.assertTrue(msg.contains("Fund Transfer Details"));
    }
}