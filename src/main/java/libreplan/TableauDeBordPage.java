package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableauDeBordPage {
protected final WebDriver driver;
	
	public TableauDeBordPage(WebDriver driver){
		super(); 
		this.driver = driver;	
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.titrePageDashboard = driver.findElement(By.id(prefixe+"f0-cap"));
	}

	
	
WebElement titrePageDashboard;

}
