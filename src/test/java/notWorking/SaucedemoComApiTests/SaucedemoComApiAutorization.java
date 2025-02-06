package notWorking.SaucedemoComApiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;

public class SaucedemoComApiAutorization {


	@Test
	@Description("Авторизоваться на сайте https://www.saucedemo.com, положить товар в Корзину и проверить результат на корректность через Api - ожидаемый код 405")
	@Owner("Калинченко Андрей")


	public void SaucedemoComApiAutorizationPositive405Code() {

		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		given()
				.log().uri()
				.contentType(JSON)
//				.body(data)
				.when()
				.post("https://www.saucedemo.com/inventory.html")
				.then()
				.log().status()
				.log().body()
				.statusCode(405);
	}

	@Test
	@Description ("Авторизоваться на сайте https://www.saucedemo.com, положить товар в Корзину и проверить результат на корректность через Api - ожидаемый код 200")
	public void SaucedemoComApiAutorizationPositive200Code() {

		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

//		String data = "{ \"Username\": \"standard_user\", \"Password\": \"secret_sauce\" }";

		given()
				.log().uri()
				.contentType(JSON)
//				.body(data)
				.when()
				.post("https://www.saucedemo.com/inventory.html")
				.then()
				.log().status()
				.log().body()
				.statusCode(200);  // не работает !!!
	}
}