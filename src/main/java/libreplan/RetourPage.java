package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetourPage extends ProjetCree{

	public RetourPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.fenetreRetour = driver.findElement(By.id(prefixe+"r4-cap"));
		this.textRetour = driver.findElement(By.id(prefixe+"v4"));
		this.boutonOKRetour = driver.findElement(By.xpath("//table[@id='"+prefixe+"y4-box']/tbody/tr[2]/td[2]"));
		this.boutonCancelRetour = driver.findElement(By.xpath("//table[@id='"+prefixe+"z4-box']/tbody/tr[2]/td[2]"));
	}

	WebElement fenetreRetour;
	WebElement textRetour;
	WebElement boutonOKRetour;
	WebElement boutonCancelRetour;
	
	public void boutonRetour() throws Exception{
		this.fenetreRetour.isDisplayed();
		this.textRetour.getText();
		Assert.assertEquals("Unsaved changes will be lost. Are you sure?", textRetour.getText());
		this.boutonOKRetour.isDisplayed();
		this.boutonCancelRetour.isDisplayed();
		this.boutonCancelRetour.click();
		this.menuVerticalProjectDetails.isDisplayed();
		this.ongletWBStasks.isDisplayed();
		Thread.sleep(1000);
		this.boutonRetour.click();
	}
	
}
