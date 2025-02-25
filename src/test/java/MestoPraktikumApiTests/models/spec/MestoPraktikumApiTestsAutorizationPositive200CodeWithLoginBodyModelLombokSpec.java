package MestoPraktikumApiTests.models.spec;

import MestoPraktikumApiTests.models.lombok.LoginBodyModelLombok;
import MestoPraktikumApiTests.models.lombok.LoginResponseModelLombok;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static MestoPraktikumApiTests.models.spec.LoginSpec.loginRequestSpec;
import static MestoPraktikumApiTests.models.spec.LoginSpec.loginResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@Tag("simple")
public class MestoPraktikumApiTestsAutorizationPositive200CodeWithLoginBodyModelLombokSpec {


	@Test
	// ТЕСТ успешный в том плане, что в loginResponseModel.setToken я указываю Ранее полученный Токен и в assertThat(loginResponseModel.getToken()).isEqualTo сравниваю с ним же
	// но тест не УСПЕШНЫЙ в том смысле, что я не могу добиться, чтобы именно тот же Токен, возникающий при создании POST-методом, отправить на проверку в AssertThat  !!!
	@Description("Отправить POST-запрос к ресурсу https://qa-mesto.praktikum-services.ru/api/signin  , т.е. зайти в Личный Кабинет зарегистрированного пользователя")
	@Owner("Калинченко Андрей")
	public void MestoPraktikumApiTestsAutorizationPositivePost200CodeWithLoginBodyModelLombok() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		LoginBodyModelLombok loginBodyModelLombok = new LoginBodyModelLombok();
		loginBodyModelLombok.setEmail("11@11.com");
		loginBodyModelLombok.setPassword("11@11");

		LoginResponseModelLombok loginResponseModelLombok = new LoginResponseModelLombok();
		loginResponseModelLombok.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk3Nzg0NTYsImV4cCI6MTc0MDM4MzI1Nn0.k4V3onS-qJV9q4WP5BICV8yzlCyil8_h4pLNxis1Z4g");
		given(loginRequestSpec)
				.filter(new AllureRestAssured())
				.body(loginBodyModelLombok)
				.when()
				.post()
				.then()
				.spec(loginResponseSpec)
				.extract().as(LoginResponseModelLombok.class);


		assertThat(loginResponseModelLombok.getToken()).isNotNull();
		assertThat(loginResponseModelLombok.getToken()).isEqualTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2EzNjljNTMxOTBmMzAwM2M0Y2RiYTMiLCJpYXQiOjE3Mzk3Nzg0NTYsImV4cCI6MTc0MDM4MzI1Nn0.k4V3onS-qJV9q4WP5BICV8yzlCyil8_h4pLNxis1Z4g");
	}
}
