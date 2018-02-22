package libreplan;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestAffichagePlanning {
	
	String browser = System.getProperty("navigateur");
	WebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
	// RAJOUT HELO POUR TEST GRID //
		

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName(browser);
	driver = new RemoteWebDriver(new URL("http://192.168.2.110:4444/wd/hub"), capabilities);
	
	// FIN RAJOUT HELO POUR TEST GRID //	
		
	//driver = new FirefoxDriver();
		driver.navigate().to("http://192.168.2.87:8087/libreplan");
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
		Thread.sleep(1000);
		accueilProjetPage2.affichageOngletProjet();
		AccueilProjetPage2 page3 = new AccueilProjetPage2(driver);
		
		//PDT4 : Accéder à la page de plannification du projet
		PlanningPage planningPage = page3.planningPage();
		
		//PDT5-6-7 : Zoom année - trimestre - mois
		planningPage.verifierPlanningPage();
		planningPage.parcoursTableauAnnee("H1");
		planningPage.parcoursTableauAnnee("H2");
		planningPage.verifierPlanningPageQuarter();
		planningPage.parcoursTableauQuarter("Q1");
		planningPage.parcoursTableauQuarter("Q2");
		planningPage.parcoursTableauQuarter("Q3");
		planningPage.parcoursTableauQuarter("Q4");
		planningPage.verifierPlanningPageMonth();
		planningPage.parcoursTableauMonthYear("2017,H1");
		planningPage.parcoursTableauMonthYear("2017,H2");
		planningPage.parcoursTableauMonth("Jan");
		planningPage.parcoursTableauMonth("Feb");
		planningPage.parcoursTableauMonth("Mar");
		planningPage.parcoursTableauMonth("Apr");
		planningPage.parcoursTableauMonth("May");
		planningPage.parcoursTableauMonth("Jun");
		planningPage.parcoursTableauMonth("Jul");
		planningPage.parcoursTableauMonth("Aug");
		planningPage.parcoursTableauMonth("Sep");
		planningPage.parcoursTableauMonth("Oct");
		planningPage.parcoursTableauMonth("Nov");
		planningPage.parcoursTableauMonth("Dec");
	}
}
