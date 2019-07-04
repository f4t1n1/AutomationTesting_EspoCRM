package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesMgmt {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Opportunity\")]")
	WebElement CreateOpportunityButton;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-name']")
	WebElement NameField;
	@FindBy (how = How.XPATH, using="//select[@data-name='stage']/option[4]")
	WebElement StageDropdown;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-closeDate']")
	WebElement CloseDate;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-probability']")
	WebElement ProbabilityField;
	@FindBy (how = How.XPATH, using="//select[@data-name='leadSource']/option[3]")
	WebElement SourceDropdown;
	@FindBy (how=How.XPATH, using ="//button[@data-action='selectLink']")
	WebElement SelectButton;
	@FindBy (how = How.XPATH, using="//input[@data-name='amount']")
	WebElement Amount;
	@FindBy (how = How.XPATH, using="//select[@data-name='amountCurrency']/option[text()='NZD']")
	WebElement CurrencyDropdown;
	
	public OpportunitiesMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateOpportunityButton.isDisplayed();	
	}
	
	public void userOpportunity() {
		CreateOpportunityButton.click();
	}
	
	public void fillForm (String name, String closeDate, String amount, String percentage) {
		NameField.sendKeys(name);
		StageDropdown.click();
		Amount.sendKeys(amount);
		CurrencyDropdown.click();
		CloseDate.sendKeys(closeDate);
		ProbabilityField.clear();
		ProbabilityField.sendKeys(percentage);
		SourceDropdown.click();
		
	}

}
