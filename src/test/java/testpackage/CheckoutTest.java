package testpackage;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pagepackage.CheckoutPage;

public class CheckoutTest extends BaseClass {
	
	@Test
    public void completeCheckout() throws InterruptedException {
		CheckoutPage page = new CheckoutPage(driver);
        page.fillCheckoutDetails("Aswathi", "Nair", "123 Main Street", "Kasaragod", "Kerala", "671543", "9876543210");
        page.selectSameAsShipping();
        page.clickPayNow();
    }
}
