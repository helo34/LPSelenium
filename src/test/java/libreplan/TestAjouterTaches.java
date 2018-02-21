package libreplan;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestAjouterTaches {
	
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
		driver.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testAjouterTaches() throws Exception{
		
		//PDT1 : Se connecter à l'application
		LoginPage page = new LoginPage(driver);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2 : Accéder à la liste des projets
		accueil.projectsList();
		MenuPage page2 = new MenuPage(driver);
		AccueilProjetPage2 accueilProjetPage2 = page2.accueilProjetPage2();
		
		//PDT3 : Accéder à la page d'édition du projet
		accueilProjetPage2.projetDetail();
		AccueilProjetPage2 page3 = new AccueilProjetPage2(driver);
		ProjetPage projetPage = page3.projetPage();
		
		//PDT4 : Vérification de l'affichage de la page d'édition du projet
		projetPage.verifierPage("PROJET_TEST1");
		
		//PDT5 : Création d'une nouvelle tâche
		projetPage.creationTache("Tache1-P1", "5");
		ProjetPage page4 = new ProjetPage(driver);
		TachePage tachePage = page4.tachePage();
		tachePage.verifierNewTache("Tache1-P1", "5");
		
		//PDT6 : Création de nouvelles tâches
		tachePage.creationTache("Tache2-P1", "10");
		Thread.sleep(1000);
		tachePage.creationTache("Tache3-P1", "20");
		Thread.sleep(1000);
		tachePage.creationTache("Tache4-P1", "8");
		TachePage page5 = new TachePage(driver);
		TachesPage tachesPage = page5.tachesPage();
		
		//PDT7-8 : Modifier l'ordre d'affichage des tâches
		tachesPage.modifierOrdre();
		TachesPage page6 = new TachesPage(driver);
		TachesPage2 tachesPage2 = page6.tachesPage2();
		tachesPage2.parcoursTableau("Tache1-P1");
		tachesPage2.parcoursTableau("Tache2-P1");
		tachesPage2.compare("Tache1-P1", "Tache2-P1");
		tachesPage2.modifierOrdre();
		TachesPage2 page7 = new TachesPage2(driver);
		TachesPage3 tachesPage3 = page7.tachesPage3();
		tachesPage3.parcoursTableau("Tache1-P1");
		tachesPage3.parcoursTableau("Tache2-P1");
		tachesPage3.compare("Tache1-P1", "Tache2-P1");
		
		//PDT9 : Renseigner les informations des tâches + enregistrement
		tachesPage3.infoTache("T1", "T2", "T3", "T4", 5, 8, 3, 5);
		
		//PDT10 : Visualisation de la planification du projet
		tachesPage3.barresApparentes();
	}

}
