package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class FundTransferPage extends BasePage {

    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    private By fundTransferLink = By.linkText("Fund Transfer");
    private By payerAccount = By.name("payersaccount");
    private By payeeAccount = By.name("payeeaccount");
    private By amount = By.name("ammount");
    private By description = By.name("desc");
    private By submitBtn = By.name("AccSubmit");
    private By successMsg = By.xpath("//p[@class='heading3']");

    public void clickFundTransfer() {
        scrollIntoView(fundTransferLink);
        jsClick(fundTransferLink);
    }

    public void transferFund(String payer, String payee, String amt, String desc) {
        type(payerAccount, payer);
        type(payeeAccount, payee);
        type(amount, amt);
        type(description, desc);
        click(submitBtn);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
}