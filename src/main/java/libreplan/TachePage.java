package libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TachePage extends ProjetPage {
	
	public TachePage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.boutonUnschedule = driver.findElement(By.xpath("//span[@title='Unschedule']/table/tbody/tr[2]/td[2]/img"));
		this.code = driver.findElement(By.id(prefixe+"19"));
	}
	
	String prefixe;
	WebElement boutonUnschedule;
	WebElement code;
	
	public void verifierNewTache(String name, String hour) throws Exception{
		Actions moveOver = new Actions(driver);
		moveOver.moveToElement(driver.findElement(By.id(prefixe+"h7"))).build().perform();
		driver.findElement(By.id(prefixe+"h7"));
		Thread.sleep(2000);
		Assert.assertEquals(name+".  Progress:0.", driver.findElement(By.id(prefixe+"h7")).getAttribute("title"));
		Actions moveOver2 = new Actions(driver);
		moveOver2.moveToElement(driver.findElement(By.id(prefixe+"68"))).build().perform();
		driver.findElement(By.id(prefixe+"68"));
		Thread.sleep(2000);
		Assert.assertEquals("Unschedule", driver.findElement(By.id(prefixe+"68")).getAttribute("title"));
		this.boutonUnschedule.isDisplayed();
		this.code.getText().isEmpty();
		driver.findElement(By.id(prefixe+"n9")).getText().equals(name);
		driver.findElement(By.id(prefixe+"p9")).getText().equals(hour);
		Assert.assertEquals("0 €", driver.findElement(By.id(prefixe+"pa")).getAttribute("value"));
		driver.findElement(By.id(prefixe+"u9")).getTagName().isEmpty();
		driver.findElement(By.id(prefixe+"wa")).getText().isEmpty();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"xa']/table/tbody/tr[2]/td[2]/img")).isDisplayed();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"ya']/table/tbody/tr[2]/td[2]/img")).isDisplayed();
	}
	
	public void creationTache(String nomTache, String hour){
		this.champNewTask.sendKeys(nomTache);
		this.hours.clear();
		this.hours.sendKeys(hour);
		this.boutonAdd.click();
	}
	
	public TachesPage tachesPage(){
		return new TachesPage(driver);
	}
	
}
