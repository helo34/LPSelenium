package libreplan;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCreerProjet {
	
	String browser = System.getProperty("navigateur");
	WebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
	// RAJOUT HELO POUR TEST GRID //
		

	//DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setBrowserName(browser);
	//driver = new RemoteWebDriver(new URL("http://192.168.2.110:4444/wd/hub"), capabilities);
	
	// FIN RAJOUT HELO POUR TEST GRID //	
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Formation\\Downloads\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://192.168.2.87:8087/libreplan");
	}
	
	@Test
	public void testNouveauProjet() throws Exception{
		
		//PDT1 : Se connecter à l'application
		LoginPage page = new LoginPage(driver);
		MenuPage accueil = page.connexion("admin", "admin");
	/*	Thread.sleep(5000);
		
		//PDT2 : Accéder au formulaire de création d'un projet
		accueil.boutonCreerProjet();
		MenuPage page2 = new MenuPage(driver);
		CreerProjet projet = page2.nouveauProjet();
		projet.creerNouveauProjet("PROJET_TEST1", "PRJTEST001");
		
		//PDT3 : Créer un projet
		CreerProjet page3 = new CreerProjet(driver);
		ProjetCree projetCreer = page3.projetCree();
		
		//PDT4-5-6 : Vérifier les onglets
		projetCreer.verifierOnglets();
		projetCreer.verifierEditionProjetSave();
		projetCreer.verifierEditionProjetRetour();
		Thread.sleep(1000);
		
		//PDT7-8-9-10 : Utilisation des boutons d'annulation de l'édition du projet
		ProjetCree page4 = new ProjetCree(driver);
		RetourPage retourPage = page4.retourPage();
		retourPage.boutonRetour();
		ProjetCree page5 = new ProjetCree(driver);
		RetourPage2 retourPage2 = page5.retourPage2();
		retourPage2.boutonRetour2();
		Thread.sleep(1000);
		MenuPage page6 = new MenuPage(driver);
		AccueilProjetPage projetPage = page6.accueilProjetPage();
		
		//PDT11-12 : Vérifier la création du projet et de ses informations
		projetPage.verifierNomProjet();
		projetPage.verifierParamProjet("PROJET_TEST1", "PRJTEST001");*/
	}

}
