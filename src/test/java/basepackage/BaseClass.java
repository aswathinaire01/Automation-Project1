package basepackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get("https://relaxofootwear.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
