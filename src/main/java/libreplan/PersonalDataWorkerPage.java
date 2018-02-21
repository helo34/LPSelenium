package libreplan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libreplanException.TestException;

public class PersonalDataWorkerPage extends  CreationWorkerPage {


	public PersonalDataWorkerPage(WebDriver driver) {
		super(driver);
	String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
	String prefixe = idElement.substring(0, 4);
	this.titreSectionData = driver.findElement(By.id(prefixe+"b6-cnt"));
	this.caseCode = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[1]/td/div/span"));
	this.caseFirstName = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[2]/td/div/span"));
	this.caseLastName = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[4]/td/div/span"));
	this.caseId = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[5]/td/div/span"));
	this.caseType = driver.findElement(By.xpath("//td[@id='"+prefixe+"_7-chdex']/span"));
	this.checkboxOptions1 = driver.findElements(By.xpath("//span[@id='"+prefixe+"77']//input"));
	this.boutonSave = driver.findElement(By.xpath("//table[@id='"+prefixe+"9f-box']/tbody/tr[2]/td[@class='z-button-cm']"));
	this.boutonSaveContinue = driver.findElement(By.xpath("//table[@id='"+prefixe+"8f-box']/tbody/tr[2]/td[@class='z-button-cm']"));
	this.boutonCancel = driver.findElement(By.xpath("//table[@id='"+prefixe+"9f-box']/tbody/tr[2]/td[@class='z-button-cm']"));
	this.champCase = driver.findElement(By.id(prefixe+"k6"));
	this.champsFirstName = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[2]/td[2]/div/input"));
	this.champLastName = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[4]/td[2]/div/input"));
	this.champIDName = driver.findElement(By.xpath("//tbody[@id='"+prefixe+"g6']/tr[5]/td[2]/div/input"));
	this.typeParDefaut = driver.findElement(By.id(prefixe+"3a"));
	}
	
	WebElement titreSectionData;
	WebElement caseType;
	WebElement caseId;
	WebElement caseLastName;
	WebElement caseFirstName;
	WebElement caseCode;
	List<WebElement> checkboxOptions1;
	WebElement boutonCancel;
	WebElement boutonSaveContinue;
	WebElement boutonSave;
	WebElement champCase;
	WebElement champsFirstName;
	WebElement champLastName;
	WebElement champIDName;
	WebElement typeParDefaut;
	
public void verifChampCase() throws TestException{
	if(champCase.isEnabled()){	
		throw new TestException();
		}
	}

public void remplirDataWorker(String prenom, String nom, String Name){
	champsFirstName.sendKeys(prenom);
	champLastName.sendKeys(nom);
	champIDName.sendKeys(Name);
}

public CreateNewUserPage cliquerBoutonCréer(){
checkboxOptions1.get(2).click();
return new CreateNewUserPage(driver);
}

public WorkerPage enregistrerNewWorker(){
	boutonSave.click();
	return new WorkerPage(driver);
	}
}

