package notWorking.DemowebshopApiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class DemowebshopApiAutorization {


	@Test   //  !! Тест провальный
	@Description("Авторизоваться на сайте https://demowebshop.tricentis.com/login, положить товар в Корзину и проверить результат на корректность через Api")
	@Owner("Калинченко Андрей")

	public void DemowebshopApiAutorizationPositive200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

//		String data = "{ \"Email:\": \"11@11.com\", \"Password\": \"123456\" }";
		given()
				.log().uri()
				.contentType(JSON)
//				.body(data)
				.when()
//				.post("https://demowebshop.tricentis.com/customer/info")
				.formParam("username", "11@11")
				.formParam("password", 123456)
				.post("https://demowebshop.tricentis.com/login")
				.then()
				.log().status()
				.log().body();
//				.statusCode(200);
	}

	@Test   // всегда положительно !! Тест провальный

	public void DemowebshopApiAutorizationPositiveRestAssured() {
		RestAssured.baseURI = System.getProperty("https://demowebshop.tricentis.com/");
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("11@11");
		authScheme.setPassword("123456");
		RestAssured.authentication = authScheme;
	}
}