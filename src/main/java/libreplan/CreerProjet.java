package libreplan;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreerProjet extends MenuPage{

	public CreerProjet(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.titreCreateNewProject = driver.findElement(By.id(prefixe+"h7-cap"));
		this.champName = driver.findElement(By.id(prefixe+"p7"));
		this.champTemplate = driver.findElement(By.id(prefixe+"v7-real"));
		this.champCode = driver.findElement(By.id(prefixe+"38"));
		this.checkBoxCode = driver.findElement(By.id(prefixe+"48-real"));
		this.champDate = driver.findElement(By.id(prefixe+"k9-real"));
		this.champDeadline = driver.findElement(By.id(prefixe+"n9-real"));
		this.champTemplate = driver.findElement(By.id(prefixe+"v7-real"));
		this.champClient = driver.findElement(By.id(prefixe+"s9-real"));
		this.champCalendar = driver.findElement(By.id(prefixe+"0a-real"));
		this.boutonAccept = driver.findElement(By.xpath("//span[@class='save-button global-action z-button']/table/tbody/tr[2]/td[2]"));
		this.boutonCancel = driver.findElement(By.xpath("//span[@class='cancel-button global-action z-button']/table/tbody/tr[2]/td[2]"));
	}
	
	WebElement titreCreateNewProject;
	WebElement champName;
	WebElement champTemplate;
	WebElement champCode;
	WebElement checkBoxCode;
	WebElement champDate;
	WebElement champDeadline;
	WebElement champClient;
	WebElement champCalendar;
	WebElement boutonAccept;
	WebElement boutonCancel;
	
	public String datePlus5Jours(){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(5);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public String datePlus15Jours(){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(15);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public void creerNouveauProjet(String name, String code){
		this.titreCreateNewProject.isDisplayed();
		this.champName.getText().isEmpty();
		this.champName.sendKeys(name);
		this.champTemplate.getText().isEmpty();
		this.champCode.isDisplayed();
		this.checkBoxCode.click();
		this.champCode.clear();
		this.champCode.sendKeys(code);
		this.champDate.isDisplayed();
		this.champDate.clear();
		this.champDate.sendKeys(datePlus5Jours());
		this.champDeadline.isDisplayed();
		this.champDeadline.sendKeys(datePlus15Jours());
		this.champClient.isDisplayed();
		this.champClient.getText().isEmpty();
		this.champCalendar.isDisplayed();
		this.champCalendar.getText().contains("Default");
		this.boutonAccept.isDisplayed();
		this.boutonCancel.isDisplayed();
		this.boutonAccept.click();
	}
	
	public ProjetCree projetCree(){
		return new ProjetCree(driver);
	}

}
