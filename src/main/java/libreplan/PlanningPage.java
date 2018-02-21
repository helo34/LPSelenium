package libreplan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanningPage {
	
	public PlanningPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.gantt = driver.findElement(By.id("ganttpanel"));
		this.menuDeroulantZoom = driver.findElement(By.id(prefixe+"p9"));
		this.menuDeroulantZoomAnnee = driver.findElement(By.id(prefixe+"q9"));
		this.menuDeroulantZoomQuarter = driver.findElement(By.id(prefixe+"qa"));
		this.menuDeroulantZoomMonth = driver.findElement(By.id(prefixe+"ra"));
	}
	
	WebDriver driver;
	String prefixe;
	WebElement gantt;
	WebElement menuDeroulantZoom;
	WebElement menuDeroulantZoomAnnee;
	WebElement menuDeroulantZoomQuarter;
	WebElement menuDeroulantZoomMonth;
	
	public void verifierPlanningPage(){
		this.gantt.isDisplayed();
		this.menuDeroulantZoom.isDisplayed();
		this.menuDeroulantZoom.click();
		this.menuDeroulantZoomAnnee.click();
	}
	
	public int parcoursTableauAnnee(String nomColonne){
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		List<WebElement> elements = driver.findElements(By.id(prefixe+"7b-real"));
		for(WebElement e : elements){
			List<WebElement> cases = e.findElements(By.xpath("td"));
			if(cases.size() > 1 && nomColonne.equals(cases.get(0).getText())){
				numeroDeLigne = ligneCourante;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}
	
	public void verifierPlanningPageQuarter(){
		this.menuDeroulantZoom.click();
		this.menuDeroulantZoomQuarter.click();
	}
	
	public int parcoursTableauQuarter(String nomColonne){
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		List<WebElement> elements = driver.findElements(By.id(prefixe+"7b-real"));
		for(WebElement e : elements){
			List<WebElement> cases = e.findElements(By.xpath("td"));
			if(cases.size() > 1 && nomColonne.equals(cases.get(0).getText())){
				numeroDeLigne = ligneCourante;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}
	
	public void verifierPlanningPageMonth(){
		this.menuDeroulantZoom.click();
		this.menuDeroulantZoomMonth.click();
	}
	
	public int parcoursTableauMonthYear(String nomColonneSup){
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		List<WebElement> elements = driver.findElements(By.id(prefixe+"7b-real"));
		for(WebElement e : elements){
			List<WebElement> cases = e.findElements(By.xpath("div"));
			if(cases.size() > 1 && nomColonneSup.equals(cases.get(0).getText())){
				numeroDeLigne = ligneCourante;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}
	
	public int parcoursTableauMonth(String nomColonne){
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		List<WebElement> elements = driver.findElements(By.id(prefixe+"7b-real"));
		for(WebElement e : elements){
			List<WebElement> cases = e.findElements(By.xpath("td"));
			if(cases.size() > 1 && nomColonne.equals(cases.get(0).getText())){
				numeroDeLigne = ligneCourante;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}

}
