package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
public class NewCustomerPage extends BasePage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By newCustomerLink = By.linkText("New Customer");
    private By customerName = By.name("name");
    private By genderMale = By.xpath("//input[@value='m']");
    private By dob = By.id("dob");
    private By address = By.name("addr");
    private By city = By.name("city");
    private By state = By.name("state");
    private By pin = By.name("pinno");
    private By mobile = By.name("telephoneno");
    private By email = By.name("emailid");
    private By password = By.name("password");
    private By submitBtn = By.name("sub");

    private By successMsg = By.xpath("//p[@class='heading3']");

    // Actions

    public void clickNewCustomer() {
        click(newCustomerLink);
    }

    public void createCustomer(String name, String date, String addr,
                               String cityName, String stateName,
                               String pinCode, String phone,
                               String mail, String pass) {

        type(customerName, name);
        click(genderMale);
        type(dob, date);
        type(address, addr);
        type(city, cityName);
        type(state, stateName);
        type(pin, pinCode);
        type(mobile, phone);
        type(email, mail);
        type(password, pass);
        click(submitBtn);
    }
    public String getCustomerId() {
        return driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
    
}