package libreplan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarsListPage {
	
	protected final WebDriver driver;


	public CalendarsListPage(WebDriver driver) {
			
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.titreCalendarList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='"+ prefixe +"j4-cap']")));
		this.boutonCreateCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='"+ prefixe +"q4-box']")));
		this.enTeteTableauCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='"+ prefixe +"k4-head']")));
		this.contenuTableauCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']")));
		
	}
	
	
	WebElement titreCalendarList;
	WebElement boutonCreateCalendar;
	WebElement enTeteTableauCalendar;
	WebElement contenuTableauCalendar;
	
	
	String prefixe;	
//	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public boolean afficherDerivesCalendar(){
		WebElement iconeAfficherDerivesCalendrier = driver.findElement(By.xpath("//span[@id='"+ prefixe +"ca-open']"));
		WebElement ligneDerivesCalendrier = driver.findElement(By.xpath("//div[@id='"+ prefixe +"ta-cave']"));
		iconeAfficherDerivesCalendrier.isDisplayed();
		return ligneDerivesCalendrier.isDisplayed();				
	}
	
	public void clicIconeAfficherDerives(){
		WebElement iconeAfficherDerivesCalendrier = driver.findElement(By.xpath("//span[@id='"+ prefixe +"ca-open']"));
		iconeAfficherDerivesCalendrier.click();			
	}
	
	public CreateCalendarPage clicBoutonCreateCalendars(){
		boutonCreateCalendar.click();
		return new CreateCalendarPage(driver);			
	}
	
	public CreateCalendarPage clicIconeCreateDerived(String nomCalendarConcerne){
		
		List <WebElement> lignesTableauCriteria = contenuTableauCalendar.findElements(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr"));
		Integer compteurLignes = 1; 
		
		for(WebElement ligne : lignesTableauCriteria){
			WebElement labelCaseCalendars = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[1]/div/span[2]"));
			  if(!nomCalendarConcerne.equals(labelCaseCalendars.getText())){
				  compteurLignes = compteurLignes+1;
			  }
			  else 
			  { WebElement iconeCreateDerived = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[4]/div/span[1]"));
			  iconeCreateDerived.click(); 
			  }
		}		
		return new CreateCalendarPage(driver);			
	}
	
public CreateCalendarPage clicIconeCreateCopie(String nomCalendarConcerne){
		
		List <WebElement> lignesTableauCriteria = contenuTableauCalendar.findElements(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr"));
		Integer compteurLignes = 1; 
		
		for(WebElement ligne : lignesTableauCriteria){
			WebElement labelCaseCalendars = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[1]/div/span[2]"));
			  if(!nomCalendarConcerne.equals(labelCaseCalendars.getText())){
				  compteurLignes = compteurLignes+1;
			  }
			  else 
			  { WebElement iconeCreateCopie = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[4]/div/span[2]"));
			  iconeCreateCopie.click(); 
			  }
		}
		
		return new CreateCalendarPage(driver);			
	}

public CreateCalendarPage clicIconeEditCalendar(String nomCalendarConcerne){
	
	List <WebElement> lignesTableauCriteria = contenuTableauCalendar.findElements(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr"));
	Integer compteurLignes = 1; 
	
	for(WebElement ligne : lignesTableauCriteria){
		WebElement labelCaseCalendars = ligne.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[1]/div/span[2]"));
		  if(!nomCalendarConcerne.equals(labelCaseCalendars.getText())){
			  compteurLignes = compteurLignes+1;
		  }
		  else 
		  { WebElement iconeEditCalendar = driver.findElement(By.xpath("//tbody[@id='"+ prefixe +"k4-rows']/tr["+compteurLignes+"]/td[4]/div/span[3]"));
		  iconeEditCalendar.click(); 
		  }
	}
	
	return new CreateCalendarPage(driver);			
}
	
}
