package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import libreplanException.TestException;
public class CreationProgressTypePage extends MenuPage {


	public CreationProgressTypePage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.champUnitName = driver.findElement(By.id(prefixe+"55"));
		this.champDefaultValue = driver.findElement(By.id(prefixe+"b5"));
		this.champPrecision = driver.findElement(By.id(prefixe+"e5"));
		this.champType = driver.findElement(By.id(prefixe+"h5"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.boutonSave = driver.findElement(By.xpath("//table[@id='"+prefixe+"l5-box']/tbody/tr[2]/td[@class='z-button-cm']"));
		this.boutonSaveContinue = driver.findElement(By.xpath("//table[@id='"+prefixe+"m5-box']/tbody/tr[2]/td[@class='z-button-cm']"));
		this.boutonCancel = driver.findElement(By.xpath("//table[@id='"+prefixe+"n5-box']/tbody/tr[2]/td[@class='z-button-cm']"));
		this.titreTableauCreerProgressType = driver.findElement(By.xpath("//div[@id='"+prefixe+"w4-hm']/span"));
		this.progressTypeListCreationTab = driver.findElements(By.xpath("//tbody[@id='"+prefixe+"25']"));
		this.checkboxPourcentage = driver.findElement(By.id(prefixe+"k5-real"));
		this.classChampDefaultValue = driver.findElement(By.xpath("//input[@id='"+prefixe+"b5']"));
	}                                     

/////////////////////////////  Attributs  ///////////////////////////////////////////////
	
WebElement boutonSave;	
WebElement champUnitName;
WebElement champDefaultValue;
WebElement champPrecision;
WebElement champType;
WebElement boutonSaveContinue;
WebElement boutonCancel;
WebElement titreTableauCreerProgressType;
List<WebElement> progressTypeListCreationTab;
WebElement checkboxPourcentage;
WebElement classChampDefaultValue;



////////////// Méthodes d'action et insert de données pour test  ///////////////////////

	public void remplirChampUnitName(String nom){
		champUnitName.sendKeys(nom);
	}

	public void remplirChampUnitName(double max){
		champDefaultValue.clear();
		champDefaultValue.sendKeys(String.valueOf(max));
	}
	
	public ProgressTypePage sauvegarderType(){
		boutonSave.click();
		return new ProgressTypePage(driver);
	}

	public void cocherCheckboxPourcentage(){
		checkboxPourcentage.click();
	}
	
	public MessageCreationProgressTypePage sauvegarderEtContinuerType(){
		boutonSaveContinue.click();
		return new MessageCreationProgressTypePage(driver);
	}

	
///////////////////////  Méthodes de vérification	//////////////////////////////////

	public void testCase(){
		String contenuCase = champPrecision.getText();
		System.out.print(contenuCase+"texte attendu ici");
	}
	
	
	public void verifBouton(String textBouton1, String textBouton2){
		String contenuBouton1 = boutonSaveContinue.getText();
		String contenuBouton2 = boutonCancel.getText();
		assertEquals(contenuBouton1, textBouton1 );
		assertEquals(contenuBouton2, textBouton2 );
		
	}
	
	public void verifNomTableau(String titreTableau){
		String contenuSpan = titreTableauCreerProgressType.getText();
		assertEquals(contenuSpan, titreTableau );
	}
	
	public void verifChampType() throws TestException{
		if(champType.getTagName().equals("input")){	
			throw new TestException();
		}
	
	}
	
	public void verifChampValMax(){
		String classElementChampValeurMax = classChampDefaultValue.getAttribute("class");
		assertEquals("z-decimalbox z-decimalbox-disd z-decimalbox-text-disd", classElementChampValeurMax);
		}
	
	
	public int parcourTableauProgressTypeListCreation1(String nomchamp1){
		int numeroDeLigne = 1;
		List<WebElement>lignes = progressTypeListCreationTab;
		for (WebElement ligne : lignes) {
			List<WebElement> cases = ligne.findElements(By.xpath("./tr/td/div/span"));
			if (nomchamp1.equals(cases.get(0).getText())) {
				return numeroDeLigne;
			}
			numeroDeLigne = numeroDeLigne + 1;
		}
		return -1;		
}
		
		public int parcourTableauProgressTypeListCreation2(String nomchamp2){
			int numeroDeLigne = 1;
			List<WebElement>lignes = progressTypeListCreationTab;
			for(WebElement ligne : lignes){
				List<WebElement> cases = ligne.findElements(By.xpath("./tr[2]/td/div/span"));
				if(nomchamp2.equals(cases.get(0).getText())){
					return numeroDeLigne;
	}
			numeroDeLigne = numeroDeLigne +1;
		}	
			return -1;		
	}
			
		public int parcourTableauProgressTypeListCreation3(String nomchamp3){
			int numeroDeLigne = 1;
			List<WebElement>lignes = progressTypeListCreationTab;
			for(WebElement ligne : lignes){
				List<WebElement> cases = ligne.findElements(By.xpath("./tr[3]/td/div/span"));
				if(nomchamp3.equals(cases.get(0).getText())){
					return numeroDeLigne;
}
			numeroDeLigne = numeroDeLigne +1;
	}
			return -1;		
	}
			
		public int parcourTableauProgressTypeListCreation4(String nomchamp4){
			int numeroDeLigne = 1;
			List<WebElement>lignes = progressTypeListCreationTab;	
			for(WebElement ligne : lignes){
				List<WebElement> cases = ligne.findElements(By.xpath("./tr[4]/td/div/span"));
				if(nomchamp4.equals(cases.get(0).getText())){
					return numeroDeLigne;
}
			numeroDeLigne = numeroDeLigne +1;
	}
			return -1;		
	}
		
		public int parcourTableauProgressTypeListCreation5(String nomchamp5){
			int numeroDeLigne = 1;
			List<WebElement>lignes = progressTypeListCreationTab;	
			for(WebElement ligne : lignes){
				List<WebElement> cases = ligne.findElements(By.xpath("./tr[5]/td/div/span"));
				if(nomchamp5.equals(cases.get(0).getText())){
					return numeroDeLigne;
}
			numeroDeLigne = numeroDeLigne +1;
	}
			return -1;		
	}
		
		public int parcourTableauProgressTypeListCreation6(String nomchamp6){
			int numeroDeLigne = 1;
			List<WebElement>lignes = progressTypeListCreationTab;		
			for(WebElement ligne : lignes){
				List<WebElement> cases = ligne.findElements(By.xpath("./tr[6]/td/div/span"));
				if(nomchamp6.equals(cases.get(0).getText())){
					return numeroDeLigne;
}
			numeroDeLigne = numeroDeLigne +1;
	}
			
			return -1;		
	}
		
		
	public void verifsPage() throws TestException{
		verifBouton("Save & Continue", "Cancel");
		verifNomTableau("Edit");
		verifChampType();
		int resultat1 = parcourTableauProgressTypeListCreation1("Unit name");
		assertNotEquals(resultat1, -1);
		int resultat2 = parcourTableauProgressTypeListCreation2("Active");
		assertNotEquals(resultat2, -1);
		int resultat3 = parcourTableauProgressTypeListCreation3("Default max value");
		assertNotEquals(resultat3, -1);
		int resultat4 = parcourTableauProgressTypeListCreation4("Precision");
		assertNotEquals(resultat4, -1);
		int resultat5 = parcourTableauProgressTypeListCreation5("Type");
		assertNotEquals(resultat5, -1);
		int resultat6 = parcourTableauProgressTypeListCreation6("Percentage");
		assertNotEquals(resultat6, -1);
	}
}
	
	




