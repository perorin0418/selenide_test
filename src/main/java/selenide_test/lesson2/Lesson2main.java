package selenide_test.lesson2;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson2main {
	public static void main(String[] args) {

		// ブラウザ起動して、Google画面を開く。
		open("https://www.google.co.jp/");

		// 検索欄に入力して、Enterキー押下。
		$("input[type=text]").val("selenide").pressEnter();

		// Selenideホームページの検索結果をクリック
		$(byText("Selenide: concise UI tests in Java")).click();

		// 「What is Selenide?」という文言があるか確認
		if ($(byText("What is Selenide?")).exists()) {
			System.out.println("Success!!");
		} else {
			System.out.println("Failure!!");
		}
	}
}
