package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetourPage2 extends ProjetCree{

	public RetourPage2(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.fenetreRetour2 = driver.findElement(By.id(prefixe+"_5-cap"));
		this.textRetour2 = driver.findElement(By.id(prefixe+"g8"));
		this.boutonOKRetour2 = driver.findElement(By.xpath("//table[@id='"+prefixe+"65-box']/tbody/tr[2]/td[2]"));
		this.boutonCancelRetour2 = driver.findElement(By.xpath("//table[@id='"+prefixe+"i8-box']/tbody/tr[2]/td[2]"));
	}
	
	WebElement fenetreRetour2;
	WebElement textRetour2;
	WebElement boutonOKRetour2;
	WebElement boutonCancelRetour2;
	
	public void boutonRetour2(){
		this.fenetreRetour2.isDisplayed();
		this.textRetour2.getText();
		Assert.assertEquals("Unsaved changes will be lost. Are you sure?", textRetour2.getText());
		this.boutonOKRetour2.isDisplayed();
		this.boutonCancelRetour2.isDisplayed();
		this.boutonOKRetour2.click();
		this.menuVerticalProjectScheduling.isDisplayed();
	}
	
}
