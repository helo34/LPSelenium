package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreationWorkerPage extends MenuPage {

	public CreationWorkerPage(WebDriver driver) {
		super(driver);
		String idElement = driver.findElement(By.xpath("//div[1]")).getAttribute("id");
		String prefixe = idElement.substring(0, 4);
	}

}
