EspoCRM is a web-based Customer Relation Management (CRM) application. 

source code can be found under src folder

===================================================================================
TO RUN EXECUTABLE JAR FILE: EspoCRM.jar
=======================================
1. Please ensure EspoCRM is installed on local computer.

2. Please ensure Xampp is started before running the jar file.

3. webdriver folder consists of chromedriver while img folder consists of the image needed for file attachment function.

4. Please run test.jar by using the following command in the command prompt:
	java -jar EspoCRM.jar

5. It will take sometime to load and about 3-4 minutes to execute the 1st test case: login.

6. It will also take about 2-3 mintutes for the webdriver to close and quit browser as it wrote the test results onto HTML report.

7. After execution finished, a test-output folder will be generated which consists of testNG and Extent Reporting reports.

8. The reports can be found under the following directory:
	EspoCRM/test-output/index.html
	EspoCRM/test-output/ExtentReport.html 



====================================================================================
TO RUN ECLIPSE PROJECT:
=========================
1. img folder consists of image file for attachment function

2. webdriver folder consists of chromedriver.exe

3. To run the eclipse project, please create an external user library and import all the Selenium & Extent Reports external jars under the following directory into Eclipse:
	EspoCRM/lib/Selenium Jars (for Selenium)
	EspoCRM/lib/extentreports-java-2.41.2 (for Extent Reports library)
