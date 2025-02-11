package notWorking.DemowebshopApiTests.Sucessfull;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class DemowebshopApiLightOpeningSite {


	@Test   //  !! Тест УСПЕШНЫЙ !
	@Description("Авторизоваться на сайте https://demowebshop.tricentis.com, использовав в качестве end-поинта легко 'весящий' логотип сайта https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png")
	@Owner("Калинченко Андрей")

	public void DemowebshopApiLightOpeningSitePositive() {
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		step("1 Шаг: Зайти на сайте https://demowebshop.tricentis.com, использовав в качестве end-поинта легко 'весящий' логотип сайта https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png", () ->
		{
			open("https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
		});

		step("2 Шаг: Авторизоваться на сайте https://demowebshop.tricentis.com, использовав в качестве end-поинта легко 'весящий' логотип сайта https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png", () ->
		{
			open("https://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
		});
	}
}