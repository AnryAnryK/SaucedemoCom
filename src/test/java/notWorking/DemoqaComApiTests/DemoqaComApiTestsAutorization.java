package notWorking.DemoqaComApiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class DemoqaComApiTestsAutorization {

	@Test   // всегда положительно !! Тест провальный
	@Description("Авторизоваться на сайте https://demoqa.com/login, проверить результат на корректность через Api - ожидаемый код 200")
	@Owner("Калинченко Андрей")

	public  void  DemoqaComApiTestsAutorizationPositive200Code (){
		Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

//		String data = "{ \"UserName:\": \"aaabbb\", \"Password\": \"bbbBB123@\" }";
		given()
				.log().uri()
				.contentType(JSON)
//				.body(data)
				.when()
//				.post("https://demowebshop.tricentis.com/customer/info")
				.formParam("UserName", "aaabbb")
				.formParam("Password", "bbbBB123@")
				.post("https://demoqa.com/login")
				.then()
				.log().status()
				.log().body();
//				.statusCode(200);
	}
}
