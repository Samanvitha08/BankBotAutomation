package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import base.BasePage;
public class NewAccountPage extends BasePage {

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By newAccountLink = By.linkText("New Account");
    private By customerId = By.name("cusid");
    private By accountType = By.name("selaccount");
    private By initialDeposit = By.name("inideposit");
    private By submitBtn = By.name("button2");

    private By successMsg = By.xpath("//p[@class='heading3']");

    // Actions

    public void clickNewAccount() {
        click(newAccountLink);
    }

    public void createAccount(String custId, String accType, String deposit) {

        type(customerId, custId);

        Select select = new Select(waitForElement(accountType));
        select.selectByVisibleText(accType);

        type(initialDeposit, deposit);
        click(submitBtn);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
    public String getAccountId() {
        return driver.findElement(By.xpath("//td[text()='Account ID']/following-sibling::td")).getText();
    }
}