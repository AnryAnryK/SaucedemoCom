package notWorking.DemowebshopApiTests.Sucessfull;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DemowebshopApiAddProduct {



@BeforeAll
	public static void DemowebshopApiAutorizationPositiveRestAssuredUrl() {
		RestAssured.baseURI = "https://demowebshop.tricentis.com/";
//		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//		authScheme.setUserName("11@11");
//		authScheme.setPassword("123456");
//		RestAssured.authentication = authScheme;
	}

	@Test   //  !! Тест УСПЕШНЫЙ !!
	@Description("Авторизоваться на сайте https://demowebshop.tricentis.com/login, положить товар в Корзину и проверить результат на корректность через Api")
	@Owner("Калинченко Андрей")

	public void DemowebshopApiAutorizationPositive200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		String cookie = "F37375B37C979012DD45E9A7F23665CD2C2769D3C9C64818DAA6E1" +
				"9B6072B0C6B74CA5D6CB531FA98F072EC16230905D8F7D89A1D47882A312084" +
				"6E7CD6CC2C295962B1581B493A6ABF4389B29376B55C2182F791BFD7022559F" +
				"57B4C4357335CD109A78937F9333147D82EC007D3002;";

		String bodyData = "product_attribute_72_5_18=53" +
				"&product_attribute_72_6_19=54" +
				"&product_attribute_72_3_20=57" +
				"&addtocart_72.EnteredQuantity=2";

		given()
//				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")  _ ИЛИ
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
//				.header("Cookie", "NOPCOMMERCE.AUTH=F37375B37C979012DD45E9A7F23665CD2C2769D3C9C64818DAA6E19B6072B0C6B74CA5D6CB531FA98F072EC16230905D8F7D89A1D47882A3120846E7CD6CC2C295962B1581B493A6ABF4389B29376B55C2182F791BFD7022559F57B4C4357335CD109A78937F9333147D82EC007D3002;")  _ ИЛИ
				.cookie("NOPCOMMERCE.AUTH", cookie)
				.body(bodyData)
				.when()
				.post("/addproducttocart/details/72/1")
//				.formParam("username", "11@11")
//				.formParam("password", 123456)
				.then()
				.log().status()
				.log().body()
				.statusCode(200);
	}

	@Test   //  !! Тест УСПЕШНЫЙ !!
	@Description("БЕЗ Авторизации на сайте https://demowebshop.tricentis.com/login положить товар в Корзину и проверить результат на корректность через Api")
	@Owner("Калинченко Андрей")

	public void DemowebshopApiNoAutorizationPositive200Code() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		String bodyData = "product_attribute_72_5_18=53" +
				"&product_attribute_72_6_19=54" +
				"&product_attribute_72_3_20=57" +
				"&addtocart_72.EnteredQuantity=2";

		given()
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.body(bodyData)
				.when()
				.post("/addproducttocart/details/72/1")
//				.formParam("username", "11@11")
//				.formParam("password", 123456)
				.then()
				.log().status()
				.log().body()
				.statusCode(200);
	}
}