package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TachesPage{
	
	public TachesPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.flecheDesc = driver.findElement(By.xpath("//span[@id='"+prefixe+"95']/table/tbody/tr[2]/td[2]/img"));
	}
	
	WebDriver driver;
	String prefixe;
	WebElement flecheDesc;
	
	public void modifierOrdre(){
		driver.findElement(By.id(prefixe+"kk-cave")).click();
		this.flecheDesc.click();
	}
	
	public TachesPage2 tachesPage2(){
		return new TachesPage2(driver);
	}
	
}
