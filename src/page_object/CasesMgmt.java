package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CasesMgmt {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Case\")]")
	WebElement CreateCaseButton;
	@FindBy (how = How.XPATH, using="//select[@data-name='status']/option[5]")
	WebElement StatusDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='priority']/option[3]")
	WebElement PriorityDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='type']/option[3]")
	WebElement TypeDropdown;
	
	public CasesMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateCaseButton.isDisplayed();	
	}
	
	public void userCase() {

		CreateCaseButton.click();		
	}
	
	public void fillForm() {
		
		StatusDropdown.click();
		PriorityDropdown.click();
		TypeDropdown.click();
	}
	

}
