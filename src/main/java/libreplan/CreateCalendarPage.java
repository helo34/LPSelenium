package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarPage {

	protected WebDriver driver;
	
	public CreateCalendarPage(WebDriver driver) {
		
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		this.titreCreateCalendar = driver.findElement(By.xpath("//div[@id='"+ prefixe +"r4-cap']"));
		this.ongletDonneesCalendrier = driver.findElement(By.xpath("//div[@id='"+ prefixe +"v4-hl']/div/div/span"));
		this.champNomCalendar = driver.findElement(By.xpath("//input[@id='"+ prefixe +"45']"));
		this.typeCalendar = driver.findElement(By.xpath("//span[@id='"+ prefixe +"85']"));
		
		this.boutonSaveCalendar = driver.findElement(By.xpath("//table[@id='"+ prefixe +"z7-box']/tbody/tr[2]/td[2]"));
		this.boutonSaveAndContinueCalendar = driver.findElement(By.xpath("//table[@id='"+ prefixe +"_8-box']/tbody/tr[2]/td[2]"));
		this.boutonCancelCalendar = driver.findElement(By.xpath("//table[@id='"+ prefixe +"08-box']/tbody/tr[2]/td[2]"));
		this.caseGenerateCode = driver.findElement(By.xpath("//input[@id='"+ prefixe +"d5-real']"));
	}
	
	WebElement titreCreateCalendar;
	WebElement champNomCalendar;
	WebElement champNomCalendarRempli;
	WebElement typeCalendar;
	WebElement boutonSaveCalendar;
	WebElement boutonSaveAndContinueCalendar;
	WebElement boutonCancelCalendar;
	WebElement ongletDonneesCalendrier;
	WebElement caseGenerateCode;
	String prefixe;	
	
	public CalendarsListPage clicBoutonSaveCalendars(){
	boutonSaveCalendar.click();
	return new CalendarsListPage(driver);			
	}
	
	public MessageRetourEnregistrementCalendar clicBoutonSaveAndContinueCalendars(){
		boutonSaveAndContinueCalendar.click();
		return new MessageRetourEnregistrementCalendar(driver);			
	} 
	
	public MessageRetourErreurCalendar clicErreurSaveAndContinueCalendar(){
		boutonSaveAndContinueCalendar.click();
		return new MessageRetourErreurCalendar(driver);			
	}
	public CalendarsListPage clicBoutonCancelCalendar(){
		boutonCancelCalendar.click();
		return new CalendarsListPage(driver);			
	}
	
	//public String afficherContenuDuChampNom(){
	//	WebElement champNomCalendarRempli = driver.findElement(By.xpath("//div[@id='"+ prefixe +"h4-cave']/table/div/div[3]/div/div[2]/table/tbody[2]/tr[1]/td[1]/div/span[2]"));
	//	String contenuChampNom = champNomCalendarRempli.getText();
	//	return contenuChampNom;

	
	
}

