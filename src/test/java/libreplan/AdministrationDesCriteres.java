package libreplan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AdministrationDesCriteres {

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
	
//PDT1 : Se connecter � l'application
	@Test
	public void AdministrationDesCriteresTest(){
		
		LoginPage page = new LoginPage(driver);
		MenuPage page1 = page.connexion("admin", "admin");
		page1.logo.isDisplayed();
		System.out.println("PDT1 OK");
	
//PDT2 : Acc�der � la page d'administration des crit�res
	MenuPage pageM = new MenuPage(driver);
	CriteriaPage page2 = pageM.resourcesToCriteria();
	page2.headerTableauCriteria.isDisplayed();
	//Assert incomplet, regarder le print pour v�rifier en attendant
	System.out.println(page2.headerTableauCriteria.getText());
	Assert.assertTrue(page2.headerTableauCriteria.getText().contains("Name")); 
	page2.boutonCreate.isDisplayed();
	System.out.println("PDT2 OK");
	
//PDT3 : Cr�er un crit�re - Acc�s au formulaire de cr�ation
	CreateCriterionTypePage page3 = page2.clicBoutonCreate();
	page3.menuType.isDisplayed();
	page3.boutonCancel.isDisplayed();
	page3.boutonSave.isDisplayed();
	page3.boutonSaveAndContinue.isDisplayed();
	System.out.println("PDT3 OK");
	
//PDT4 : Cr�er un crit�re - bouton [Annuler] :
	page3.creerCritere("Crit�re - Test bouton [Annuler]", "Crit�re - Test bouton [Annuler]");
	page3.verifierSiCaseEnabledCochee();
	page3.verifierSiCaseHierarchyCochee();
	page3.verifierSiCaseValuesPerResourceCochee();
	CriteriaPage page4 = page3.clicAnnuler();
	Assert.assertNotSame("Crit�re - Test bouton [Annuler]", page4.contenuTableauCriteria.getText()); 
	System.out.println("PDT4 OK");
	
//PDT5 : Cr�er un crit�re - bouton [Enregistrer]
	CreateCriterionTypePage page5 = page4.clicBoutonCreate();
	page5.creerCritere("Crit�re - Test bouton [Enregistrer]","Crit�re - Test bouton [Enregistrer]");
	page5.verifierSiCaseEnabledCochee();
	page5.verifierSiCaseHierarchyCochee();
	page5.verifierSiCaseValuesPerResourceCochee();
	CriteriaPage page6 = page5.clicEnregistrer();
	Assert.assertTrue(page6.contenuTableauCriteria.getText().contains("Crit�re - Test bouton [Enregistrer]"));
	
	System.out.println("PDT5 OK");
	
  //PDT6 : Cr�er un crit�re - Acc�s au formulaire de cr�ation
	CreateCriterionTypePage page7 = page6.clicBoutonCreate();
	page7.boutonCancel.isDisplayed();
	page7.boutonSave.isDisplayed();
	page7.boutonSaveAndContinue.isDisplayed();
	page7.champDescription.isDisplayed();
	page7.champName.isDisplayed();
	page7.caseEnabled.isDisplayed();
	page7.caseHierarchy.isDisplayed();
	System.out.println("PDT6 OK");
	
//PDT7 : Cr�er un crit�re - bouton [Sauver et continuer]
	page7.creerCritere("Crit�re - Test bouton [Sauver et continuer]", "Crit�re - Test bouton [Sauver et continuer]");
	page7.verifierSiCaseEnabledCochee();
	page7.verifierSiCaseHierarchyCochee();
	page7.verifierSiCaseValuesPerResourceCochee();
	MessageRetourEnregistrementCriteria page8 = page7.clicEnregistrerEtContinuer();
	page8.afficherMessageConfirmationEnregistrement();
	//Assert.assertTrue(page8.messageRetourEditionCritere.getText().contains("Sauver et continuer"));
	Assert.assertTrue(page8.titreDeLaPage.getText().contains("Edit Criterion Type"));	
	System.out.println("PDT7 OK");
	
//PDT8 : Retour page d'administration des crit�res
	
	CriteriaPage page8bis = page8.clicAnnulerEdit();
	//System.out.print(page8bis.contenuTableauCriteria.getText());
	Assert.assertTrue(page8bis.contenuTableauCriteria.getText().contains("Sauver et continuer"));
	System.out.println("PDT8 OK");
		
//PDT9 : Modifier un crit�re - acc�s formulaire de modification - Colonne "Op�ration"
	EditCriterionPage page9 = page8bis.clicIconeCritereAModifier("Crit�re - Test bouton [Sauver et continuer]");
	Assert.assertTrue(page9.titreDeLaPage.getText().contains("Edit Criterion Type"));	
	System.out.println("PDT9 OK");
		
//PDT10 : Modifier un crit�re -  Bouton [Annuler]
	
	page9.changerNomCritere("Crit�re - Test bouton [Sauver et continuer] 2");
	CriteriaPage page10 = page9.clicAnnulerEdit();
	// V�rifier que nom crit�re n'a pas �t� modifi�
	Assert.assertTrue(page10.contenuTableauCriteria.getText().contains("Crit�re - Test bouton [Sauver et continuer]"));
	System.out.println("PDT10 OK");
	
//PDT11 : Modifier un crit�re - acc�s formulaire de modification - Colonne "Nom"
	
	EditCriterionPage page11 = page10.clicNomCritereAModifier("Crit�re - Test bouton [Sauver et continuer]");
	Assert.assertTrue(page9.titreDeLaPage.getText().contains("Edit Criterion Type"));	
	System.out.println("PDT11 OK");
	
//PDT12 : Modifier un crit�re - modification du nom
	
	page11.changerNomCritere("Crit�re - Test bouton [Sauver et continuer] 2");
	System.out.println("PDT12 OK");
	
//PDT13 : Modifier un crit�re - bouton [Sauver et continuer]
	
	MessageRetourEnregistrementCriteria page12 = page11.clicEnregistrerEtContinuerEdit();
	page12.afficherMessageConfirmationEnregistrement();
	Assert.assertTrue(page12.titreDeLaPage.getText().contains("Edit Criterion Type"));
	System.out.println("PDT13 OK");
	
//PDT14 : Retour page d'administration des crit�res
	
	CriteriaPage page13 = page12.clicAnnulerEdit();	
	System.out.println(page13.contenuTableauCriteria.getText());
	Assert.assertTrue(page13.contenuTableauCriteria.getText().contains("Crit�re - Test bouton [Sauver et continuer] 2"));
	System.out.println("PDT14 OK");
	
//PDT15 : Supprimer un crit�re - Pop-up de confirmation
	
	PopUpSuppression page14 = page13.clicIconeSupprimer("Crit�re - Test bouton [Sauver et continuer] 2");
	// V�rifier texte
	page14.textePopUp.isDisplayed();
	System.out.println("PDT15 OK");
	
//PDT16 : Supprimer un crit�re - Bouton [Annuler]
	CriteriaPage page15 = page14.clicBoutonAnnulerPopUp();
	System.out.println("PDT16 OK");
	
//PDT17 : Supprimer un crit�re - Pop-up de confirmation
	PopUpSuppression page16 = page15.clicIconeSupprimer("Crit�re - Test bouton [Sauver et continuer] 2");
	page16.textePopUp.isDisplayed();
	System.out.println(page16.textePopUp.getText());
	System.out.println("PDT17 OK");
	
//PDT18 : Supprimer un crit�re - Bouton [OK]
	CriteriaPage page17 = page16.clicBoutonOKPopUp(); 
	Assert.assertFalse(page17.contenuTableauCriteria.getText().contains("Crit�re - Test bouton [Sauver et continuer]2"));
	System.out.println("PDT18 OK");
	

// suppression actions du test
	
	}
}
	
/*	public void waitIsClickable(String xpath){
		WebDriverWait Wait1 = new WebDriverWait(driver, 10);
		Wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	   */
