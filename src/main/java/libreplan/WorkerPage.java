package libreplan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkerPage extends MenuPage {


	public WorkerPage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.headerWorkerTab = driver.findElements(By.xpath("//div[@id='"+prefixe+"p5-head']/table/tbody/tr"));
		this.champFiltrerPar = driver.findElement(By.id(prefixe+"q4-real"));
		this.iconeLoupe = driver.findElement(By.id(prefixe+"q4-btn"));
		this.champDetailPerso = driver.findElement(By.id(prefixe+"d5"));
		this.boutonPlusOptions = driver.findElement(By.id(prefixe+"f5-cnt"));
		this.boutonFiltrer = driver.findElement(By.xpath("//table[@id='"+prefixe+"n5-box']/tbody/tr[2]/td[2]"));
		this.boutonCreer = driver.findElement(By.xpath("//table[@id='"+prefixe+"y5-box']/tbody/tr[2]/td[2]"));
		this.boutonNext = driver.findElement(By.xpath("//table[@id='"+prefixe+"q5-next']/tbody/tr/td[2]/em/button"));
		this.boutonPrev = driver.findElement(By.xpath("//table[@id='"+prefixe+"q5-prev']/tbody/tr/td[2]/em/button"));
		this.boutonFirst = driver.findElement(By.xpath("//table[@id='"+prefixe+"q5-first']/tbody/tr/td[2]/em/button"));
		this.boutonLast = driver.findElement(By.xpath("//table[@id='"+prefixe+"q5-last']/tbody/tr/td[2]/em/button"));
		this.champPageTableau = driver.findElement(By.id(prefixe+"q5-real"));
		this.NombreDepage = driver.findElement(By.xpath("//div[@id='"+prefixe+"q5']/table/tbody/tr/td[6]/span"));
	}
	
	WebElement messageConirmationCreationWorker;
	WebElement boutonNext;
	List<WebElement> headerWorkerTab;
	WebElement champFiltrerPar;
	WebElement iconeLoupe;
	WebElement champDetailPerso;
	WebElement boutonPlusOptions;
	WebElement boutonFiltrer;
	WebElement boutonCreer;
	List<WebElement> workerListTab; 
	WebElement champPageTableau;
	WebElement boutonPrev;	
	WebElement boutonLast;
	WebElement boutonFirst;
	WebElement NombreDepage;
	
		public String MessageApresCreation(){
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.messageConirmationCreationWorker = driver.findElement(By.id(prefixe+"c9"));
		return messageConirmationCreationWorker.getText();
		
	}
		
		public int parcourHeaderTableauWorker(String nomDuColonne1, String nomDuColonne2, String nomDuColonne3, String nomDuColonne4, String nomDuColonne5, String nomDuColonne6){
		int numeroDeLigne = 1;
		List<WebElement>lignes = headerWorkerTab;
		for(WebElement ligne : lignes){
		List<WebElement> cases = ligne.findElements(By.xpath("./th/div"));
		if(nomDuColonne1.equals(cases.get(0).getText()) && nomDuColonne2.equals(cases.get(1).getText()) && nomDuColonne3.equals(cases.get(2).getText()) && nomDuColonne4.equals(cases.get(3).getText()) && nomDuColonne4.equals(cases.get(3).getText()) && nomDuColonne5.equals(cases.get(4).getText()) && nomDuColonne6.equals(cases.get(5).getText())){
			return numeroDeLigne;
		}	
		numeroDeLigne = numeroDeLigne +1;
	}
	
		return -1;
	}
	
	public PersonalDataWorkerPage cliquerBoutonCréer(){
		boutonCreer.click();
		return new PersonalDataWorkerPage(driver);
	}
	
	public int parcourTableauWorker2(String nomNewWorker, String prenomNewWorker, String idNewWorker){
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.workerListTab = driver.findElements(By.xpath("//div[@id='"+prefixe+"p5-body']/table/tbody[2]/tr"));	
		int numeroDeLigne = 1;
		List<WebElement>lignes = workerListTab;
		for(WebElement ligne : lignes){
		List<WebElement> cases = ligne.findElements(By.xpath("./td/div/span"));
		if(nomNewWorker.equals(cases.get(0).getText()) && prenomNewWorker.equals(cases.get(1).getText()) && idNewWorker.equals(cases.get(2).getText())){
			return numeroDeLigne;
		}	
		numeroDeLigne = numeroDeLigne +1;
	}
	
		return -1;
	}
	
	public void verifTableauProgressTypeList2(){
		int resultat = parcourTableauWorker2("DU", "Jean", "Jdu");
		assertNotEquals(resultat, -1);
	}
	
	public WorkerPage remplirDetailPerso(String prenomPerso){
		champDetailPerso.sendKeys(prenomPerso);
		boutonFiltrer.click();
		return new WorkerPage(driver);
	}
	
	public OptionFiltreWorkerPage cliquerPlusOptions(){
		boutonPlusOptions.click();
		return new OptionFiltreWorkerPage(driver);
	}
	
}
