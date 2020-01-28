package selenide_test.lesson1;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Lesson1main {
	public static void main(String[] args) {

		// ブラウザ起動して、Google画面を開く。
		Selenide.open("https://www.google.co.jp/");

		// $メソッドでエレメントを取得。
		SelenideElement searchInputBox = Selenide.$("input[type=text]");

		// インプットに対して値を入力する。
		searchInputBox.val("selenide");

		// Enterキーを入力
		searchInputBox.pressEnter();

		// Selenideホームページの検索結果を取得
		SelenideElement searchResult = Selenide.$(Selectors.byText("Selenide: concise UI tests in Java"));

		// Enterキーを入力
		searchResult.click();

		// エレメント取得
		SelenideElement whatIsSelenide = Selenide.$(Selectors.byText("What is Selenide?"));

		// 「What is Selenide?」という文言があるか確認
		if (whatIsSelenide.exists()) {
			System.out.println("Success!!");
		} else {
			System.out.println("Failure!!");
		}
	}
}
