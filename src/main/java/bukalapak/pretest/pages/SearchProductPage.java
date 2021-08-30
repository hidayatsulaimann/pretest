package bukalapak.pretest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductPage extends BasePage {

	By search = By.id("v-omnisearch__input");
	By searchIcon = By.xpath(
			"//body[1]/div[1]/div[1]/section[1]/header[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/fragment-loader[1]/div[1]/div[2]/div[1]/button[1]");

	public SearchProductPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void search(String searchProduct) {
		setText(search, searchProduct);
		clickAndWaitByXpath(searchIcon);

	}

}
