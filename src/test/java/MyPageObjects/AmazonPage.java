package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	WebDriver ldriver;
	public AmazonPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Review Us!")
	WebElement ReviewMenuButton;
	
	@FindBy(name="field-keywords")
	WebElement searchBar;

	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"p_72/1318476031\"]/span/a/section/i")
	WebElement rating;
	
	@FindBy(xpath="//*[@id=\"p_36/1318506031\"]/span/a/span")
	WebElement priceRange;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement phone;
	
	@FindBy(xpath="/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[36]/div[1]/span/span/span/input")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[@id=\"attachSiNoCoverage\"]/span/input")
	WebElement skip;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[1]/div[3]/div/a[4]")
	WebElement cart;
	
	public void maximize() {
		String title = ldriver.getTitle();
		System.out.println("Title: "+ title);
		String url = ldriver.getCurrentUrl();
		System.out.println("URL: "+url);
		
		if (title.contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
            System.out.println("The page is verified");
        } else {
            System.out.println("The page isn't verified");
        }
		ldriver.manage().window().maximize();
		ldriver.manage().deleteAllCookies();
	}
	public void searchMobile(String uname) {
		searchBar.sendKeys(uname);
		searchButton.click();
	}
	
	public void selectRating() throws InterruptedException {
		rating.click();
		Thread.sleep(2000);
	}
	public void selectPrice() throws InterruptedException {
		priceRange.click();
		Thread.sleep(2000);
	}
	public void selectPhone() throws InterruptedException {
		phone.click();
		Thread.sleep(2000);
	}
	public void addToCart() throws InterruptedException {
		String childwindow=ldriver.getWindowHandles().toArray()[1].toString();
	    System.out.println("The child window handle: "+childwindow);
	    ldriver.switchTo().window(childwindow);
		addToCartButton.click();
		Thread.sleep(1000);
		skip.click();
		Thread.sleep(1000);
	}
	public void goToCart() throws InterruptedException {
		cart.click();
		Thread.sleep(4000);
	}
}