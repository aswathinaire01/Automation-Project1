package testpackage;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pagepackage.AddtocartProductPage;

public class AddtocartProductTest extends BaseClass {
	
	@Test
	public void productAddtocart() throws InterruptedException {
		AddtocartProductPage ob=new AddtocartProductPage(driver);
		ob.clickFlite();
		ob.addToCart();
		ob.buyNow();
	}	
}
