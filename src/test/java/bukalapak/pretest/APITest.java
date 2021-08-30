package bukalapak.pretest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.annotations.Test;

import bukalapak.pretest.apis.APIEndpoints;
import bukalapak.pretest.utils.APIUtility;
import bukalapak.pretest.utils.DataUtility;
import io.restassured.response.Response;

public class APITest extends BaseAPITest {

	@Test(testName = "Verify Data Type from https://jsonplaceholder.cypress.io/posts", description = "Verify the response data type are correct - https://jsonplaceholder.cypress.io/posts (possible error due to too much data)")
	public void verifyDataType() {

		Response response = given().spec(commonJsonSpec).when().get(APIEndpoints.test);
		// System.out.println(response.getBody().asString());

		APIUtility.verifyStatusCodeGet(response);

		response.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "APISchema")));

	}

	@Test(testName = "Verify Data Type from https://reqbin.com/echo/get/json", description = "Verify the response data type are correct - https://reqbin.com/echo/get/json")
	public void verifyDataTypeSample() {

		Response response = given().spec(commonJsonSpec).when().get("https://reqbin.com/echo/get/json");
		// System.out.println(response.getBody().asString());

		APIUtility.verifyStatusCodeGet(response);

		response.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "APISchema_1")));

	}

	@Test(testName = "Verify Response", description = "Verify the data response is correct")
	public void verifyResponse() {

		String Payload = DataUtility.getDataFromExcel("Payloads", "Payload");

		Response response = given().spec(commonJsonSpec).body(Payload).when().post(APIEndpoints.test);
		APIUtility.verifyStatusCodePost(response);

	}

}