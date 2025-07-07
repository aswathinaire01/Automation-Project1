package pagepackage;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(name = "firstName")
    WebElement firstname;

    @FindBy(name = "lastName")
    WebElement lastname;

    @FindBy(name = "address1")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "zone")
    WebElement statedropdown;

    @FindBy(name = "postalCode")
    WebElement pincode;

    @FindBy(name = "phone")
    WebElement phonenum;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div/main/div/form/div[1]/section/div[1]/div/div/div/section/div/div/div[3]/div/div[1]/div/div[1]/input")
    WebElement sameshipping;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div/div[1]/div/main/div/form/div[1]/section/div[2]/div/div/div/div[1]/div[2]/div/div/div/button")
    WebElement paynowbtn;   
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public void fillCheckoutDetails( String fName, String lName,String addr, String cityName, String state, String pin, String mobile) 
    {
    	wait.until(ExpectedConditions.visibilityOf(firstname)).clear();
        firstname.sendKeys(fName);
        
        lastname.clear();
        lastname.sendKeys(lName);      

        address.clear();
        address.sendKeys(addr);

        city.clear();
        city.sendKeys(cityName);

        Select stateSelect = new Select(statedropdown);
        stateSelect.selectByVisibleText(state);

        pincode.clear();
        pincode.sendKeys(pin);
        
        phonenum.clear();
        phonenum.sendKeys(mobile);
    }

    public void selectSameAsShipping() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sameshipping);
    	Thread.sleep(3000);
    	sameshipping.click();
        }

    public void clickPayNow() {
    	paynowbtn.click();
    }
}
