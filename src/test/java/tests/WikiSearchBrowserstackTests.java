package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.LanguageScreen;
import screens.SettingsScreen;
import screens.WikiSearchScreen;

import static data.TestData.LANGUAGE;

@DisplayName("Тестирование приложения Wikipedia удаленно, используя Browserstack")
public class WikiSearchBrowserstackTests extends TestBase {

    WikiSearchScreen searchScreen = new WikiSearchScreen();
    LanguageScreen languageScreen = new LanguageScreen();
    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Выводить список результатов по запросу")
    @DisplayName("Успешное отображение результатов поиска")
    public void successfulWikiSearchTest() {
        searchScreen.searchClick()
                .enterSearchValue()
                .checkSearchResult();
    }

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.NORMAL)
    @Story("Выдавать ошибку в случае неудачной загрузки страницы")
    @DisplayName("Проверка ошибки при открытии первого в списке результата поиска")
    public void chooseFirstSearchResultTest() {
        searchScreen.searchClick()
                .enterSearchValue()
                .checkSearchResult()
                .clickFirstSearchResult()
                .checkErrorIcon()
                .checkErrorText();
    }

    @Test
    @Tag("browserstack")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Реализовать возможность смены языка в настроках Wikipedia")
    @DisplayName("Смена языковой настройки")
    void languageSettingTest() {
        settingsScreen.clickNavigationButton()
                .clickSettingsButton();
        languageScreen.languageListClick()
                .selectLanguage(LANGUAGE)
                .checkLanguage(LANGUAGE);

    }

}