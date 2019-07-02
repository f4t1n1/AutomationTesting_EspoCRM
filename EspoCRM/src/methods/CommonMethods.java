package methods;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CommonMethods {
	@FindBy (how=How.CLASS_NAME, using ="btn-danger")
	WebElement Confirm;
	
	//FOR ASSIGN USER
	@FindBy (how=How.XPATH, using ="//div[@data-name='assignedUser']//button[@data-action='clearLink']")
	WebElement ClearButton;
	@FindBy (how=How.XPATH, using ="//div[@data-name='assignedUser']//button[@data-action='selectLink']")
	WebElement SelectButton;
	@FindBy (how=How.XPATH, using ="//div[@class='input-group']//button[@data-toggle='dropdown']")
	WebElement Filter;
	@FindBy (how=How.XPATH, using ="//a[contains(.,'All')]")
	WebElement Chosen;
	@FindBy (how=How.XPATH, using ="//a[contains(@title,'Admin')]")
	WebElement Assigned;
	
	@FindBy (how = How.XPATH, using="//button[@data-action='save']")
	WebElement SaveButton;
	
	/*FOR ADDRESS*/
	@FindBy (how = How.XPATH, using="//textarea[@autocomplete='espo-street']")
	WebElement Street;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-city']")
	WebElement City;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-state']")
	WebElement State;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-postalCode']")
	WebElement PostalCode;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-country']")
	WebElement Country;
	
	/*FOR DETAILS*/
	@FindBy (how = How.XPATH, using="//select[@data-name='salutationName']/option[3]")
	WebElement SalutationName;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-firstName']")
	WebElement FirstName;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-lastName']")
	WebElement LastName;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-emailAddress']")
	WebElement Email;
	@FindBy (how = How.XPATH, using="//select[@data-property-type='type']/option[2]")
	WebElement PhoneDropdown;
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-phoneNumber']")
	WebElement ContactNumber;
	@FindBy (how = How.XPATH, using="//button[@data-action='addPhoneNumber']")
	WebElement AddPhoneButton;
	@FindBy (how = How.XPATH, using="//select[@data-property-type='type']/option[3]")
	WebElement PhoneDropdown2;
	@FindBy (how = How.XPATH, using="(//input[@autocomplete='espo-phoneNumber'])[2]")
	WebElement SecondContactNumber;
	

	/*FOR CALENDAR*/
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-dateStart']")
	WebElement StartDate;
	@FindBy (how=How.XPATH, using="//input[@autocomplete='espo-dateEnd']")
	WebElement EndDate;
	@FindBy (how=How.XPATH, using ="//input[@data-name=\"dateStart-time\"]")
	WebElement StartTime;
	@FindBy (how=How.XPATH, using ="//input[@data-name=\"dateEnd-time\"]")
	WebElement EndTime;
	
	//*CHOOSE ACCOUNT 
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-account']")
	WebElement Account;
	@FindBy (how = How.XPATH, using="//button[@class='btn btn-link btn-sm dropdown-toggle']")
	WebElement CrossButton;
	@FindBy (how = How.XPATH, using="//a[@data-column='isInactive']")
	WebElement InactiveButton;
	
	//*CHOOSE CONTACT
	@FindBy (how = How.XPATH, using="//div[@data-name='contacts']//button[@data-action='selectLink']")
	WebElement SelectContact;
	@FindBy (how = How.XPATH, using="//a[@class='link']")
	WebElement SelectName;
	@FindBy (how = How.XPATH, using="//div[@data-name='contacts']//select[@class='role form-control input-sm pull-right']/option[2]")
	WebElement ContactTitle;
	
	//*FOR ATTACHMENT
	@FindBy (how = How.XPATH, using="//span[@class='btn btn-default btn-icon']")
	WebElement UploadButton;
	
	//*CHOOSE ATTENDESS
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-users']")
	WebElement UserField;
	@FindBy (how = How.XPATH, using="//div[@data-name='leads']//button[@data-action='selectLink']")
	WebElement SelectLead;
	@FindBy (how = How.XPATH, using="//div[@data-name='users']//select[@class='role form-control input-sm pull-right']/option[2]")
	WebElement UserAttendStatus;
	@FindBy (how = How.XPATH, using="//div[@data-name='leads']//select[@class='role form-control input-sm pull-right']/option[2]")
	WebElement LeadAttendStatus;
	
	
	//*REMINDERS
	@FindBy (how = How.XPATH, using="//button[@data-action='addReminder']")
	WebElement ReminderButton;
	@FindBy (how = How.XPATH, using="//select[@name='type']/option[2]")
	WebElement ReminderDropdown;
	@FindBy (how = How.XPATH, using="//select[@name='seconds']/option[5]")
	WebElement ReminderTimeDropdown;
	@FindBy (how = How.XPATH, using="//select[@data-name='parentType']/option[3]")
	WebElement ParentDropdown;
	@FindBy (how = How.XPATH, using="//div[@data-name='parent']//button[@data-action='selectLink']")
	WebElement SelectParentButton;
	
	//*MEETING & CALL STATUS DROPDOWN
	@FindBy (how = How.XPATH, using="//select[@data-name='status']/option[1]")
	WebElement StatusDropdown;
	
	@FindBy (how = How.XPATH, using="//input[@autocomplete='espo-name']")
	WebElement NameField;
	
	@FindBy (how=How.XPATH, using ="//div[@class='modal-content']")
	WebElement ModalBox;
	
	//*DESCRIPTION TEXT FIELD
	@FindBy (how = How.XPATH, using="//textarea[@autocomplete='espo-description']")
	WebElement DescField;
	
	WebDriver driver;
	
	public CommonMethods (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void exitDialog() {
		Confirm.click();	
	}
	
	public void assignUser() {
		ClearButton.click();
		SelectButton.click();
		Filter.click();
		Chosen.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assigned.click();
	}
	
	public void clickSave() {
		SaveButton.click();
	}
	
	public void fillName(String name) {
		NameField.sendKeys(name);
	}
	
	public void fillDetails(String fname, String lname, String email, String number, String number2) {
		SalutationName.click();
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Email.sendKeys(email);
		PhoneDropdown.click();
		ContactNumber.sendKeys(number);
		AddPhoneButton.click();
		PhoneDropdown2.click();
		SecondContactNumber.sendKeys(number2);
	}
	
	
	public void fillAddress(String street, String city, String state, String postal_code, String country) {
		Street.sendKeys(street);
		City.sendKeys(city);
		State.sendKeys(state);
		PostalCode.sendKeys(postal_code);
		Country.sendKeys(country);
	}
	
	public void fillCalendar(String startDate, String startTime, String endDate, String endTime) {
		StartDate.clear();
		StartDate.sendKeys(startDate);
		StartTime.click();
		StartTime.clear();
		StartTime.sendKeys(startTime);
		StartTime.sendKeys(Keys.ENTER);
		
		EndDate.clear();
		EndDate.sendKeys(endDate);
		EndTime.click();
		EndTime.clear();
		EndTime.sendKeys(endTime);
		EndTime.sendKeys(Keys.ENTER);
	}
	
	public void fillDesc(String desc) {
		DescField.sendKeys(desc);
	}
	
	public void chooseAccount(String account) {
		Account.sendKeys(account);
		Account.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account.sendKeys(Keys.ENTER);
	}
	
	public void chooseContact() {
		SelectContact.click();
		SelectName.click();
		//ContactTitle.click();
	}
	
	public void chooseContactTitle() {
		ContactTitle.click();
	}
	
	public void uploadFile(WebDriver driver) {
		UploadButton.click();
		
		// switch to the file upload window
		driver.switchTo().activeElement().sendKeys((System.getProperty("user.dir")+"\\img\\Screenshot.jpg"));

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Exit Windows popup by pressing ESCAPE button
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void chooseAttendees(String user) {
		
		UserField.sendKeys(user);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserField.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserField.sendKeys(Keys.ENTER);
		UserAttendStatus.click();
		
		SelectLead.click();
		SelectName.click();
		LeadAttendStatus.click();	
	}
	
	public void addReminder() {
		ReminderButton.click();
		ReminderDropdown.click();
		ReminderTimeDropdown.click();
	}
	
	public void selectParent() {
		
		ParentDropdown.click();
		SelectParentButton.click();
		SelectName.click();
	}
	
	public void chooseStatus() {
		StatusDropdown.click();
	}
	
	public void scrollPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-2500)");
	}
	
	public void closeModal() {
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		if (ModalBox.isDisplayed()) {
			SaveButton.click();
		}	
			
	}
	
	public void waitEelement() {
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOf(SavedRecord));
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

