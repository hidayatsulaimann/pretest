package bukalapak.pretest;

import bukalapak.pretest.utils.DataUtility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {

	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri(DataUtility.getDataFromExcel("Config", "BaseUrlAPI")).setContentType(ContentType.JSON).build()
			.log().all();

}