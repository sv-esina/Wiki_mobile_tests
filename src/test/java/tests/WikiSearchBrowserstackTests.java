package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.LanguageScreen;
import screens.SearchScreen;
import screens.SettingsScreen;

@Owner("Esina Svetlana")
@DisplayName("Тестирование приложения Wikipedia удаленно, используя Browserstack")
public class WikiSearchBrowserstackTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();
    LanguageScreen languageScreen = new LanguageScreen();
    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Выводить список результатов по запросу")
    @DisplayName("Успешное отображение результатов поиска")
    public void successfulWikiSearchTest() {
        searchScreen.skipStartScreen()
                .searchClick()
                .enterSearchValue()
                .checkSearchResult();
    }

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Выводить список результатов по запросу")
    @DisplayName("Успешный переход в первый результат поискового запроса")
    void successfulSearchFirstResultTest() {
        searchScreen.skipStartScreen()
                .searchClick()
                .enterSearchValue()
                .checkSearchResult()
                .clickFirstSearchResult()
                .checkTitleFirstSearchResult();
    }

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.NORMAL)
    @Story("Выводить список результатов по запросу")
    @DisplayName("Просмотр списка предыдущих поисковых запросов")
    void checkRecentSearchesTest() {
        searchScreen.skipStartScreen()
                .searchClick()
                .enterSearchValue()
                .checkSearchResult()
                .clearSearchField()
                .checkRecentSearch();
    }

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Реализовать возможность смены языка в настроках Wikipedia")
    @DisplayName("Смена языковой настройки")
    void languageSettingTest() {
        settingsScreen.clickNavigationButton()
                .clickSettingsButton();
        languageScreen.clickAddLanguageList()
                .selectLanguage()
                .checkAddedLanguage();

    }



}