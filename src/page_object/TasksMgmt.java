package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TasksMgmt {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),\"Create Task\")]")
	WebElement CreateTaskButton;
	@FindBy(how = How.XPATH, using = "//select[@data-name='status']/option[2]")
	WebElement StatusDropdown;
	@FindBy(how = How.XPATH, using = "//select[@data-name='priority']/option[2]")
	WebElement PriorityDropdown;

	public TasksMgmt(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getButton() {
		return CreateTaskButton.isDisplayed();
	}

	public void userTask() {

		CreateTaskButton.click();
	}

	public void fillForm() {

		StatusDropdown.click();
		PriorityDropdown.click();

	}

}
