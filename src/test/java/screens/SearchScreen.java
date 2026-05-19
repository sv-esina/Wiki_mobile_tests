package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class SearchScreen {
    public static String tag = System.getProperty("tag");

    private final SelenideElement
                        container = $(AppiumBy.id("org.wikipedia.alpha:id/dialogContainer")),
                        containerCloseButton = $(accessibilityId("Close")),
                        messageWiki = $(AppiumBy.id("android:id/message")),
                        closeMessageWiki = $(AppiumBy.id("android:id/button1")),
                        searchWikipedia = $(accessibilityId("Search Wikipedia")),
                        searchFiled = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")),
                        titleText = $(androidUIAutomator("new UiSelector().text(\"Appium\")")),
                        clearQuery = $(accessibilityId("Clear query")),
                        recentSearch = $(AppiumBy.id("org.wikipedia.alpha:id/list_title")),
                        searchPanelRecent = $(AppiumBy.id("org.wikipedia.alpha:id/search_panel_recent"));

    private final ElementsCollection
                        searchResult = $$(AppiumBy.id("org.wikipedia.alpha:id/fragment_search_results")),
                        firstSearchResult = $$(byClassName("android.view.View"));

    @Step("Закрыть начальный экран")
    public SearchScreen skipStartScreen() {
        back();
        return this;
    }

    @Step("Нажимаем на строку поиска Википедии")
    public SearchScreen searchClick() {
        searchWikipedia.click();
        return this;
    }

    @Step("Вводим искомое значение в поисковую строку")
    public SearchScreen enterSearchValue() {
        searchFiled.sendKeys(SEARCH_TOPIC);
        return this;
    }

    @Step("Проверяем результат поиска")
    public SearchScreen checkSearchResult() {
        searchResult.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Нажимаем на первый результат поиска")
    public SearchScreen clickFirstSearchResult() {
        firstSearchResult.first().click();
        return this;
    }

    @Step("Проверяем title страницы")
    public SearchScreen checkTitleFirstSearchResult() {
        if (messageWiki.is(visible)) {
            closeMessageWiki.click();}
        if (container.is(visible)) {
            containerCloseButton.click();}
        titleText.shouldHave(text(SEARCH_TOPIC));
        return this;
    }


    @Step("Очищаем результаты поиска")
    public SearchScreen clearSearchField() {
        clearQuery.click();
        return this;
    }

    @Step("Проверяем наличие строки предыдущего запроса")
    public SearchScreen checkRecentSearch() {
        if(tag.equals("local")){
            recentSearch.shouldHave(text(RECENT_SEARCHES));
            titleText.shouldHave(text(SEARCH_TOPIC));}
        else {searchPanelRecent.shouldBe(visible);}
        return this;
    }

}
