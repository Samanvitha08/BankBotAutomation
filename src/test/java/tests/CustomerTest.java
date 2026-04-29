package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.NewCustomerPage;

public class CustomerTest extends BaseTest {

	@Test
	public void testCreateCustomer() {

	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login("mngr658981", "avEgYzU");

	    NewCustomerPage customerPage = new NewCustomerPage(driver);
	    customerPage.clickNewCustomer();

	    String email = "test" + System.currentTimeMillis() + "@gmail.com";

	    customerPage.createCustomer(
	            "Samanvitha",
	            "01011990",
	            "Hyderabad",
	            "Hyderabad",
	            "Telangana",
	            "500001",
	            "9876543210",
	            email,
	            "password123"
	    );

	    String msg = customerPage.getSuccessMessage();
	    Assert.assertTrue(msg.contains("Customer Registered Successfully"));

	    // ✅ Capture ID
	    String customerId = customerPage.getCustomerId();
	    System.out.println("Customer ID: " + customerId);

	    // ✅ Store globally
	    System.setProperty("custId", customerId);
	}
}