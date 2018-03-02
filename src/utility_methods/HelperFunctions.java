package utility_methods;

import java.util.concurrent.TimeUnit;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HelperFunctions {


 public void personalData(WebDriver driver) {

  driver.findElement(By.id("btnNext_SubmitButton")).click();
  driver.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_rbFamily']/div/ins[@class='iCheck-helper']")).click();
  driver.findElement(By.id("NextButton_SubmitButton")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }

 public void login(WebDriver driver, String username, String password) {

  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://works-preprod.fivision.com/Login.aspx?ReturnUrl=%2fdefault.aspx");
  driver.findElement(By.id("tbfiVISIONID")).sendKeys(username);
  driver.findElement(By.id("tbPassword")).sendKeys(password);
  driver.findElement(By.id("ctl00_cphMainContent_btnLogin")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  System.out.println("Automated User Login Successful");
 }

 public void openApplication(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  driver.findElement(By.xpath("//*[@id='NewMenuTest']/div[2]/span/span[1][@title='New Application']")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//*[@id='5000169']/li[1]/a[2]/span")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  System.out.println("Trying to open the iframe");
 }

 public void fillApplicantInfo(WebDriver driver, String firstName, String lastName, String address, String zip) {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	 
  driver.findElement(By.id("tbFirstName_TextBox")).sendKeys(firstName);
  driver.findElement(By.id("tbLastName_TextBox")).sendKeys(lastName);
  driver.findElement(By.id("AddressTextBox_AddressLine1")).sendKeys(address);
  driver.findElement(By.id("AddressTextBox_AddressCityStateZip")).sendKeys(zip);
  System.out.println("Filling the personal details in application");
 }

 public void indentificationInfo(WebDriver driver, String dateOfBirth, String sex, String occupation, String id, String idState, String dateIssued, String dateExpire, String selectID) {

  Random number = new Random();
  int num = number.nextInt(9000000) + 600000000;
  driver.findElement(By.id("SSNTextBox_TextBox")).sendKeys("" + num);
  driver.findElement(By.id("tbBirthDate_RadDatePicker")).sendKeys(dateOfBirth);
  driver.findElement(By.id("GenderComboBox_DropDownList")).sendKeys(sex);
  driver.findElement(By.id("Occupation_TextBox")).sendKeys(occupation);
  driver.findElement(By.id("tbDriversLicenseNo_TextBox")).sendKeys(id);
  driver.findElement(By.id("ddlIDState_DropDownList")).sendKeys(idState);
  driver.findElement(By.id("tbDriversLicenseIssue_RadDatePicker")).sendKeys(dateIssued);
  driver.findElement(By.id("tbDriversLicenseExpiration_RadDatePicker")).sendKeys(dateExpire);
  driver.findElement(By.id("AddressVerification_TextBox")).sendKeys(selectID);
 }

 public void contactInfo(WebDriver driver, String phone, String branch) {
  driver.findElement(By.id("tbHomePhoneNumber_RadMaskedTextBox")).sendKeys(phone);
  driver.findElement(By.id("BranchDropDownList01_DropDownList")).sendKeys(branch);
  driver.findElement(By.id("NextButton_SubmitButton")).click();
  System.out.println("Completed the personal information in form");
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.id("NextButton_SubmitButton")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.id("btnNext_SubmitButton")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.id("btnNext_SubmitButton")).click();
 }

 public void fundingRequirements(WebDriver driver, String amount) {
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.id("ProductFunding59")).sendKeys(amount);
  driver.findElement(By.id("NextButton2_SubmitButton")).click();
 }

 
}