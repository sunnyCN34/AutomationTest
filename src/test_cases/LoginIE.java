package test_cases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class LoginIE {

 public WebDriver driver;

 @Test(dataProvider = "authenticationData")
 public void Login_using_IE(String sUserName, String sPassword) throws Exception {

  driver.findElement(By.id("tbfiVISIONID")).sendKeys(sUserName);
  driver.findElement(By.id("tbPassword")).sendKeys(sPassword);
  driver.findElement(By.id("ctl00_cphMainContent_btnLogin")).click();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  WebElement result = driver.findElement(By.id("ctl00_lblUserName"));
  Assert.assertTrue(result.isDisplayed());
  System.out.println(" Login successful ");
 }

 @BeforeMethod
 public void beforeMethod() throws Exception {

  System.setProperty("webdriver.ie.driver", "./IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
  driver = new InternetExplorerDriver();
  

  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


  driver.get("https://works-preprod.fivision.com/Login.aspx?ReturnUrl=%2fdefault.aspx");
 }

 @AfterMethod
 public void afterMethod() throws InterruptedException {

  Thread.sleep(1000);

  driver.quit();
 }

 @DataProvider(name = "authenticationData")

 public static Object[][] sampleData() {

  return new Object[][] {
   {
    "sample@dcu.org",
    "Sample2018"
   }
  };
 }
}
