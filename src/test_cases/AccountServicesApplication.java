package test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;






import utilities.ExcelUtils;
//import org.testng.annotations.DataProvider;
import utility_methods.HelperFunctions;


public class AccountServicesApplication {

 public WebDriver driver;
 HelperFunctions enter = new HelperFunctions();

 @Test (dataProvider="data")
 public void account_services_application_test(String username,String password, String firstName, String lastName, String address, String zip, String dateOfBirth, String sex, String occupation, String id, String idState, String dateIssued, String dateExpire, String selectID, String phone, String branch, String amount) throws InterruptedException {

  enter.login(driver, username, password);
  enter.openApplication(driver);
  
  Thread.sleep(100);
  //switch to the Iframe
  driver.switchTo().frame(0);

  //Complete the form inside Iframe
  enter.personalData(driver);


  //fill the Primary Applicant Information
  enter.fillApplicantInfo(driver, firstName, lastName, address, zip);

  //Identification information
  enter.indentificationInfo(driver, dateOfBirth, sex, occupation, id, idState, dateIssued, dateExpire, selectID);

  //Contact Information
  enter.contactInfo(driver, phone, branch);

  //funding requirements
  enter.fundingRequirements(driver, amount);


  //verify that the application is complete
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  WebElement result = driver.findElement(By.id("ctl00_MainContentPlaceHolder_lblIndividualName_Label"));
  Assert.assertTrue(result.isDisplayed());
  System.out.println("Application Complete ");

 }


 @BeforeMethod
 public void beforeMethod() {
  System.setProperty("webdriver.ie.driver", "./IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
  driver = new InternetExplorerDriver();
  
 }

 @AfterMethod
 public void afterMethod() throws InterruptedException {

  Thread.sleep(1000);

  driver.quit();
 }
 
 @DataProvider
 public Object[][] data() throws Exception{

      Object[][] testObjArray = ExcelUtils.getTableArray("C://workspace//Test_Automation//src//testData//TestData.xlsx","Sheet1");

      return (testObjArray);

		}

}