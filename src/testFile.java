import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
public class testFile {
 
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/s_sahu/Downloads/geckodriver-v0.19.1-win64/geckodriver.exe");
		//C:\Users\s_sahu\Downloads\geckodriver-v0.19.1-win64
		
		
		
		WebDriver driver1 = new FirefoxDriver();
		
      
		driver1.get("http://www.dcu.org");
		
 
        
        System.out.println("This is a test. Successfully opened the website of DCU");
 
		
		Thread.sleep(1000);
		
        
        driver1.quit();
    }
}