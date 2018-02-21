package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjetPage{

	public ProjetPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.ongletWBStasks = driver.findElement(By.xpath("//div[@id='"+prefixe+"47-hm']/span"));
		this.start = driver.findElement(By.xpath("//table[@id='"+prefixe+"23']/tbody/tr/td/table/tbody/tr/td[2]/strong"));
		this.fleche1 = driver.findElement(By.id(prefixe+"07"));
		this.planning = driver.findElement(By.id(prefixe+"17"));
		this.fleche2 = driver.findElement(By.id(prefixe+"27"));
		this.projectDetails = driver.findElement(By.id(prefixe+"p5"));
		this.fleche3 = driver.findElement(By.id(prefixe+"q5"));
		this.projetTest1 = driver.findElement(By.id(prefixe+"a20"));
		this.champNewTask = driver.findElement(By.id(prefixe+"i9"));
		this.hours = driver.findElement(By.id(prefixe+"z5"));
		this.boutonAdd = driver.findElement(By.xpath("//span[@id='"+prefixe+"_6']/table/tbody/tr[2]/td[2]"));
	}
	
	WebDriver driver;
	WebElement ongletWBStasks;
	WebElement start;
	WebElement fleche1;
	WebElement planning;
	WebElement fleche2;
	WebElement projectDetails;
	WebElement fleche3;
	WebElement projetTest1;
	WebElement champNewTask;
	WebElement hours;
	WebElement boutonAdd;
	
	public void verifierPage(String name){
		this.ongletWBStasks.isDisplayed();
		this.start.isDisplayed();
		Assert.assertEquals("START", start.getText());
		this.fleche1.isDisplayed();
		this.planning.isDisplayed();
		Assert.assertEquals("Planning", planning.getText());
		this.fleche2.isDisplayed();
		this.projectDetails.isDisplayed();
		Assert.assertEquals("Project Details", projectDetails.getText());
		this.fleche3.isDisplayed();
		this.projetTest1.isDisplayed();
		Assert.assertEquals(name, projetTest1.getText());
	}
	
	public void creationTache(String nomTache, String hour){
		this.champNewTask.sendKeys(nomTache);
		this.hours.clear();
		this.hours.sendKeys(hour);
		this.boutonAdd.click();
	}
	
	public TachePage tachePage(){
		return new TachePage(driver);
	}

}
