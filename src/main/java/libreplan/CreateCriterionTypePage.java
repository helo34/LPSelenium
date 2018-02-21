package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCriterionTypePage{

	public CreateCriterionTypePage(WebDriver driver) {
		super();
		this.driver = driver;
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		this.champName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='"+ prefixe +"e5']")));
		this.menuType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='"+ prefixe +"h5-real']")));
		this.caseValuesPerResource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='"+ prefixe +"k5-real']")));
		this.caseHierarchy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='"+ prefixe +"n5-real']")));
		this.caseEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='"+ prefixe +"q5-real']")));
		this.champDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='"+ prefixe +"t5']")));
		this.boutonCancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='"+ prefixe +"j6']")));
		this.boutonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='"+ prefixe +"h6']")));
		this.boutonSaveAndContinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='"+ prefixe +"i6']")));
	}
	
	WebDriver driver;
	WebElement champName;
	WebElement menuType;
	WebElement caseValuesPerResource;
	WebElement caseHierarchy;
	WebElement caseEnabled;
	WebElement champDescription;
	WebElement boutonCancel;
	WebElement boutonSave;
	WebElement boutonSaveAndContinue;
	
	
	public void creerCritere (String nom, String description){
	champName.sendKeys(nom);
	menuType.clear();
	menuType.sendKeys("WORKER");
	champDescription.sendKeys(description);
	}
	
	public boolean verifierSiCaseValuesPerResourceCochee(){
		return caseValuesPerResource.isSelected();
	}
	public boolean verifierSiCaseHierarchyCochee(){
		return caseHierarchy.isSelected();
	}	
	public boolean verifierSiCaseEnabledCochee(){
		return caseEnabled.isSelected();
	}	
	
	public CriteriaPage clicAnnuler(){
		boutonCancel.click();
		return new CriteriaPage(driver);
	}
	public CriteriaPage clicEnregistrer(){
		boutonSave.click();
		return new CriteriaPage(driver);
	}
	public MessageRetourEnregistrementCriteria clicEnregistrerEtContinuer(){
		boutonSaveAndContinue.click();
		return new MessageRetourEnregistrementCriteria(driver);
	}
	
		
		
}
