package libreplan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAjouterTaches {
	
WebDriver wd;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		wd = new FirefoxDriver();
		wd.navigate().to("http://localhost:8080/libreplan");
	}
	
	@Test
	public void testAjouterTaches() throws Exception{
		
		//PDT1 : Se connecter � l'application
		LoginPage page = new LoginPage(wd);
		MenuPage accueil = page.connexion("admin", "admin");
		Thread.sleep(1000);
		
		//PDT2 : Acc�der � la liste des projets
		accueil.projectsList();
		MenuPage page2 = new MenuPage(wd);
		AccueilProjetPage2 accueilProjetPage2 = page2.accueilProjetPage2();
		
		//PDT3 : Acc�der � la page d'�dition du projet
		accueilProjetPage2.projetDetail();
		AccueilProjetPage2 page3 = new AccueilProjetPage2(wd);
		ProjetPage projetPage = page3.projetPage();
		
		//PDT4 : V�rification de l'affichage de la page d'�dition du projet
		projetPage.verifierPage("PROJET_TEST1");
		
		//PDT5 : Cr�ation d'une nouvelle t�che
		projetPage.creationTache("Tache1-P1", "5");
		ProjetPage page4 = new ProjetPage(wd);
		TachePage tachePage = page4.tachePage();
		tachePage.verifierNewTache("Tache1-P1", "5");
		
		//PDT6 : Cr�ation de nouvelles t�ches
		tachePage.creationTache("Tache2-P1", "10");
		Thread.sleep(1000);
		tachePage.creationTache("Tache3-P1", "20");
		Thread.sleep(1000);
		tachePage.creationTache("Tache4-P1", "8");
		TachePage page5 = new TachePage(wd);
		TachesPage tachesPage = page5.tachesPage();
		
		//PDT7-8 : Modifier l'ordre d'affichage des t�ches
		tachesPage.modifierOrdre();
		TachesPage page6 = new TachesPage(wd);
		TachesPage2 tachesPage2 = page6.tachesPage2();
		tachesPage2.parcoursTableau("Tache1-P1");
		tachesPage2.parcoursTableau("Tache2-P1");
		tachesPage2.compare("Tache1-P1", "Tache2-P1");
		tachesPage2.modifierOrdre();
		TachesPage2 page7 = new TachesPage2(wd);
		TachesPage3 tachesPage3 = page7.tachesPage3();
		tachesPage3.parcoursTableau("Tache1-P1");
		tachesPage3.parcoursTableau("Tache2-P1");
		tachesPage3.compare("Tache1-P1", "Tache2-P1");
		
		//PDT9 : Renseigner les informations des t�ches + enregistrement
		tachesPage3.infoTache("T1", "T2", "T3", "T4", 5, 8, 3, 5);
		
		//PDT10 : Visualisation de la planification du projet
		tachesPage3.barresApparentes();
	}

}
