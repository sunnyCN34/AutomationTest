import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG {

	public WebDriver driver;

  @Test
  public void main() {

	  driver.findElement(By.id("tbfiVISIONID")).sendKeys("I am Automated in TestNG framework");
	  driver.findElement(By.id("tbPassword")).sendKeys("wrongPassword");
	  driver.findElement(By.id("ctl00_cphMainContent_btnLogin")).click();
      System.out.println(" Login unsuccessful, now it is the time to close buddy.");
  }

  @BeforeMethod
  public void beforeMethod() {
      
      System.setProperty("webdriver.gecko.driver", "./geckodriver-v0.19.1-win64/geckodriver.exe");
      driver = new FirefoxDriver();
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("https://works-preprod.fivision.com/Login.aspx?ReturnUrl=%2fdefault.aspx");
  }

  @AfterMethod
  public void afterMethod() {

      driver.quit();
  }
}