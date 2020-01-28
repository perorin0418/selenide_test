package selenide_test.lesson4;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

public class GoogleSearchPage {

	// 検索欄
	public SelenideElement searchBox = $("input[name='q']");

	/**
	 * 検索処理
	 *
	 * @param query 検索条件
	 * @return 検索結果ページ
	 */
	public GoogleResultPage search(String query) {
		Lesson4main.ss(searchBox.waitUntil(visible, 10000).val(query)).pressEnter();
		return page(GoogleResultPage.class);
	}
}
