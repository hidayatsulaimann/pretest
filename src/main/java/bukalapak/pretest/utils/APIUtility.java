package bukalapak.pretest.utils;

import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;

public class APIUtility {

	public static boolean verifyStatusCodeGet(Response response) {
		assertEquals(response.statusCode(), 200);
		return true;

	}

	public static boolean verifyStatusCodePost(Response response) {
		assertEquals(response.statusCode(), 201);
		return true;

	}

	public static <T> T getBodyDataUsingJsonPath(Response response, String jsonPath) {
		return response.jsonPath().get(jsonPath);

	}

}