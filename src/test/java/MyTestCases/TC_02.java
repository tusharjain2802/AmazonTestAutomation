package MyTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import MyPageObjects.AmazonPage;

public class TC_02 extends TC_01{
	@Test
	public void reviewtest() throws InterruptedException {
	//WebDriver driver=new ChromeDriver();
	Logger logger;
	logger=LogManager.getLogger(TC_02.class);
	AmazonPage lp=new AmazonPage(driver);
	lp.selectPhone();
	logger.info("Phone Selected");
	lp.addToCart();
	logger.info("Phone Added to Cart");
	lp.goToCart();
	logger.info("Clicked on Cart Button");
	}
}
