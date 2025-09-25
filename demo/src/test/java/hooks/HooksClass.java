package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {
    public static WebDriver driver;
   public static WebElement element;

   @Before
   public void openBrowser(){
	try{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
   }

   @After
    public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
}
