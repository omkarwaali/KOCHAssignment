package test.automation.test.com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class LoginWeb {
	
	private LoginDashboardPage loginDashBoadPage;
	
	 public LoginWeb(final LoginDashboardPage loginDashBoadPage) {
		this.loginDashBoadPage = loginDashBoadPage;
	}
	
	@BeforeClass
	public void loginToApp() {
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.ixigo.com/");
		assertTrue(loginDashBoadPage.geHeader().contains("ixigo.com"), "Login page is not displayed");
//		driver.quit();
	}

}
