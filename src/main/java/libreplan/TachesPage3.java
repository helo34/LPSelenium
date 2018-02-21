package libreplan;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TachesPage3 {
	
	public TachesPage3(WebDriver driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		prefixe = idElement.substring(0, 4);
		this.sauvegarde = driver.findElement(By.xpath("//span[@id='"+prefixe+"r5']/table/tbody/tr[2]/td[2]/img"));
	}
	
	WebDriver driver;
	String prefixe;
	WebElement sauvegarde;
	
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
	
	public String datePlus5Jours(int days){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(5+days);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public String datePlus15Jours(int days){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(15+days);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public void infoTache(String code1, String code2, String code3, String code4, int date1, int date2, int date3, int date4){
		driver.findElement(By.id(prefixe+"ia")).sendKeys(code1);
		driver.findElement(By.id(prefixe+"6a")).sendKeys(code2);
		driver.findElement(By.id(prefixe+"6i")).sendKeys(code3);
		driver.findElement(By.id(prefixe+"2k")).sendKeys(code4);
		driver.findElement(By.id(prefixe+"la")).sendKeys(datePlus5Jours(date1));
		driver.findElement(By.id(prefixe+"cg")).sendKeys(datePlus5Jours(date2));
		driver.findElement(By.id(prefixe+"lj")).getText().isEmpty();
		driver.findElement(By.id(prefixe+"hk")).getText().isEmpty();
		driver.findElement(By.id(prefixe+"dj")).getText().isEmpty();
		driver.findElement(By.id(prefixe+"uh")).getText().isEmpty();
		driver.findElement(By.id(prefixe+"qj")).sendKeys(datePlus15Jours(date3));
		driver.findElement(By.id(prefixe+"sq")).sendKeys(datePlus15Jours(date4));
		this.sauvegarde.isDisplayed();
		this.sauvegarde.click();
		driver.findElement(By.id(prefixe+"sx")).isDisplayed();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"ly']/table/tbody/tr[2]/td[2]")).isDisplayed();
		driver.findElement(By.id(prefixe+"nw-close")).isDisplayed();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"ly']/table/tbody/tr[2]/td[2]")).click();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"f4']/table/tbody/tr[2]/td[2]")).isDisplayed();
		driver.findElement(By.xpath("//span[@id='"+prefixe+"f4']/table/tbody/tr[2]/td[2]")).click();
	}
	
	public void barresApparentes(){
		driver.findElement(By.id(prefixe+"_c")).isDisplayed();
		driver.findElement(By.id(prefixe+"kc")).isDisplayed();
		driver.findElement(By.id(prefixe+"yc")).isDisplayed();
		driver.findElement(By.id("deadline"+prefixe+"xc")).isDisplayed();
		driver.findElement(By.id(prefixe+"bd")).isDisplayed();
		driver.findElement(By.id("deadline"+prefixe+"ad")).isDisplayed();
	}

}
