package libreplan;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestImp {
	
	String browser = System.getProperty("navigateur");
	WebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
	// RAJOUT HELO POUR TEST GRID //
		

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName(browser);
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	
	// FIN RAJOUT HELO POUR TEST GRID //	
		
	//driver = new FirefoxDriver();
		//System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		//wd = new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testAjouterTaches() throws Exception{
		
		//PDT1 : Se connecter à l'application
		LoginPage page = new LoginPage(driver);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2-3 : Paramètres d'impression et annulation
		accueil.impression();
		MenuPage page2 = new MenuPage(driver);
		ImpPage impPage = page2.impPage();
		impPage.verifierImp();
		Thread.sleep(1000);
		
		//PDT4-5 : Paramètres d'impression décochés
		accueil.impression();
		MenuPage page3 = new MenuPage(driver);
		ImpPage2 impPage2 = page3.impPage2();
		impPage2.impParam();
		
		//Test en échec pour la suite des PDT.
	}
}
