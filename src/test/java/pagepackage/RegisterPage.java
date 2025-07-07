package pagepackage;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	WebDriver driver;
	WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[2]/sticky-header/header/div/a[1]")
    WebElement loginicon;
    
    @FindBy(xpath = "/html/body/main/div/div/div[2]/form/div[8]")
    WebElement loginreg;
    
    @FindBy(xpath = "/html/body/main/div/div/div[2]/form/a[2]")
    WebElement createaccount;

    @FindBy(name = "customer[first_name]")
    WebElement firstname;

    @FindBy(name = "customer[last_name]")
    WebElement lastname;

    @FindBy(name = "customer[email]")
    WebElement email;

    @FindBy(name = "customer[password]")
    WebElement password;

    @FindBy(name = "age_consent")
    WebElement termscheckbox;

    @FindBy(id = "accept")
    WebElement acceptradio;

    @FindBy(xpath = "/html/body/main/div/div/form/button")
    WebElement createbutton;

    public RegisterPage(WebDriver driver) 
	 { 
	  this.driver=driver; 
	  PageFactory.initElements(driver, this); 	
	  wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 }
    
    public void logIn() throws InterruptedException
	{   
    	loginicon.click();    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,300)");
    	Thread.sleep(3000);
    	loginreg.click();
	}
    
    public void openCreateAccountForm() {       
        createaccount.click();
    }

    public void setValues(String fName, String lName, String mail, String pass) throws InterruptedException{
        firstname.sendKeys(fName);
        lastname.sendKeys(lName);
        email.sendKeys(mail);
        password.sendKeys(pass);
        termscheckbox.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,3000)");   	
        acceptradio.click(); 
        Thread.sleep(3000);
    }
    
    public void clickCreate() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", createbutton);
    	Thread.sleep(3000);
        createbutton.click();        
    }
}
