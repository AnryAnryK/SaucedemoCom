package notWorking.ParabankParasoftCom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.authentication.FormAuthConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ParabankParasoftComApiTestAutorization {

	@Test   // всегда положительно !! Тест провальный

	@Description("Авторизоваться на сайте https://www.parabank.com.ua/ru/personal/login, проверить результат на корректность через Api - ожидаемый код 200")
	@Owner("Калинченко Андрей")

	public void ParabankParasoftComApiAutorizationPositive200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		String data = "{ \"username:\": \"1@1\", \"password\": \"12345\" }";

		given()
//				.auth()
//				.form("1@1", "12345", new FormAuthConfig("https://parabank.parasoft.com/parabank/login.htm", "username", "password"))
//				.baseUri("https://parabank.parasoft.com/parabank/login.htm")
				.log().uri()
				.contentType(JSON)
//				.body(data)
				.when()
//				.formParam("username", "1@1")
//				.formParam("password", 12345)
//				.post("https://parabank.parasoft.com/parabank/login.htm")
				.get("https://parabank.parasoft.com/parabank/overview.htm")
				.prettyPeek()
				.then()
				.log().status()
				.log().body();
//				.statusCode(200);

	}
}
