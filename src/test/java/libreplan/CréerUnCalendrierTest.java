package libreplan;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cr�erUnCalendrierTest {

	WebDriver driver;

		
		@Before
		public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/libreplan");
		}
		
		@Test
		public void creationCalendrierTest(){
			
		//PDT 1
		LoginPage page = new LoginPage(driver);
		MenuPage page1 = page.connexion("admin", "admin");
		page1.logo.isDisplayed();
		System.out.println("PDT1 OK");
	
		
//PDT 2 - Acc�der � la page d'administration des calendriers > Menu : Ressources puis clic sur Calendriers 
		CalendarsListPage page2 = page1.resourcesToCalendars();
				
		//V�rifier l'affichage de la page "Liste de calendriers"
		page2.titreCalendarList.isDisplayed();
		
		//V�rifier que la page contient : un tableau avec les colonnes (Nom, H�rit� de la date, H�ritages � jour,	Op�rations), btn [Cr�er]
		System.out.print(page2.enTeteTableauCalendar.getText());
		Assert.assertTrue(page2.enTeteTableauCalendar.getText().contains("Name"));
		System.out.println("PDT2 OK");
		
//PDT 3- Cr�er un calendrier - Cliquer sur le bouton [Cr�er]
		CreateCalendarPage page3 = page2.clicBoutonCreateCalendars();
		 
		 //V�rifier l'affichage de la page "Cr�er calendrier" 
		page3.titreCreateCalendar.isDisplayed();
		
		 //V�rifier que la page contient : un formulaire de saisie des caract�ristiques du calendrier (onglet "Donn�es de calendrier")
		// - les boutons [Enregistrer], [Enregistrer et continuer] et [Annuler]
		page3.ongletDonneesCalendrier.isDisplayed();
		System.out.println("PDT3 OK");
		
//PDT 4 - Cr�er un calendrier - Renseigner l'ensemble des champs du formulaire de saisie (Nom : "Calendrier - Test 1", Code : laisser la case "G�n�rer le code" coch�e)
		page3.champNomCalendar.sendKeys("Calendrier - Test 1");
		page3.caseGenerateCode.isSelected();
				
		// Cliquer sur le bouton [Enregistrer] : Retour sur la page "Liste de calendriers"
		CalendarsListPage page4 = page3.clicBoutonSaveCalendars();
		 
		// Verif : Dans le tableau, le calendrier "Calendrier - Test 1" est pr�sent.
		Assert.assertTrue(page4.contenuTableauCalendar.getText().contains("Calendrier - Test 1"));
		System.out.println("PDT4 OK");
		
//PDT 5 - Cr�er un calendrier d�riv� : Cliquer sur l'ic�ne "Cr�er une d�rive" (colonne "Op�ration" pour calendrier "Calendrier - Test 1")
		CreateCalendarPage page5 = page4.clicIconeCreateDerived("Calendrier - Test 1");
		 
		// Verif sur la page "Cr�er Calendrier" que : "Nom" = champ vide ; "Type" = "D�riv� du calendrier calendrier 1"
		Assert.assertTrue(page5.champNomCalendar.getText().isEmpty());
		Assert.assertTrue(page5.typeCalendar.getText().contains("Derived of calendar Calendrier - Test 1")); 
		System.out.println("PDT5 OK");
		
//PDT 6 - Cr�er un calendrier d�riv� - nom non conforme : Renseigner l'ensemble des champs du formulaire de saisie :
// Nom : saisir "Calendrier - Test 1" (m�me nom que celui du calendrier source); Code :  laisser la case "G�n�rer le code" coch�e
		page5.champNomCalendar.sendKeys("Calendrier - Test 1");
		page5.caseGenerateCode.isSelected();
		
		// Cliquer sur le bouton [Enregistrer et continuer] - Affichage du message suivant : "Calendrier - Test 1 existe d�j�"
		MessageRetourErreurCalendar page6 = page5.clicErreurSaveAndContinueCalendar();
		page6.afficherMessageErreurEnregistrement();
		System.out.println("PDT6 OK");
		
//PDT 7 - Cr�er un calendrier d�riv� - bouton [Enregistrer et continuer] - Renseigner l'ensemble des champs du formulaire de saisie :
// Nom : Calendrier - Test Calendrier D�riv� - Code :  laisser la case "G�n�rer le code" coch�e
		page6.champNomCalendar.clear();
		page6.champNomCalendar.sendKeys("Calendrier - Test Calendrier D�riv�");
		page6.caseGenerateCode.isSelected();
		 
		// Cliquer sur le bouton [Enregistrer et continuer]- Affichage du message "Calendrier de base "Calendrier - Test Calendrier D�riv�" enregistr�".
		page6.clicBoutonSaveAndContinueCalendars();
		
		 
		//Le titre de la page est : "Cr�er Calendrier: Calendrier - Test Calendrier D�riv�"
		Assert.assertTrue(page6.titreCreateCalendar.getText().contains("Create Calendar: Calendrier - Test Calendrier D�riv�"));
		System.out.println("PDT7 OK");
		
//PDT 8 - Retour page de gestion des calendriers - Cliquer sur le bouton [Annuler]- Affichage de la page "Liste de calendriers".
		CalendarsListPage page7 = page6.clicBoutonCancelCalendar();
		 
		// Dans le tableau, le calendrier "Calendrier - Test Calendrier D�riv�" est affich� en tant que sous-calendrier du calendrier "Calendrier - Test 1".
		Assert.assertTrue(page7.contenuTableauCalendar.getText().contains("Calendrier - Test Calendrier D�riv�"));
		WebElement lienDependance = driver.findElement(By.xpath("//span[@class='z-dottree-line z-dottree-last']"));
		lienDependance.isDisplayed();
		 
		System.out.println("PDT8 OK");
//PDT 9 - Affichage du calendrier d�riv� - Cliquer sur le bouton [-] associ� au calendrier "Calendrier - Test 1"
		page7.clicIconeAfficherDerives();
		 
		// L'arborescence du calendrier "Calendrier - Test 1 " se referme
		Assert.assertFalse(page7.afficherDerivesCalendar());
		 
		// Le calendrier "Calendrier - Test Calendrier D�riv�" n'est plus affich�.
		Assert.assertFalse(page7.contenuTableauCalendar.getText().contains("Calendrier - Test Calendrier D�riv�"));
		System.out.println("PDT9 OK");
		 
//PDT 10 - Cr�er un calendrier par copie : Cliquer sur ic�ne "Cr�er une copie" (colonne "Op�ration) pour le calendrier "Calendrier - Test 1".
		CreateCalendarPage page8 = page7.clicIconeCreateCopie("Calendrier - Test 1");		
		 
		// Page "Cr�er Calendrier : Calendrier - Test 1" s'affiche et contient :("Nom" = "Calendrier - Test 1";"Type" = "Calendrier source")
		//System.out.println(page8.afficherContenuDuChampNom()+": contenu du champ 'Nom'");
		//Assert.assertEquals(page8.afficherContenuDuChampNom(), "Calendrier - Test 1"); 
		System.out.println("PDT10 OK");
		
//PDT 11 - Cr�er un calendrier par copie - Nom du calendrier non conforme : Ne pas modifier le nom du calendrier puis cliquer sur le bouton [Enregistrer et continuer].
		page8.clicBoutonSaveAndContinueCalendars();
		MessageRetourErreurCalendar page9 = new MessageRetourErreurCalendar(driver);
		 
		//Affichage du message suivant : "Calendrier - Test 1 existe d�j�"
		page9 = page8.clicErreurSaveAndContinueCalendar();
		page9.afficherMessageErreurEnregistrement();
		System.out.println("PDT11 OK");
		
//PDT 12 - Cr�er un calendrier par copie - [Enregistrer] : Renseigner l'ensemble des champs du formulaire de saisie :
// Nom : Calendrier - Test 2 ;  Code :  laisser la case "G�n�rer le code" coch�e
		page9.champNomCalendar.sendKeys("Calendrier - Test 2");
		page9.caseGenerateCode.isEnabled();
		
		 
		// Cliquer sur le bouton [Enregistrer] - Retour sur la page "Liste de calendriers".
		CalendarsListPage page10 = page9.clicBoutonSaveCalendars();		
		 
		// Le message suivant est affich� : "Calendrier de base "Calendrier - Test 2" enregistr�"
		boolean messageConfirmation = driver.findElement(By.className("message_INFO")).isDisplayed();
		
		// Dans le tableau, calendrier "Calendrier - Test 2"  pr�sent et n'est pas affich� en tant que sous-calendrier du calendrier "Calendrier - Test 1"
		Assert.assertTrue(page10.contenuTableauCalendar.getText().contains("Calendrier - Test 2"));
		driver.findElement(By.xpath("//span[@class='z-dottree-ico z-dottree-root-open']")).click();
		Assert.assertTrue(page10.contenuTableauCalendar.getText().contains("Calendrier - Test 2"));
		System.out.println("PDT12 OK");
		
	}
		 

	}

