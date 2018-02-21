package libreplan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestImp {
	
WebDriver wd;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		wd = new FirefoxDriver();
		wd.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testAjouterTaches() throws Exception{
		
		//PDT1 : Se connecter à l'application
		LoginPage page = new LoginPage(wd);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2-3 : Paramètres d'impression et annulation
		accueil.impression();
		MenuPage page2 = new MenuPage(wd);
		ImpPage impPage = page2.impPage();
		impPage.verifierImp();
		Thread.sleep(1000);
		
		//PDT4-5 : Paramètres d'impression décochés
		accueil.impression();
		MenuPage page3 = new MenuPage(wd);
		ImpPage2 impPage2 = page3.impPage2();
		impPage2.impParam();
		
		//Test en échec pour la suite des PDT.
	}
}
