package pagepackage;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/sticky-header/header/h1/a/div")
	WebElement logo;

    @FindBy(xpath = "/html/body/div[2]/sticky-header/header/div/a[1]")
    WebElement loginicon;
    
    @FindBy(xpath = "/html/body/main/div/div/div[2]/form/div[8]")
    WebElement loginemail;
       
    @FindBy(name = "customer[email]")
    WebElement emailid;
    
    @FindBy(name ="customer[password]")
    WebElement pass;
    
    @FindBy(xpath = "/html/body/main/div/div/div[2]/form/button")
    WebElement signinbtn;
    
    public void logoCheck()
	{
		boolean isLogoVisible=logo.isDisplayed();
		if(isLogoVisible)
		{
			System.out.println("Logo is present on the Home page");
		}
		else
		{
			System.out.println("Logo is not present on the Home page");
		}
	}

	public void titleCheck()
	{
		String exp="Buy Footwear Online for Men, Women & Kids in India | Relaxo – Relaxo Footwears Limited";
		String act=driver.getTitle();
		Assert.assertEquals(exp,act);		
		System.out.println("Page title matched");
	}
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	public void loginClick() throws InterruptedException
	{
		loginicon.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,300)");
    	Thread.sleep(3000);
    	loginemail.click();
	}
	public void setValues(String email, String password) {
    	emailid.sendKeys(email);
    	pass.sendKeys(password);
    	signinbtn.click();
    }

	public void screenShot() throws Exception
	{
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		FileHandler.copy(s,new File("./Screenshot/All_products.png"));	
		System.out.println("Screenshot saved");
		Thread.sleep(1000); 		
	}
}
