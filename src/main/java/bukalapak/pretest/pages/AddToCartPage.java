package bukalapak.pretest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BasePage {

	// driver.findElement(By.xpath("//input[@value='true']")).click();

	By selectProduct = By.xpath(
			"//img[@alt='meja kursi tulis kantor kerja laptop jati - kursi tamu - meja belajar - lemari - bufet - nakas - furniture']");
	By addToCart = By.xpath("//div[@id='section-main-product']/div[2]/div[5]/div/button[2]");
	By seeCart = By
			.xpath("//div[@id='section-main-product']/div[2]/div[5]/div[2]/div/div/div/div[3]/div/div[2]/button");

	public AddToCartPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void addToCart() {
		clickAndWaitByXpath(selectProduct);
		clickAndWaitByXpath(addToCart);
		// clickAndWaitByXpath(seeCart);

	}

}
