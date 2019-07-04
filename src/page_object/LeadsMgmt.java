package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeadsMgmt {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Lead\")]")
	WebElement CreateLeadButton;
	@FindBy (how = How.XPATH, using="//select[@data-name='status']/option[3]")
	WebElement StatusDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='source']/option[5]")
	WebElement SourceDropdown;
	@FindBy (how = How.XPATH, using="//input[@data-name='opportunityAmount']")
	WebElement Amount;
	@FindBy (how = How.XPATH, using="//select[@data-name='opportunityAmountCurrency']/option[text()='NZD']")
	WebElement CurrencyDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='industry']/option[text()='Banking']")
	WebElement IndustryDropdown;
	
	public LeadsMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateLeadButton.isDisplayed();	
	}

	public void userLead() {
		CreateLeadButton.click();
	}
	
	public void fillDetails(String amount) {
		
		StatusDropdown.click();
		SourceDropdown.click();
		Amount.sendKeys(amount);
		CurrencyDropdown.click();
		IndustryDropdown.click();
		
	}
	

}
