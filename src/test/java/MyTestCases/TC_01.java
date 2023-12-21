package MyTestCases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
	
import org.testng.annotations.Test;
import MyPageObjects.AmazonPage;
public class TC_01 extends BaseClass {
	@Test
	public void logintest() throws InterruptedException{
		Logger logger;
		logger=LogManager.getLogger(TC_01.class);
		driver.get(baseURL);
		AmazonPage ap=new AmazonPage(driver);
		logger.info("Page opened");
		ap.maximize();
		ap.searchMobile(searchKey);
		logger.info("Searched for mobile");
		ap.selectRating();
		logger.info("4 stars selected under customer review filter section");
		ap.selectPrice();
		logger.info("Price range between ₹10,000 - ₹20,000 selected");
		
	}
}

