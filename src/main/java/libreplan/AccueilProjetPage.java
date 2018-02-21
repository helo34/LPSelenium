package libreplan;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccueilProjetPage extends MenuPage {
	
	public AccueilProjetPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.nomProjet = driver.findElement(By.id(prefixe+"67"));
		this.menuVerticalProjectsList = driver.findElement(By.xpath("//span[@id='"+prefixe+"h4']/table/tbody/tr[2]/td[2]"));
		this.code = driver.findElement(By.id(prefixe+"77"));
		this.startinDate = driver.findElement(By.id(prefixe+"87"));
		this.deadline = driver.findElement(By.id(prefixe+"97"));
		this.customer = driver.findElement(By.id(prefixe+"a7-cell"));
		this.totalBudget = driver.findElement(By.id(prefixe+"b7-cell"));
		this.hours = driver.findElement(By.id(prefixe+"c7-cell"));
		this.state = driver.findElement(By.id(prefixe+"d7-cell"));
		this.boutonEdit = driver.findElement(By.xpath("//span[@id='"+prefixe+"f7']/table/tbody/tr[2]/td[2]"));
		this.boutonDelete = driver.findElement(By.xpath("//span[@id='"+prefixe+"g7']/table/tbody/tr[2]/td[2]"));
		this.boutonSeeScheduling = driver.findElement(By.xpath("//span[@id='"+prefixe+"h7']/table/tbody/tr[2]/td[2]"));
		this.boutonCreateTemplate = driver.findElement(By.xpath("//span[@id='"+prefixe+"i7']/table/tbody/tr[2]/td[2]"));
	}
	
	WebElement nomProjet;
	WebElement menuVerticalProjectsList;
	WebElement code;
	WebElement startinDate;
	WebElement deadline;
	WebElement customer;
	WebElement totalBudget;
	WebElement hours;
	WebElement state;
	WebElement boutonEdit;
	WebElement boutonDelete;
	WebElement boutonSeeScheduling;
	WebElement boutonCreateTemplate;
	
	public void verifierNomProjet(){
		this.nomProjet.isDisplayed();
		this.menuVerticalProjectsList.isSelected();
	}
	
	public void verifierParamProjet(String name, String code){
		this.nomProjet.getText().equals(name);
		this.code.getText().equals(code);
		this.startinDate.getText().equals(DateTime.now().plusDays(5));
		this.deadline.getText().equals(DateTime.now().plusDays(15));
		this.customer.getText().isEmpty();
		this.totalBudget.getText().contentEquals("0 €");
		this.hours.getText().contentEquals("0");
		this.state.getText().contentEquals("PRE-SALES");
		this.boutonEdit.isDisplayed();
		this.boutonDelete.isDisplayed();
		this.boutonSeeScheduling.isDisplayed();
		this.boutonCreateTemplate.isDisplayed();
	}
	
}
