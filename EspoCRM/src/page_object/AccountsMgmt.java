package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountsMgmt {
	
	WebDriver driver;
	String expected = null;
	String actual = null;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Account\")]")
	WebElement CreateAccountButton;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-name']")
	WebElement NameField;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-website']")
	WebElement WebField;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-emailAddress']")
	WebElement EmailField;
	@FindBy (how = How.XPATH, using="//button[@data-action='addEmailAddress']")
	WebElement AddEmailButton;
	@FindBy (how = How.XPATH, using="(//input[@autocomplete='espo-emailAddress'])[2]")
	WebElement SecondEmailField;
	@FindBy (how = How.XPATH, using="//select[@class='form-control']/option[3]")
	WebElement PhoneDropdown;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-phoneNumber']")
	WebElement ContactNumber;
	@FindBy (how = How.XPATH, using="//button[contains(.,'Copy Billing')]")
	WebElement CopyAddress;
	@FindBy (how = How.XPATH, using="//select[@data-name='type']/option[3]")
	WebElement TypeDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='industry']/option[text()='Technology']")
	WebElement IndustryDropdown;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-sicCode']")
	WebElement SicCode;
	
	public AccountsMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateAccountButton.isDisplayed();	
	}
	
	public void userAccount() {
		CreateAccountButton.click();		
	}
	
	public void fillForm(String name,String website, String email, String email2,String number) {
		
		NameField.sendKeys(name);
		WebField.sendKeys(website);
		EmailField.sendKeys(email);
		AddEmailButton.click();
		SecondEmailField.sendKeys(email2);
		PhoneDropdown.click();
		ContactNumber.sendKeys(number);
		
	}
	
	
	
	public void fillDetails(String sic_code) {
		CopyAddress.click();
		TypeDropdown.click();
		SicCode.sendKeys(sic_code);
		IndustryDropdown.click();		
	}
	
	


}
