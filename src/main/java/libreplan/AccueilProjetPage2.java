package libreplan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccueilProjetPage2 extends MenuPage {
	
	public AccueilProjetPage2(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
	}
	
	String prefixe;
	
	public void projetDetail(){
		driver.findElement(By.id(prefixe+"ab")).click();
	}
	
	public ProjetPage projetPage(){
		return new ProjetPage(driver);
	}
	
	public void affichageOngletProjet(){
		driver.findElement(By.xpath("//div[@id='"+prefixe+"47-hm']/span")).isSelected();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"f4']/table/tbody/tr[2]/td[2]")).click();	
	}
	
	public PlanningPage planningPage(){
		return new PlanningPage(driver);
	}

}
