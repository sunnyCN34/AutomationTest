import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class testFile {
 
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./geckodriver-v0.19.1-win64/geckodriver.exe");
		
		WebDriver driver1 = new FirefoxDriver();
		
		
		driver1.get("https://works-preprod.fivision.com/Login.aspx?ReturnUrl=%2fdefault.aspx");
		Thread.sleep(5);
		driver1.findElement(By.id("tbfiVISIONID")).sendKeys("I am Automated");
		Thread.sleep(500);
		driver1.findElement(By.id("tbPassword")).sendKeys("wrongPassword");
		Thread.sleep(500);
		driver1.findElement(By.id("ctl00_cphMainContent_btnLogin")).click();   
		
		
        System.out.println("This is a test. Its a failed login try");
 
		
		Thread.sleep(1000);
		
        
        driver1.quit();
    }
}