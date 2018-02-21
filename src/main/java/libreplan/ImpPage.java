package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImpPage {
	
	public ImpPage(WebDriver driver) {
		super();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.impTitre = driver.findElement(By.id(prefixe+"x7-cap"));
		this.exportOpt = driver.findElement(By.id(prefixe+"z7-cnt"));
		this.showLabels = driver.findElement(By.xpath("//span[@id='"+prefixe+"08']/label"));
		this.showResource = driver.findElement(By.xpath("//span[@id='"+prefixe+"18']/label"));
		this.expandTaskgroups = driver.findElement(By.xpath("//span[@id='"+prefixe+"28']/label"));
		this.showProgress = driver.findElement(By.xpath("//span[@id='"+prefixe+"48']/label"));
		this.showAllReport = driver.findElement(By.xpath("//span[@id='"+prefixe+"58']/label"));
		this.showMoney = driver.findElement(By.xpath("//span[@id='"+prefixe+"68']/label"));
		this.showLabelsCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"08']/input"));
		this.showResourceCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"18']/input"));
		this.expandTaskgroupsCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"28']/input"));
		this.showProgressCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"48']/input"));
		this.showAllReportCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"58']/input"));
		this.showMoneyCheckBox = driver.findElement(By.xpath("//span[@id='"+prefixe+"68']/input"));
		this.message = driver.findElement(By.xpath("//span[@id='"+prefixe+"88']"));
		this.boutonPrint = driver.findElement(By.xpath("//span[@id='"+prefixe+"98']/table/tbody/tr[2]/td[2]"));
		this.boutonCancel = driver.findElement(By.xpath("//span[@id='"+prefixe+"a8']/table/tbody/tr[2]/td[2]"));
	}
	
	WebDriver driver;
	String prefixe;
	WebElement impTitre;
	WebElement exportOpt;
	WebElement showLabels;
	WebElement showResource;
	WebElement expandTaskgroups;
	WebElement showProgress;
	WebElement showAllReport;
	WebElement showMoney;
	WebElement showLabelsCheckBox;
	WebElement showResourceCheckBox;
	WebElement expandTaskgroupsCheckBox;
	WebElement showProgressCheckBox;
	WebElement showAllReportCheckBox;
	WebElement showMoneyCheckBox;
	WebElement message;
	WebElement boutonPrint;
	WebElement boutonCancel;
	
	public void verifierImp(){
		this.impTitre.isDisplayed();
		Assert.assertEquals("Print configuration", impTitre.getText());
		this.exportOpt.isDisplayed();
		Assert.assertEquals("Export options", exportOpt.getText());
		this.showLabelsCheckBox.isSelected();
		this.showLabels.isDisplayed();
		Assert.assertEquals("Show labels", showLabels.getText());
		this.showResourceCheckBox.isSelected();
		this.showResource.isDisplayed();
		Assert.assertEquals("Show resource assignments", showResource.getText());
		this.expandTaskgroupsCheckBox.isSelected();
		this.expandTaskgroups.isDisplayed();
		Assert.assertEquals("Expand taskgroups", expandTaskgroups.getText());
		this.showProgressCheckBox.isSelected();
		this.showProgress.isDisplayed();
		Assert.assertEquals("Show progress", showProgress.getText());
		this.showAllReportCheckBox.isSelected();
		this.showAllReport.isDisplayed();
		Assert.assertEquals("Show all reported hours", showAllReport.getText());
		this.showMoneyCheckBox.isSelected();
		this.showMoney.isDisplayed();
		Assert.assertEquals("Show money cost bar", showMoney.getText());
		this.message.isDisplayed();
		Assert.assertEquals("Please remember that only saved changes will be printed", message.getText());
		this.boutonPrint.isDisplayed();
		this.boutonCancel.isDisplayed();
		this.boutonCancel.click();
	}

}
