package page_object;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactsMgmt {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Contact\")]")
	WebElement CreateContactButton;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-accounts']")
	WebElement Account;
	@FindBy (how = How.XPATH, using="//button[@class='btn btn-link btn-sm dropdown-toggle']")
	WebElement CrossButton;
	@FindBy (how = How.XPATH, using="//a[@data-column='isInactive']")
	WebElement InactiveButton;
	
	public ContactsMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateContactButton.isDisplayed();	
	}
	
	public void userContact() {

		CreateContactButton.click();		
	}
	

	public void chooseAccount(String account) {
		Account.sendKeys(account);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account.sendKeys(Keys.ARROW_DOWN);
		Account.sendKeys(Keys.ENTER);
		
		CrossButton.click();
		//CrossButton.sendKeys(Keys.ARROW_DOWN);
		InactiveButton.click();

	}

}
