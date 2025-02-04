package SaucedemoComTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SaucedemoComAddProductToCartAndCheckout {

	@Test
	@Description("Добавить Товар в Корзину на сайте и проверить, что Товар добавился")
	@Owner("Калинченко Андрей")


	public void SaucedemoComddProductToCartAndCheckoutPositive() {

		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1920x1080";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

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
		step("6 Шаг: положить товар в Корзину (кликнуть на товар, чтобы он оказался в Корзине)", () ->
		{
			$x(".//*[@id='add-to-cart-sauce-labs-backpack']").click();
		});
		step("7 Шаг:  Проверить, что товар в Корзине (в Корзине появилась надпись - цифра 1) и зайти в Корзину ", () ->
		{
			$x(".//*[@data-test='shopping-cart-badge']").shouldHave((text("1"))).click();
		});
		step("8 Шаг: Нажать на товар в Корзине и убедиться, что это именно тот товар, который мы положили в Корзину, и зайти в детализацию товара", () -> {
			$x(".//*[@class='inventory_item_name']").shouldHave(text("Sauce Labs Backpack")).click();
		});
		step("9 Шаг: Нажать в Корзине и убедиться, что это именно тот товар, который мы положили в Корзину", () -> {
			$x(".//*[@data-test='inventory-item-name']").shouldHave((text("Sauce Labs Backpack")));
		});
	}
}