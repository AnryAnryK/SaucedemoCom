package MestoPraktikumApiTests.models.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//import static MestoPraktikumApiTests.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class LoginSpec {
	public static RequestSpecification loginRequestSpec = with()
//            .filter(withCustomTemplates())
			.log().uri()
			.log().body()
			.contentType(JSON)
			.baseUri("https://qa-mesto.praktikum-services.ru")
			.basePath("/api/signin");

	public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
			.log(STATUS)
			.log(BODY)
			.expectStatusCode(200)
			.expectBody("token", notNullValue())
			.build();
}
