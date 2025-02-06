package MestoPraktikumApiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class MestoPraktikumApiTestsAutorizationPositive200Code {


	@Test   // ТЕСТ УСПЕШНЫЙ !!!
	@Description("Отправить POST-запрос к ресурсу https://qa-mesto.praktikum-services.ru/api/signin  , т.е. зайти в Личный Кабинет зарегистрированного пользователя")
	@Owner("Калинченко Андрей")
	public void MestoPraktikumApiTestsAutorizationPositivePost200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		// Предполагаемые данные для авторизации
		String email = "11@11.com";
		String password = "11@11";

		given()
				.log().uri()
				.contentType(JSON)
				.body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
				.when()
				.post("https://qa-mesto.praktikum-services.ru/api/signin")
				.then()
				.log().status()
				.log().body()
				.statusCode(200);
	}

	@Test  // ТЕСТ УСПЕШНЫЙ !!!
	@Description("Отправить GET-запрос к ресурсу https://qa-mesto.praktikum-services.ru/api/users/me    , т.е. убедиться, что по email и password, введенным при регистрации, система пускает в Личный Кабинет зарегистрированного пользователя")
	@Owner("Калинченко Андрей")
	public void MestoPraktikumApiTestsAutorizationPositiveGet200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		given()
				.log().uri()
				.header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzg4NDcxMTQsImV4cCI6MTczOTQ1MTkxNH0.Ut8JhMWOJzwa1weYKUCcYMMFxtb1SGJMps70mDBYyWk")
				.contentType(JSON)
				.when()
				.get("https://qa-mesto.praktikum-services.ru/api/users/me")
				.then()
				.log().status()
				.log().body()
				.statusCode(200);
	}
}
