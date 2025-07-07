package pagepackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocartProductPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/main/div/div/div/div[2]/div[2]/div/div[2]")
	WebElement fliteClick;
	
	@FindBy(xpath = "/html/body/main/div/div/div/div[2]/div[3]/ul/li[1]/div/div/div[2]/div[1]/div[2]/button/a")
	WebElement addtocartbtn;
	
	@FindBy(xpath="/html/body/main/section[2]/section/div/div[1]/div[2]/product-info/div[9]/product-form/form/div/div/shopify-accelerated-checkout/shopify-buy-it-now-button/button")
	WebElement buynowbtn;
	
	public AddtocartProductPage(WebDriver driver) 
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	public void clickFlite() throws InterruptedException {
		fliteClick.click();	
		Thread.sleep(3000);
	}
	public void addToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	Thread.sleep(3000);
		addtocartbtn.click();
	}
	public void buyNow() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	Thread.sleep(3000);
		buynowbtn.click();
	}
}
