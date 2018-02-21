package libreplan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TachesPage2 {
	
	public TachesPage2(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.flecheMont = driver.findElement(By.xpath("//span[@id='"+prefixe+"b5']/table/tbody/tr[2]/td[2]/img"));
	}
	
	WebDriver driver;
	String prefixe;
	WebElement flecheMont;
	
	public int parcoursTableau(String name){
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		List<WebElement> elements = driver.findElements(By.id(prefixe+"k6"));
		for(WebElement e : elements){
			List<WebElement> cases = e.findElements(By.xpath("input"));
			if(cases.size() > 1 && name.equals(cases.get(2).getAttribute("value"))){
				numeroDeLigne = ligneCourante;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}
	
	public boolean compare(String name, String name2){
		int i = parcoursTableau(name);
		int j = parcoursTableau(name2);
		return i>j;
	}
	
	public void modifierOrdre(){
		driver.findElement(By.id(prefixe+"58-cave")).click();
		this.flecheMont.click();
	}
	
	public TachesPage3 tachesPage3(){
		return new TachesPage3(driver);
	}

}
