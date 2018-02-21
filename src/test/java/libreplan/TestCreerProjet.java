package libreplan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreerProjet {
	
	WebDriver wd;

	@Before
	public void setup(){
		System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		wd = new FirefoxDriver();
		wd.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testNouveauProjet() throws Exception{
		
		//PDT1 : Se connecter à l'application
		LoginPage page = new LoginPage(wd);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2 : Accéder au formulaire de création d'un projet
		accueil.boutonCreerProjet();
		MenuPage page2 = new MenuPage(wd);
		CreerProjet projet = page2.nouveauProjet();
		projet.creerNouveauProjet("PROJET_TEST1", "PRJTEST001");
		
		//PDT3 : Créer un projet
		CreerProjet page3 = new CreerProjet(wd);
		ProjetCree projetCreer = page3.projetCree();
		
		//PDT4-5-6 : Vérifier les onglets
		projetCreer.verifierOnglets();
		projetCreer.verifierEditionProjetSave();
		projetCreer.verifierEditionProjetRetour();
		Thread.sleep(1000);
		
		//PDT7-8-9-10 : Utilisation des boutons d'annulation de l'édition du projet
		ProjetCree page4 = new ProjetCree(wd);
		RetourPage retourPage = page4.retourPage();
		retourPage.boutonRetour();
		ProjetCree page5 = new ProjetCree(wd);
		RetourPage2 retourPage2 = page5.retourPage2();
		retourPage2.boutonRetour2();
		Thread.sleep(1000);
		MenuPage page6 = new MenuPage(wd);
		AccueilProjetPage projetPage = page6.accueilProjetPage();
		
		//PDT11-12 : Vérifier la création du projet et de ses informations
		projetPage.verifierNomProjet();
		projetPage.verifierParamProjet("PROJET_TEST1", "PRJTEST001");
	}

}
