package libreplan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import libreplanException.TestException;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class ProgressTypePage extends MenuPage{


	public ProgressTypePage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.boutonCreer = driver.findElement(By.xpath("//table[@id='"+prefixe+"r4-box']/tbody/tr[2]/td[@class='z-button-cm']"));
		this.headerProgressTypeListTab = driver.findElements(By.xpath("//div[@id='"+prefixe+"k4-head']/table/tbody/tr"));
		this.ProgressTypeListTab = driver.findElements(By.xpath("//div[@id='"+prefixe+"k4-body']/table/tbody[2]/tr"));
	}
	
	
	WebElement boutonCreer;
	List<WebElement> headerProgressTypeListTab;
	List<WebElement> ProgressTypeListTab;
	WebElement checkBox1;
	WebElement checkBox2;
	String prefixe;
	WebElement boutonModif;
	WebElement boutonSupp;
	
	public CreationProgressTypePage accesFormulaireProgressType(){
		boutonCreer.click();
	return new CreationProgressTypePage (driver);
	}

	public int parcourTableauProgressTypeList(String nomDuColonne1, String nomDuColonne2, String nomDuColonne3, String nomDuColonne4){
		int numeroDeLigne = 1;
		List<WebElement>lignes = headerProgressTypeListTab;
		for(WebElement ligne : lignes){
		List<WebElement> cases = ligne.findElements(By.xpath("./th/div"));
		if(nomDuColonne1.equals(cases.get(0).getText()) && nomDuColonne2.equals(cases.get(1).getText()) && nomDuColonne3.equals(cases.get(2).getText()) && nomDuColonne4.equals(cases.get(3).getText())){
			return numeroDeLigne;
		}	
		numeroDeLigne = numeroDeLigne +1;
	}
	
		return -1;
	}
	
	public void verifTableauProgressTypeList(){
		int resultat = parcourTableauProgressTypeList("Name", "Enabled", "Predefined", "Operations");
		assertNotEquals(resultat, -1);
	}

	public int parcourTableauProgressTypeList2(String nomProgressType){
		int numeroDeLigne = 1;
		List<WebElement>lignes = ProgressTypeListTab;
		for(WebElement ligne : lignes){
		List<WebElement> cases = ligne.findElements(By.xpath("./td/div/span"));
		if(nomProgressType.equals(cases.get(0).getText())){
			return numeroDeLigne;
		}	
		numeroDeLigne = numeroDeLigne +1;
	}
	
		return -1;
	}
	
	public void verifTableauProgressTypeList2(){
		int resultat = parcourTableauProgressTypeList2("Type avancement - Test 2");
		assertNotEquals(resultat, -1);
	}
		

	public void verifTableauApresCreation(){
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.checkBox1 = driver.findElement(By.xpath("//div[@id='"+prefixe+"k4-body']/table/tbody[2]/tr[6]/td[2]/div/span/input"));
		this.checkBox2 = driver.findElement(By.xpath("//div[@id='"+prefixe+"k4-body']/table/tbody[2]/tr[6]/td[3]/div/span/input"));
		String contenu1 = checkBox1.getAttribute("checked");
		String contenu2 = checkBox2.getAttribute("disabled");
		assertEquals("true", contenu1);
		assertEquals("true", contenu2);
		this.boutonModif = driver.findElement(By.xpath("//div[@id='"+prefixe+"k4-body']/table/tbody[2]/tr[6]/td[4]//span[@title='Edit']"));
		this.boutonSupp = driver.findElement(By.xpath("//div[@id='"+prefixe+"k4-body']/table/tbody[2]/tr[6]/td[4]//span[@title='Remove']"));	
	}
	
}

