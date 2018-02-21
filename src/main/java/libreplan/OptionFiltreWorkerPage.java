package libreplan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OptionFiltreWorkerPage extends WorkerPage{


	
	public OptionFiltreWorkerPage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
		this.champPeriodeActiveFrom = driver.findElement(By.id(prefixe+"i5-real"));
		this.champPeriodeActiveTo = driver.findElement(By.id(prefixe+"k5-real"));
		this.selectType = driver.findElement(By.id(prefixe+"m5"));
		
	}
	
	WebElement champPeriodeActiveFrom;
	WebElement champPeriodeActiveTo;
	WebElement selectType;
	
	public void listMenuDeroulantType(){
		Select menu = new Select(this.selectType);
		List<WebElement> options = menu.getOptions();
		menu.selectByVisibleText("All");
		menu.selectByVisibleText("Queue-based resource");
		menu.selectByVisibleText("Normal resource");		
}
	
	public OptionFiltreWorkerPage cliquerNext(){
		boutonNext.click();
		return new OptionFiltreWorkerPage(driver);
	}
	
	public OptionFiltreWorkerPage cliquerPrev(){
		boutonPrev.click();
		return new OptionFiltreWorkerPage(driver);
	}
	
	public OptionFiltreWorkerPage cliquerFirst(){
		boutonFirst.click();
		return new OptionFiltreWorkerPage(driver);
	}

	public OptionFiltreWorkerPage cliquerLast(){
		boutonLast.click();
		return new OptionFiltreWorkerPage(driver);
	}

}
