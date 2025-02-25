package SaucedemoComTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SaucedemoComAutorization {

	@Test
	@Description("Авторизоваться на сайте")
	@Owner("Калинченко Андрей")


	public void SaucedemoComAutorizationPositive() {

		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
		Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; // это - для запуска теста на Selenoid (учебный стенд !)

		step("1 Шаг: Зайти на сайт https://www.saucedemo.com/", () ->
		{
			open("https://www.saucedemo.com/");
		});
		step("2 Шаг: Ввести Username", () ->
		{
			$x(".//*[@id='user-name']").setValue("standard_user");
		});
		step("3 Шаг: ввести Password", () ->
		{
			$x(".//*[@id='password']").setValue("secret_sauce");
		});
		step("4 Шаг: нажать кнопку Login", () ->
		{
			$x(".//*[@id='login-button']").click();
		});
		step("5 Шаг: убрать всплывающее окно (кликнуть в свободное место)", () ->
		{
			$x(".//*[@class='page_wrapper']").click();
		});
	}
}