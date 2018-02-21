package libreplan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CriteriaPage {

	public CriteriaPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.boutonCreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='"+ prefixe +"_5-box']/tbody/tr[2]/td[@class='z-button-cm']")));
		this.headerTableauCriteria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='"+ prefixe +"k4-head']")));
		this.contenuTableauCriteria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='"+ prefixe +"r4']")));
		
	}
	
	WebDriver driver;
	WebElement boutonCreate;
	WebElement iconeModifier;
	WebElement nomCritereDansListe;
	WebElement iconeSupprimer;
	WebElement contenuTableauCriteria;
	WebElement headerTableauCriteria;
	
	String prefixe;					
		
		public CreateCriterionTypePage clicBoutonCreate(){
			boutonCreate.click();
			return new CreateCriterionTypePage(driver);			
		}
		
		public EditCriterionPage clicIconeCritereAModifier(String nomCritereAModifier){
			
			List <WebElement> lignesTableauCriteria = contenuTableauCriteria.findElements(By.xpath("//tr[@class='clickable-rows z-row']"));
			Integer compteurLignes = 1; 
			
			for(WebElement ligne : lignesTableauCriteria){
				WebElement labelCaseCriteria = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr["+compteurLignes+"]/td[1]//span[@class='z-label']"));
				  if(!nomCritereAModifier.equals(labelCaseCriteria.getText())){
					  compteurLignes = compteurLignes+1;
				  }
				  else 
				  { WebElement iconeModifier = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr["+compteurLignes+"]//span[@title='Edit']"));
				  iconeModifier.click(); 
				  }
			}
			
			return new EditCriterionPage(driver);			
		}
			
		public EditCriterionPage clicNomCritereAModifier (String nomCritereAModifier){
			//String nomCritereCaseCourante = labelCaseCriteria.getAttribute("title");
			//System.out.println(nomCritereCaseCourante);	
			
			List <WebElement> lignesTableauCriteria = contenuTableauCriteria.findElements(By.xpath("//tr[@class='clickable-rows z-row']"));
			Integer compteurLignes = 1; 
			
			for(WebElement ligne : lignesTableauCriteria){
				WebElement labelCaseCriteria = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr["+compteurLignes+"]/td[1]//span[@class='z-label']"));			 
				if(!nomCritereAModifier.equals(labelCaseCriteria.getText())){
					  compteurLignes = compteurLignes+1;
				  }
				  else 
				  { WebElement nomSelectionne = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr[1]/td["+compteurLignes+"]/div/span[@class='z-label']"));
				  nomSelectionne.click();
				  }
			}
				return new EditCriterionPage(driver);
			}
		
			
			
		public PopUpSuppression clicIconeSupprimer(String nomCritereAModifier){
			List <WebElement> lignesTableauCriteria = contenuTableauCriteria.findElements(By.xpath("//tr[@class='clickable-rows z-row']"));
			Integer compteurLignes = 1; 
			
			for(WebElement ligne : lignesTableauCriteria){
				WebElement labelCaseCriteria = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr["+compteurLignes+"]/td[1]//span[@class='z-label']"));			 
				if(!nomCritereAModifier.equals(labelCaseCriteria.getText())){
					  compteurLignes = compteurLignes+1;
				  }
				  else 
				  { WebElement iconeSupprimer = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"r4']/tr["+compteurLignes+"]//span[@title='Delete']"));
				  iconeSupprimer.click();
				  }
			}
			return new PopUpSuppression(driver);	
			}
		
	}

