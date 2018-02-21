package libreplan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import libreplanException.TestException;

public class TestCreationParticipantNouvelUtilisateur {

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
	public void creationParticipantNouvelUtilisateur() throws TestException{
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		
		//PDT-1 Connexion
		MenuPage page1 = page.connexion("admin","admin");
		
		//PDT-2 Acc�s � la page de gestion des participants
		WorkerPage page2 = page1.resourcesToWorker();
		try 
		{
			Thread.sleep(400);
			} 
		catch (InterruptedException e){e.printStackTrace();
			} 
		//V�rifie l'existence d'un tableau avec les colonnes "Surname", "First name", "ID", "Code", "Queue-based", "Operations"
		int resultat = page2.parcourHeaderTableauWorker("Surname", "First name", "ID", "Code", "Queue-based", "Operations");
		assertNotEquals(resultat, -1);
		//V�rifie l'existence d'un champs de saisie "Filtrer par" et de son icone "Loupe"
		assertEquals(page2.champFiltrerPar.getTagName(), "input");
		assertEquals(page2.iconeLoupe.getTagName(), "i");
		//V�rifie l'existence d'un champs d�tails personnels
		assertEquals(page2.champDetailPerso.getTagName(), "input");
		//V�rifie que les boutons "plus d'options" et "filtrer" est clickable
		assertTrue(page2.boutonPlusOptions.isEnabled());
		assertTrue(page2.boutonFiltrer.isEnabled());
		
		//PDT-3 acc�s � la page de cr�ation des participants
		PersonalDataWorkerPage page3 = page2.cliquerBoutonCr�er();
		
		//PDT-4 V�rification des �l�ments de la page de cr�ation d'un participant
		assertEquals("Basic data", page3.titreSectionData.getText());
		assertEquals("Type", page3.caseType.getText());
		assertEquals("ID", page3.caseId.getText());
		assertEquals("Last name", page3.caseLastName.getText());
		assertEquals("First name", page3.caseFirstName.getText());
		assertEquals("Code", page3.caseCode.getText());
		assertEquals(true, page3.checkboxOptions1.get(0).isSelected());
		assertEquals(false, page3.checkboxOptions1.get(1).isSelected());
		assertEquals(false, page3.checkboxOptions1.get(2).isSelected());
		
		
		//PDT-5 Cr�er et enregistrer un participant
			//V�rifie que le champ "case" n'est pas modifiable
		if(page3.champCase.isEnabled()){	
			throw new TestException();
			}
			//Cr�ation du participant "Jean DU", conform�ment au JDD
		page3.remplirDataWorker("Jean", "DU", "Jdu");
		assertEquals("Normal resource", page3.typeParDefaut.getText());
			//Acc�s � la cr�ation d'un utilisateur "jdu" selon JDD
		CreateNewUserPage page4 = page3.cliquerBoutonCr�er();
		page4.remplirDataUser("jdu", "$jdumdp1", "jdu@test.fr" );
			//Enregistrement du participant/utilisateur
		WorkerPage page5 = page4.enregistrerNewWorker();
		try 
		{
			Thread.sleep(400);
			} 
		catch (InterruptedException e){e.printStackTrace();
			} 
			//V�rif existence du nouveau participant
		int resultat2 = page5.parcourTableauWorker2("DU", "Jean", "Jdu");
		assertNotEquals(resultat2, -1);
			//V�rif message de confirmation de la sauvegarde
		assertEquals("Worker saved", page5.MessageApresCreation());
		
		//PDT-6 Utilisation du filtre "D�tail Perso".
			//Filtrer par prenom "Jean"
		WorkerPage page6 = page5.remplirDetailPerso("Jean");
			//v�rif affichage de Jean DU dans tableau et disparition des participants dont le prenom n'est pas "Jean"
	
		int resultat3 = page6.parcourTableauWorker2("DU", "Jean", "Jdu");
		assertNotEquals(resultat3, -1);

		//PDT-7 Filtre "Plus d'Option"
			//Clique sur "plus d'options"
		OptionFiltreWorkerPage page7 = page6.cliquerPlusOptions();
			//V�rifie que l'appartion de deux champs "P�riode active", sans valeur par d�faut
		assertEquals("", page7.champPeriodeActiveFrom.getText());
		assertEquals("", page7.champPeriodeActiveTo.getText());
			//Verifie le menu d�roulant "Type"
		page7.listMenuDeroulantType();
		
		//PDT-8 Navigation Page de participants 1/4
			//Clique bouton ">"
		OptionFiltreWorkerPage page8 = page7.cliquerNext();

			//V�rifie l'acc�s � la page 2 du tableau
		assertEquals("2", page8.champPageTableau.getAttribute("value"));
		
		//PDT-9 Navigation Page de participants 2/4
			//Clique bouton "<"
		OptionFiltreWorkerPage page9 = page8.cliquerPrev();
			//V�rifie l'acc�s � la page 1 du tableau
		assertEquals("1", page9.champPageTableau.getAttribute("value"));
		
		//PDT-10 Navigation Page de participants 3/4
			//Clique bouton ">|"
		OptionFiltreWorkerPage page10 = page9.cliquerLast();
			//V�rifie que la page affich�e est la derni�re
		assertEquals("2", page10.champPageTableau.getAttribute("value"));		
		
		//PDT-11 Navigation Page de participants 3/4
			//Clique bouton ">|"
		OptionFiltreWorkerPage page11 = page10.cliquerFirst();
			//V�rifie que la page affich�e est la premi�re
		assertEquals("1", page11.champPageTableau.getAttribute("value"));
		
		//PDT-12 Connexion � l'application -nouvel utilisateur
			//Deconnexion
		page10.seDeconnecter();
		TableauDeBordPage page12 = page.connexionUser("jdu", "$jdumdp1");
		assertEquals("My dashboard", page12.titrePageDashboard.getText());
}

}
