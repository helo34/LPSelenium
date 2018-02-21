package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage{
	
	protected WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/libreplan/common/img/logo.png']")));
		this.ongletPlanning = driver.findElement(By.id(prefixe+"7-b"));
		this.ongletProject = driver.findElement(By.id(prefixe+"a-a"));
		this.menuVerticalProjectsList = driver.findElement(By.xpath("//span[@id='"+prefixe+"h4']/table/tbody/tr[2]/td[2]"));
		this.boutonCreerProjet = driver.findElement(By.xpath("//td[@class='z-button-cm']/img"));
		// Onglet Resources
		this.ongletResources =  wait.until(ExpectedConditions.elementToBeClickable(By.id(prefixe+"r-b")));
		 //sous-onglets
		this.sousOngletCriteria = driver.findElement(By.id(prefixe+"y-a"));
		this.sousOngletWorker = driver.findElement(By.id(prefixe+"t-a"));
		this.sousOngletMachines = driver.findElement(By.id(prefixe+"u-a"));
		this.sousOngletVirtualWorkers = driver.findElement(By.id(prefixe+"v-a"));
		this.sousOngletCalendars = driver.findElement(By.id(prefixe+"w-a"));
		this.sousOngletCalendarExceptionDays = driver.findElement(By.id(prefixe+"x-a"));
		this.sousOngletCriteria = driver.findElement(By.id(prefixe+"y-a"));
		this.sousOngletProgressTypes = driver.findElement(By.id(prefixe+"z-a"));
		this.sousOngletLabels = driver.findElement(By.id(prefixe+"_0-a"));
		this.sousOngletMaterials = driver.findElement(By.id(prefixe+"00-a"));
		this.sousOngletMaterialUnits = driver.findElement(By.id(prefixe+"10-a"));
		this.sousOngletQualityForm = driver.findElement(By.id(prefixe+"20-a"));
		// Onglet Cost
		this.ongletCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prefixe+"p0-b")));
		// Onglet Configuration
		this.ongletConfiguration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prefixe+"81-b")));
		// Onglet Communication
		this.ongletCommunication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prefixe+"m1-b")));
		// Onglet Reports
		this.ongletReports = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prefixe+"22-b")));
		// Onglet Personal Area	
		this.ongletPersonalArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prefixe+"v2-b")));
		//bouton LogOut
		this.boutonLogOut = driver.findElement(By.xpath("//a[@href='/libreplan/j_spring_security_logout']"));
	}
	
	String prefixe;
	WebElement ongletPlanning;
	WebElement ongletProject;
	WebElement menuVerticalProjectsList;
	WebElement boutonCreerProjet;
	//WebElement calendrier;
	WebElement logo;
	// Onglet Resources
	WebElement ongletResources;
	//sous-onglets
	WebElement sousOngletWorker;
	WebElement sousOngletMachines;	
	WebElement sousOngletVirtualWorkers;
	WebElement sousOngletCalendars;
	WebElement sousOngletCalendarExceptionDays;
	WebElement sousOngletCriteria;
	WebElement sousOngletProgressTypes;
	WebElement sousOngletLabels;
	WebElement sousOngletMaterials;
	WebElement sousOngletMaterialUnits;
	WebElement sousOngletQualityForm;
	// Onglet Cost
	WebElement ongletCost;
	// Onglet Configuration
	WebElement ongletConfiguration;
	// Onglet Communication
	WebElement ongletCommunication;
	// Onglet Reports
	WebElement ongletReports;
	// Onglet Personal Area	
	WebElement ongletPersonalArea;
	WebElement boutonLogOut;
	
	public void boutonCreerProjet(){
		this.boutonCreerProjet.click();
	}
	
	public CreerProjet nouveauProjet(){
		return new CreerProjet(driver);
	}
	
	public AccueilProjetPage accueilProjetPage(){
		Actions moveOver = new Actions(driver);
		moveOver.moveToElement(ongletPlanning).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(prefixe+"a-a"))).click();
		return new AccueilProjetPage(driver);
	}
	
	public void projectsList(){
		this.menuVerticalProjectsList.isDisplayed();
		this.menuVerticalProjectsList.click();
		this.menuVerticalProjectsList.isSelected();
	}
	
	public AccueilProjetPage2 accueilProjetPage2(){
		return new AccueilProjetPage2(driver);
	}
	
	public void impression(){
		this.driver.findElement(By.xpath("//span[@id='"+prefixe+"y4']/table/tbody/tr[2]/td[2]")).isDisplayed();
		this.driver.findElement(By.xpath("//span[@id='"+prefixe+"y4']/table/tbody/tr[2]/td[2]")).click();
	}
	
	public ImpPage impPage(){
		return new ImpPage(driver);
	}
	
	public ImpPage2 impPage2(){
		return new ImpPage2(driver);
	}
	
	public CriteriaPage resourcesToCriteria(){
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(ongletResources).moveToElement(sousOngletCriteria).click().build().perform();
		return new CriteriaPage(driver);
	}
		
	public CalendarsListPage resourcesToCalendars(){
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(ongletResources).moveToElement(sousOngletCalendars).click().build().perform();
		return new CalendarsListPage(driver);
	}
	
	public ProgressTypePage resourcesToProgressType(){
	Actions mouseHover = new Actions(driver);
	mouseHover.moveToElement(ongletResources).moveToElement(sousOngletProgressTypes).click().build().perform();
	return new ProgressTypePage(driver);
}
	
	public WorkerPage resourcesToWorker(){
	Actions mouseHover = new Actions(driver);
	mouseHover.moveToElement(ongletResources).moveToElement(sousOngletWorker).click().build().perform();
	return new WorkerPage(driver);
		}
	
	public LoginPage seDeconnecter(){
		boutonLogOut.click();
		return new LoginPage(driver);
		
	}
	
}
