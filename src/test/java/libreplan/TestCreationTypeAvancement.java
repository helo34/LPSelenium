package libreplan;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.PageFactory;

import libreplanException.TestException;

public class TestCreationTypeAvancement {


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
	driver.get("http://localhost:8080/libreplan");

	}
	
	@Test
	public void creationTypeAvancement() throws TestException {
		LoginPage page = new LoginPage(driver);
		//PDT-1
		//Connexion
		MenuPage page1 = page.connexion("admin","admin");
		
		//PDT-2
		//Accès à la liste des types d'avancemant 
		ProgressTypePage page2 = page1.resourcesToProgressType();
		// Vérification des colonnes que composent le tableau de type d'avancement
		page2.verifTableauProgressTypeList();
		
		//PDT-3
		//Accès au formulaire de création d'un type d'avancement
		CreationProgressTypePage page3 = page2.accesFormulaireProgressType();
		//Entreprend toutes les vérifications liés aux éléments de la page (Tableau, noms des champs, praticabilité des champs)
		page3.verifsPage();
		
		//PDT-4
		//Remplit les champs selon JDD
		page3.remplirChampUnitName("Type avancement - Test 1");
		page3.remplirChampUnitName(10.00);
		//Sauvegarde du type d'avancement et retour à la liste de types d'avancement
		page3.sauvegarderType();
		
		//PDT-5
		////Accès au formulaire de création d'un type d'avancement
		page2.accesFormulaireProgressType();
		
		//PDT-6
		//Remplit les champs et coche cases selon JDD
		page3.remplirChampUnitName("Type avancement - Test 2");
		page3.cocherCheckboxPourcentage();
		//Temporisation
		try 
		{
			Thread.sleep(200);
			} 
		catch (InterruptedException e){e.printStackTrace();
			} 
		//Vérifie que le champ "Valeur maximum par défault" est grisé et non-modifiable après avoir coché la case "poucentage"
		page3.verifChampValMax();
		
		//PDT-7
		//Sauvegarde le type d'avancement en restant sur la page
		MessageCreationProgressTypePage	page4 = page3.sauvegarderEtContinuerType();
		//Vérifie que le message de confirmation apparait après création d'un nouveau type d'avancement
		page4.verifMessageCreationProgressType();
		
		//PDT-8
		//Retour à la liste des types d'avancement par le bouton "annuler"
		ProgressTypePage page5 = page4.annulerCreation();
		
		//PDT-9
		//Vérifie l'existence, dans le tableau, du type nouvellement créer
		page5.verifTableauProgressTypeList2();
		//Vérifie la bonne activation des checkboxes et l'existance des icones "Modifier" et "Editer"
		page5.verifTableauApresCreation();
		
	}
}
