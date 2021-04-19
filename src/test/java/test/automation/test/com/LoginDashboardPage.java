package test.automation.test.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginDashboardPage {
	
	private WebDriver driver;

	public LoginDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".orgn.u-ib.u-text-left.u-v-align-bottom > .c-auto-cmpltr > .c-input-cntr > .c-input.u-v-align-middle")
	WebElement fromAddress;
	
	@FindBy(css = ".dstn.u-ib.u-text-left.u-v-align-bottom > .c-auto-cmpltr > .c-input-cntr > .c-input.u-v-align-middle")
	WebElement toAddress;
	
	@FindBy(css = ".from-date.u-ib > .c-input-cntr > .c-input.u-v-align-middle")
	WebElement departureField;
	
	@FindBy(css = "div:nth-of-type(1) > .rd-days > .rd-days-body > tr:nth-of-type(5) > td:nth-of-type(5) > .day.has-info")
	WebElement departureDate;
	
	@FindBy(css = ".to-date.u-ib.u-pos-rel > .c-input-cntr > .c-input.u-v-align-middle")
	WebElement returnField;
	
	@FindBy(css = ".flight-ret-cal [data-date='11052021'] .has-info")
	WebElement returnDate;
	
	@FindBy(css = ".flight-form.max-container-width .u-ripple")
	WebElement serachButton;
	
	@FindBy(xpath = "//div[@class='orgn u-ib u-v-align-bottom u-text-left']/descendant::div/descendant::div[@class='clear-input ixi-icon-cross']")
	WebElement clearDepartureIcon;
	
	@FindBy(xpath = "//div[@data-acindex='1']")
	WebElement fromDropDownOption;
	
	@FindBy(xpath = "//div[@data-acindex='0']")
	List<WebElement> toDropDownOption;
	
	@FindBy(xpath = "//div[@class='c-flight-listing-split-row  hide-detail']/descendant::div/descendant::div[@class='price-group']/descendant::span/following-sibling::span")
	List<WebElement> priceOptions;
	
	@FindBy(xpath = "//div[@class='price-group']/preceding-sibling::div[@class='time-group']")
	List<WebElement> airlineDetails;
	
	public String geHeader(){
        return driver.findElement(By.id("ixiLogoImg")).getAttribute("title");
    }
	
//	public List<WebElement> getPrices(){
//		return driver.findElements(By.xpath("//div[@class='c-flight-listing-split-row  hide-detail']/descendant::div/descendant::div[@class='price-group']/descendant::span/following-sibling::span"));		
//	}//div[@class='price-group']/preceding-sibling::div[@class='time-group']/descendant::div[@class='airline-text']
	
	public LoginDashboardPage enterFromCity() throws Exception {
		fromAddress.clear();
		Thread.sleep(1000);
		fromAddress.sendKeys("Mumbai");
		return this;
	}
	
	public LoginDashboardPage enterToCity() {
		toAddress.sendKeys("Delhi");
		return this;
	}
	
	public LoginDashboardPage clickDepartureField() {
		departureField.click();
		return this;
	}
	
	public LoginDashboardPage selectDepartureDate() throws Exception {
		Thread.sleep(3000);
		departureDate.click();
		return this;
	}
	
	public LoginDashboardPage clickReturnField() {
		returnField.click();
		return this;
	}
	
	public LoginDashboardPage selectReturnDate() throws Exception {
		Thread.sleep(3000);
		returnDate.click();
		return this;
	}
	
	public LoginDashboardPage clickSearchButton() {
		serachButton.click();
		return this;
	}
	
	public LoginDashboardPage clickClearDepartureIcon() throws Exception {
		Thread.sleep(3000);
		if(clearDepartureIcon.isEnabled()) {
			clearDepartureIcon.click();			
		}
		return this;
	}
	
	public LoginDashboardPage clickFromDropDownOption() throws Exception {
		Thread.sleep(5000);
		toDropDownOption.get(0).click();
		return this;
	}
	
	public LoginDashboardPage clickToDropDownOption() throws Exception {
		Thread.sleep(2000);
		toDropDownOption.get(1).click();
		return this;
	}
	
	public LoginDashboardPage getPriceDetails() throws Exception {
		Thread.sleep(60000);
		int noOfFlightsAvailale = priceOptions.size();
		Reporter.log("=================================="+noOfFlightsAvailale, true);
		for(int i = 0; i<noOfFlightsAvailale;i++) {
			String value = priceOptions.get(i).getText();
			int price = Integer.parseInt(value);
			Reporter.log("=================================="+price, true);
			if(price<7000) {
				String airLineDetails = airlineDetails.get(i).getText();
				Reporter.log("=================================="+airLineDetails, true);
			}
			 
		}
		return this;
	}


}
