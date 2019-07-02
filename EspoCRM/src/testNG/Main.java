package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_object.AccountsMgmt;
import page_object.Login;
import page_object.Logout;
import page_object.ContactsMgmt;
import page_object.LeadsMgmt;
import page_object.OpportunitiesMgmt;
import page_object.CasesMgmt;
import page_object.MeetingsMgmt;
import page_object.CallsMgmt;
import page_object.TasksMgmt;
import page_object.Homepage;
import methods.CommonMethods;
/*
 * 
 * AUTHOR: FATINI MOBARAYA
 * STUDENT ID: 18481002
 * 
 */
public class Main {

	WebDriver driver;
	public String expected = null;
	public String actual = null;
	ExtentReports extent;
	ExtentTest logger;
	private final String APP_URL = "http://localhost/EspoCRM-5.6.1/";
	private final String DRIVER_PATH = System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe";
	Homepage HomePO;
	CommonMethods commonMethodObject; 
	Login loginObject;
	AccountsMgmt accountObject;
	ContactsMgmt contactObject;
	LeadsMgmt leadObject;
	OpportunitiesMgmt opportunityObject;
	CasesMgmt caseObject;
	MeetingsMgmt meetingObject;
	CallsMgmt callObject;
	TasksMgmt taskObject;
	Logout logoutObject;
	
	
	@BeforeSuite
	public void initiateBrowser() {
		
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		HomePO = new Homepage(driver);
		commonMethodObject = new CommonMethods(driver);
		
	}
	
	@BeforeTest
	public void getURL() {
		
		driver.get(APP_URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		expected = "EspoCRM";
  	  	actual = driver.getTitle();
  	  	Assert.assertEquals(actual, expected);	
  	  	
	}
	
	@BeforeTest
	public void reportConfig() {
		//*EXTENT REPORT HTML DOCS GENERATION, THE 'TRUE' VALUE WILL REPLACE THE OLD REPORTS WITH THE NEW ONE AFTER EACH EXECUTION
		//*REPORT CAN BE FOUND UNDER THE FOLLOWING PATH: TEST OUTPUT FOLDER/EXTENTREPORT.HTML
  	  	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
  	  	
		//*SETTING UP EXTENT REPORTS ENVIRONMENT DETAILS
		extent
              .addSystemInfo("Host Name", "EspoCRM")
              .addSystemInfo("Environment", "Automation Testing")
              .addSystemInfo("User Name", "Fatini Mobaraya");
		
        //*LOADS EXTENT REPORTS XML CONFIGURATION FOR THE REPORT'S DESIGN LAYOUT
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
  	  	
	}
	
	@BeforeMethod
	public void startReport(Method method){
		//*START GENERATING HTML REPORTS FOR EVERY METHOD 
		//*LOGS EVERY TEST RESULTS BY THE METHOD'S NAME
        logger = extent.startTest( (this.getClass().getSimpleName() +" : "+ method.getName()));
	}
	
	//*START TEST CASES
	//*TC_01: LOGIN
	@Test (priority=0)
	public void Login() {
		
		Login loginObject = new Login(driver);
		HomePO = loginObject.userLogin("admin", "test01");
		Assert.assertTrue(HomePO.returnLink());
		
	}
	
	//*TC_02: ACCOUNTS MANAGEMENT
	@Test (priority=1)
	public void Accounts() {
		
		accountObject = HomePO.clickAccounts();
		Assert.assertTrue(accountObject.getButton());
		
		accountObject.userAccount();
		expected = "http://localhost/EspoCRM-5.6.1/#Account/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		accountObject.fillForm("AGI", "agi.co.nz", "info@agi.co.nz", "hello@agi.co.nz","09-7890456");
		commonMethodObject.fillAddress("190 Great South Rd", "Epsom", "Auckland", "1032","New Zealand");
		accountObject.fillDetails("010");
		commonMethodObject.fillDesc("Education Partner");
		commonMethodObject.scrollPage(driver);
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
		
		//*TO CLOSE MODAL BOX IN CASE OF REDUNDANT DATA
		//commonMethodObject.closeModal();
		
	}
	
	//*TC_03: CONTACTS MANAGEMENT
	@Test (priority=2)
	public void Contacts() {

		commonMethodObject.waitEelement();
		contactObject = HomePO.clickContacts();
		Assert.assertTrue(contactObject.getButton());
		
		contactObject.userContact();
		expected = "http://localhost/EspoCRM-5.6.1/#Contact/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillDetails("Anna", "Korski", "AnnaKorski@gmail.com", "016-7895342","09-45378297");
		contactObject.chooseAccount("AGI");
		commonMethodObject.fillAddress("190 Great South Rd", "Epsom", "Auckland", "1032","New Zealand");
		commonMethodObject.fillDesc("Test101");
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
		
		//*TO CLOSE MODAL BOX IN CASE OF REDUNDANT DATA
		//commonMethodObject.closeModal();
	}
	
	//*TC_04: LEADS MANAGEMENT
	@Test (priority=3)
	public void Leads() {

		commonMethodObject.waitEelement();
		leadObject = HomePO.clickLeads();
		Assert.assertTrue(leadObject.getButton());
		
		leadObject.userLead();
		expected = "http://localhost/EspoCRM-5.6.1/#Lead/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillDetails("oNE", "Two", "eone@gmail.com", "016-7895342","03-7615347");
		commonMethodObject.fillAddress("190 Great South Rd", "Epsom", "Auckland", "1032","New Zealand");
		leadObject.fillDetails("100,000");
		commonMethodObject.fillDesc("Partners");
		commonMethodObject.scrollPage(driver);
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
		
		//*TO CLOSE MODAL BOX IN CASE OF REDUNDANT DATA
		//commonMethodObject.closeModal();
	}
	
	//*TC_05: OPPORTUNITIES MANAGEMENT
	@Test (priority=4)
	public void Opportunities() {

		commonMethodObject.waitEelement();
		opportunityObject = HomePO.clickOpportunities();
		Assert.assertTrue(opportunityObject.getButton());

		opportunityObject.userOpportunity();
		expected = "http://localhost/EspoCRM-5.6.1/#Opportunity/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		opportunityObject.fillForm("AGI", "12/06/2019", "100,105", "30%");
		commonMethodObject.chooseContact();
		commonMethodObject.chooseContactTitle();
		commonMethodObject.chooseAccount("AGI");
		commonMethodObject.fillDesc("Partner");
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
	}
	
	//*TC_06: CASES MANAGEMENT
	@Test (priority=5)
	public void Cases() {

		commonMethodObject.waitEelement();
		caseObject = HomePO.clickCases();
		Assert.assertTrue(caseObject.getButton());
		
		caseObject.userCase();
		expected = "http://localhost/EspoCRM-5.6.1/#Case/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillName("Case 101");
		caseObject.fillForm();
		commonMethodObject.chooseAccount("AGI");
		commonMethodObject.chooseContact();
		commonMethodObject.fillDesc("Education Issues");
		commonMethodObject.uploadFile(driver);
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
		
	}
	
	//*TC_07: MEETINGS MANAGEMENT
	@Test (priority=6)
	public void Meetings() {
	
		commonMethodObject.waitEelement();
		meetingObject = HomePO.clickMeetings();
		Assert.assertTrue(meetingObject.getButton());

		meetingObject.userMeeting();
		expected = "http://localhost/EspoCRM-5.6.1/#Meeting/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillName("Ad Hoc Meetings");
		commonMethodObject.selectParent();
		commonMethodObject.chooseStatus();
		commonMethodObject.fillCalendar("11/18/2019","1100am","11/19/2019","1200pm");
		commonMethodObject.addReminder();
		commonMethodObject.fillDesc("Meeting 1091");
		commonMethodObject.assignUser();
		commonMethodObject.chooseAttendees("admin");
		commonMethodObject.chooseContact();
		commonMethodObject.chooseContactTitle();
		commonMethodObject.clickSave();
	}
	
	//*TC_08: CALLS MANAGEMENT
	@Test (priority=7)
	public void Calls() {
		
		commonMethodObject.waitEelement();
		callObject = HomePO.clickCalls();
		Assert.assertTrue(callObject.getButton());
		
		callObject.userCall();
		expected = "http://localhost/EspoCRM-5.6.1/#Call/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillName("Follow up Call");
		commonMethodObject.selectParent();
		commonMethodObject.chooseStatus();
		commonMethodObject.fillCalendar("11/18/2019","1100am","11/19/2019","1200pm");
		commonMethodObject.addReminder();
		commonMethodObject.fillDesc("Call 1091");
		commonMethodObject.assignUser();
		commonMethodObject.chooseAttendees("admin");
		commonMethodObject.chooseContact();
		commonMethodObject.chooseContactTitle();
		commonMethodObject.clickSave();

	}
	
	//*TC_09: TASKS MANAGEMENT
	@Test (priority=8)
	public void Tasks() {
		
		commonMethodObject.waitEelement();
		taskObject = HomePO.clickTasks();
		Assert.assertTrue(taskObject.getButton());
		
		taskObject.userTask();
		expected = "http://localhost/EspoCRM-5.6.1/#Task/create";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		commonMethodObject.fillName("Task 203");
		commonMethodObject.selectParent();
		taskObject.fillForm();
		commonMethodObject.fillCalendar("18/11/2019","1100am","19/11/2019","1200pm");
		commonMethodObject.addReminder();
		commonMethodObject.fillDesc("Task 190");
		commonMethodObject.uploadFile(driver);
		commonMethodObject.assignUser();
		commonMethodObject.clickSave();
	}
	
	//*TC_10: LOGOUT
	@Test (priority=9)
	public void Logout() {

		commonMethodObject.waitEelement();
		
		logoutObject = HomePO.clickLogout();
		loginObject = logoutObject.userLogout();
		Assert.assertTrue(loginObject.getButton());
		

	}
	
	//*GETTING THE TEST RESULTS OF EVERY TEST CASES EXECUTION
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}
		//*CAPTURE SCREENSHOTS FOR FAILED TEST CASES
		else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Error is Caused By " + result.getThrowable());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir") + "/test-output/ErrorScreenhots"
					+ System.currentTimeMillis() + ".png");
			FileHandler.copy(scrFile, dest);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(dest.getAbsolutePath()) + " Test Failed ");

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		//*ENDS CURRENT TEST SUITE AND PREPARE TO WRITE TO THE HTML DOCS
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endReport(){
		//*WRITE TEST RESULTS TO THE HTML DOCS
        extent.flush();
        //*CLOSE ALL EXTENT REPORTS SESSION
        extent.close();
        
        driver.close();
                
    }
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		//*SET WEBDRIVER MEMORY RESOURCE TO NULL
		driver = null;	
		
	}

}