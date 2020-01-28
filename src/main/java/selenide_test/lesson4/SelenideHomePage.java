package selenide_test.lesson4;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class SelenideHomePage {

	// 「What is Selenide?」という文言
	public SelenideElement whatIsSelenide = $(byText("What is Selenide?"));

}
