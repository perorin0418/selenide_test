package selenide_test.lesson4;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

import java.util.stream.Collectors;

import com.codeborne.selenide.ElementsCollection;

public class GoogleResultPage {

	// 検索結果
	public ElementsCollection results = $$(
			$(cssSelector("#rso div.srg")).findAll(cssSelector("div.r h3"))
					.stream()
					.map(it -> it.parent())
					//					.map(it -> {
					//						System.out.println(it);
					//						return it;
					//					})
					.collect(Collectors.toList()));

	/**
	 * 検索結果から選択
	 *
	 * @param result 検索結果
	 */
	public void select(String result) {
		results.stream()
				.filter(it -> it.find(byText(result)).exists())
				.map(it -> Lesson4main.ss(it))
				.findFirst().get()
				.click();
	}
}
