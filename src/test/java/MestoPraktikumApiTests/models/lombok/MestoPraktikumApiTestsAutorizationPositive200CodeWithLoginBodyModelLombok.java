package MestoPraktikumApiTests.models.lombok;

import MestoPraktikumApiTests.models.pojo.LoginBodyModelPojo;
import MestoPraktikumApiTests.models.pojo.LoginResponseModelPojo;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;


public class MestoPraktikumApiTestsAutorizationPositive200CodeWithLoginBodyModelLombok {


	@Test
	// ТЕСТ успешный в том плане, что в loginResponseModel.setToken я указываю Ранее полученный Токен и в assertThat(loginResponseModel.getToken()).isEqualTo сравниваю с ним же
	// но тест не УСПЕШНЫЙ в том смысле, что я не могу добиться, чтобы именно тот же Токен, возникающий при создании POST-методом, отправить на проверку в AssertThat  !!!
	@Description("Отправить POST-запрос к ресурсу https://qa-mesto.praktikum-services.ru/api/signin  , т.е. зайти в Личный Кабинет зарегистрированного пользователя")
	@Owner("Калинченко Андрей")
	public void MestoPraktikumApiTestsAutorizationPositivePost200CodeWithLoginBodyModelLombok() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		LoginBodyModelLombok loginBodyModelLombok = new LoginBodyModelLombok(); // ("11@11.com", "11@11");  // так работает с аннотацией @Builder в package MestoPraktikumApiTests.models.lombok
		loginBodyModelLombok.setEmail("11@11.com");  // так работает БЕЗ аннотации @Builder в package MestoPraktikumApiTests.models.lombok
		loginBodyModelLombok.setPassword("11@11");   // так работает БЕЗ аннотации @Builder в package MestoPraktikumApiTests.models.lombok

		// ранее было:
//		String email = "11@11.com";
//		String password = "11@11";
//		String data = "{\"email\": \"11@11.com\", \"password\": \"11@11\"}";

		// Предполагаемый токен (ранее полученный в POST-запросе)
		//	String data = "{\"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk3Nzg0NTYsImV4cCI6MTc0MDM4MzI1Nn0.k4V3onS-qJV9q4WP5BICV8yzlCyil8_h4pLNxis1Z4g\"}";

		LoginResponseModelLombok loginResponseModelLombok = new LoginResponseModelLombok();
		loginResponseModelLombok.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk3Nzg0NTYsImV4cCI6MTc0MDM4MzI1Nn0.k4V3onS-qJV9q4WP5BICV8yzlCyil8_h4pLNxis1Z4g");
		given()
				.filter(new AllureRestAssured())
				.log().uri()
				.log().body()
				.contentType(JSON)
//				.body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
				.body(loginBodyModelLombok)
				.when()
				.post("https://qa-mesto.praktikum-services.ru/api/signin")
				.then()
				.log().status()
				.log().body()
				.statusCode(200)
				.extract().as(LoginResponseModelLombok.class);

//	 loginBodyModelLombok = LoginBodyModelLombok.builder().email("11@11.com").password("11@12").build();

		assertThat(loginResponseModelLombok.getToken()).isEqualTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk3Nzg0NTYsImV4cCI6MTc0MDM4MzI1Nn0.k4V3onS-qJV9q4WP5BICV8yzlCyil8_h4pLNxis1Z4g");

	}

	@Test  // ТЕСТ _____
	@Description("Отправить GET-запрос к ресурсу https://qa-mesto.praktikum-services.ru/api/users/me    , т.е. убедиться, что по email и password, введенным при регистрации, система пускает в Личный Кабинет зарегистрированного пользователя")
	@Owner("Калинченко Андрей")
	public void MestoPraktikumApiTestsAutorizationPositiveGet200CodeWithLoginBodyModel() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


		given()
				.log().uri()
				.log().body()
				.header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk1MzQ4NTcsImV4cCI6MTc0MDEzOTY1N30.ojV04IrUR69w1cg0eNU9a0044ZXTob0is1Ubl0kxviw")
				.contentType(JSON)
				.when()
				.get("https://qa-mesto.praktikum-services.ru/api/users/me")
				.then()
				.log().status()
				.log().body()
				.statusCode(200)
				.body("data.name", is("Жак-Ив Кусто"));
	}
}
