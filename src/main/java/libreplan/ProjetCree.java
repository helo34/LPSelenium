package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProjetCree extends CreerProjet {

	public ProjetCree(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.menuVerticalProjectScheduling = driver.findElement(By.xpath("//span[@class='perspective order-scheduling z-button']/table/tbody/tr[2]/td[2]"));
		this.menuVerticalProjectDetails = driver.findElement(By.xpath("//span[@class='perspective-active order-data z-button']/table/tbody/tr[2]/td[2]"));
		this.menuVerticalResourcesLoad = driver.findElement(By.xpath("//span[@class='perspective order-load z-button']/table/tbody/tr[2]/td[2]"));
		this.menuVerticalAdvancedAllocation = driver.findElement(By.xpath("//span[@id='"+prefixe+"n4']/table/tbody/tr[2]/td[2]"));
		this.menuVerticalDashboard = driver.findElement(By.xpath("//span[@id='"+prefixe+"p4']/table/tbody/tr[2]/td[2]"));
		this.ongletWBStasks = driver.findElement(By.xpath("//div[@id='"+prefixe+"3c-hm']/span"));
		this.ongletGeneralData = driver.findElement(By.xpath("//div[@id='"+prefixe+"4c-hm']/span"));
		this.ongletCost2 = driver.findElement(By.xpath("//div[@id='"+prefixe+"5c-hm']/span"));
		this.ongletProgress = driver.findElement(By.xpath("//div[@id='"+prefixe+"6c-hm']/span"));
		this.ongletLabels = driver.findElement(By.xpath("//div[@id='"+prefixe+"7c-hm']/span"));
		this.ongletCriterionRequirement = driver.findElement(By.xpath("//div[@id='"+prefixe+"8c-hm']/span"));
		this.ongletMaterials = driver.findElement(By.xpath("//div[@id='"+prefixe+"9c-hm']/span"));
		this.ongletTaskQualityForms = driver.findElement(By.xpath("//div[@id='"+prefixe+"ac-hm']/span"));
		this.ongletAuthorizations = driver.findElement(By.xpath("//div[@id='"+prefixe+"bc-hm']/span"));
		this.boutonSave = driver.findElement(By.xpath("//table[@id='"+prefixe+"n40-box']/tbody/tr[2]/td[2]/img"));
		this.infoBulleSave = driver.findElement(By.xpath("//span[@id='"+prefixe+"n40']"));
		this.boutonRetour = driver.findElement(By.xpath("//table[@id='"+prefixe+"o40-box']/tbody/tr[2]/td[2]/img"));
		this.infoBulleRetour = driver.findElement(By.xpath("//span[@id='"+prefixe+"o40']"));
	}
	
	WebElement menuVerticalProjectScheduling;
	WebElement menuVerticalProjectDetails;
	WebElement menuVerticalResourcesLoad;
	WebElement menuVerticalAdvancedAllocation;
	WebElement menuVerticalDashboard;
	WebElement ongletWBStasks;
	WebElement ongletGeneralData;
	WebElement ongletCost2;
	WebElement ongletProgress;
	WebElement ongletLabels;
	WebElement ongletCriterionRequirement;
	WebElement ongletMaterials;
	WebElement ongletTaskQualityForms;
	WebElement ongletAuthorizations;
	WebElement boutonSave;
	WebElement infoBulleSave;
	WebElement boutonRetour;
	WebElement infoBulleRetour;

	public void verifierOnglets(){
		this.menuVerticalProjectScheduling.isDisplayed();
		this.menuVerticalProjectDetails.isDisplayed();
		this.menuVerticalResourcesLoad.isDisplayed();
		this.menuVerticalAdvancedAllocation.isDisplayed();
		this.menuVerticalDashboard.isDisplayed();
		this.ongletWBStasks.isDisplayed();
		this.ongletGeneralData.isDisplayed();
		this.ongletCost2.isDisplayed();
		this.ongletProgress.isDisplayed();
		this.ongletLabels.isDisplayed();
		this.ongletCriterionRequirement.isDisplayed();
		this.ongletMaterials.isDisplayed();
		this.ongletTaskQualityForms.isDisplayed();
		this.ongletAuthorizations.isDisplayed();
		this.boutonSave.isDisplayed();
	}
	
	public void verifierEditionProjetSave() throws Exception{
		Actions moveOver = new Actions(driver);
		moveOver.moveToElement(boutonSave).build().perform();
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']/table/tbody/tr[2]/td[2]/img"));
		this.infoBulleSave.getAttribute("title");
		Thread.sleep(2000);
		Assert.assertEquals("Save Project", infoBulleSave.getAttribute("title"));
	}
	
	public void verifierEditionProjetRetour() throws Exception{
		Actions moveOver = new Actions(driver);
		moveOver.moveToElement(boutonRetour).build().perform();
		driver.findElement(By.xpath("//span[@class='planner-icon z-button']/table/tbody/tr[2]/td[2]/img"));
		this.infoBulleRetour.getAttribute("title");
		Thread.sleep(2000);
		Assert.assertEquals("Cancel editing", infoBulleRetour.getAttribute("title"));
		this.boutonRetour.click();
	}
	
	public RetourPage retourPage(){
		return new RetourPage(driver);
	}
	
	public RetourPage2 retourPage2(){
		return new RetourPage2(driver);
	}

}
