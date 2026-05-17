package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;
import static io.appium.java_client.AppiumBy.*;

public class WikiSearchScreen {

    private final SelenideElement
                        searchWikipedia = $(accessibilityId("Search Wikipedia")),
                        searchFiled = $(id("org.wikipedia.alpha:id/search_src_text")),
                        errorIcon = $(id("org.wikipedia.alpha:id/view_wiki_error_icon")),
                        errorTextView = $(byClassName("android.widget.TextView"));

    private final ElementsCollection
                        searchResult = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
                        firstSearchResult = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Кликаем на строку поиска Википедии")
    public WikiSearchScreen searchClick() {
        searchWikipedia.click();
        return this;
    }

    @Step("Вводим искомое значение в поисковую строку")
    public WikiSearchScreen enterSearchValue() {
        searchFiled.sendKeys(SEARCH_TOPIC);
        return this;
    }

    @Step("Проверяем результат поиска")
    public WikiSearchScreen checkSearchResult() {
        searchResult.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Нажимаем на первый результат поиска")
    public WikiSearchScreen clickFirstSearchResult() {
        firstSearchResult.first().click();
        return this;
    }


    @Step("Проверяем отображение иконки ошибки на странице")
    public WikiSearchScreen checkErrorIcon() {
        errorIcon.should(exist);
        return this;

    }

    @Step("Проверяем текст ошибки на странице")
    public WikiSearchScreen checkErrorText() {
        errorTextView.shouldHave(text(ERROR_MESSAGE));
        return this;
    }

}
