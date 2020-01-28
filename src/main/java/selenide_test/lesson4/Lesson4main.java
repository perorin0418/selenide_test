package selenide_test.lesson4;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class Lesson4main {
	public static void main(String[] args) {

		// IEを使用
		Configuration.browser = WebDriverRunner.IE;

		// ※注意事項
		// ・IEのバージョンやOSによって設定の要否が変わる。いろいろ試しながらやるといい。
		// ・IEを使用する場合は、インターネットオプションで全てセキュリティゾーンで保護モードを同じにする。（有効or無効を揃える）
		// ・IEの32bit版、64bit版を切り替えてみる。
		// ・詰まる話、IEは面倒くさい。

		// 高速入力
		Configuration.fastSetValue = true;

		// レポート出力フォルダ設定
		Configuration.reportsFolder = "C:\\git\\selenide_test\\build\\reports";

		// 処理終了後にブラウザを終了しない
		Configuration.holdBrowserOpen = true;

		// ブラウザ起動して、Google画面を開く。
		GoogleSearchPage searchPage = open("https://www.google.co.jp/", GoogleSearchPage.class);

		// 検索
		GoogleResultPage resultPage = searchPage.search("selenide");

		// 検索結果選択
		resultPage.select("Selenide: concise UI tests in Java");
		SelenideHomePage selenideHomePage = page(SelenideHomePage.class);

		// 「What is Selenide?」という文言があるか確認
		if (ss(selenideHomePage.whatIsSelenide).exists()) {
			System.out.println("Success!!");
		} else {
			System.out.println("Failure!!");
		}
	}

	// スクリーンショット取得用関数作成
	public static SelenideElement ss(SelenideElement e) {

		// エレメントが表示されるまで最大10秒待機
		e.waitUntil(visible, 10000);

		// bodyエレメントのスクリーンショット取得
		$("body").screenshot();

		// エレメントを返却
		return e;
	}
}
