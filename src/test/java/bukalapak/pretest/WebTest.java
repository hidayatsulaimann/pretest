package bukalapak.pretest;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import bukalapak.pretest.pages.AddToCartPage;
import bukalapak.pretest.pages.LoginPage;
import bukalapak.pretest.pages.RegisterPage;
import bukalapak.pretest.pages.SearchProductPage;
import bukalapak.pretest.utils.DataUtility;

public class WebTest extends BaseWebTest {

	RegisterPage registerPage = new RegisterPage(driver, explicitWait);
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	SearchProductPage searchProductPage = new SearchProductPage(driver, explicitWait);
	AddToCartPage addToCartPage = new AddToCartPage(driver, explicitWait);

	@Test(testName = "Verify Register New User", description = "Verify user able to register new user account")
	public void test001() {

		// create email random
		Faker fake = new Faker();
		String email = (fake.name().username() + "@gmail.com");

		registerPage.register(email);
	}

	@Test(testName = "Verify Login", description = "Verify that for correct credentials, login is working fine")
	public void test002() {
		String user = DataUtility.getDataFromExcel("TestData", "username");
		String password = DataUtility.getDataFromExcel("TestData", "password");

		loginPage.login(user, password);
		// String actualUser = profilePage.getProfileText(user);

		// assertEquals(actualUser, user);
		// TestUtility.hardWait(2);
	}

	@Test(testName = "Verify Search Product", description = "Verify system can search products correctly")
	public void test003() {
		String searchProduct = DataUtility.getDataFromExcel("TestData", "product");

		searchProductPage.search(searchProduct);

	}

	@Test(testName = "Verify Add To Cart", description = "Verify able add to cart")
	public void test004() {
		String searchProduct = DataUtility.getDataFromExcel("TestData", "product");

		searchProductPage.search(searchProduct);
		addToCartPage.addToCart();

	}

}