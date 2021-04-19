package test.automation.test.com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AirlineSearchDetails {
	

	public ChromeDriver driver= new ChromeDriver();; 

	LoginDashboardPage loginDashBoardPage = new LoginDashboardPage(driver) ;
	@BeforeClass
	public void loginToApp() { 
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		Reporter.log("=================================="+loginDashBoardPage.geHeader(), true);
		assertTrue(loginDashBoardPage.geHeader().contains("ixigo.com"), "Login page is not displayed");
	}
	
	
	@Test
	public void airlineSearchDetails() throws Exception {
		loginDashBoardPage.clickClearDepartureIcon().enterFromCity().clickFromDropDownOption()
		.enterToCity().clickToDropDownOption().clickDepartureField().selectDepartureDate().clickReturnField()
				.selectReturnDate().clickSearchButton().getPriceDetails();
	}
}
