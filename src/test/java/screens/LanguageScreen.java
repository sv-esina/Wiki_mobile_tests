package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.TestData.LANGUAGE;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.className;

public class LanguageScreen {

    public static String tag = System.getProperty("tag");

    private final SelenideElement
            addLanguageButton = $(androidUIAutomator("new UiSelector().text(\"Add language\")")),
            addedLanguage = $(androidUIAutomator("new UiSelector().text(\"Deutsch\")"));

    private final ElementsCollection
            languageList = $$(className("android.widget.TextView")),
            languageName = $$((id("org.wikipedia.alpha:id/localized_language_name"))),
            chooseLanguage = $$(byClassName("android.view.View"));

    @Step("Открываем в список языков")
    public LanguageScreen clickAddLanguageList() {
        if(tag.equals("local")){
            addLanguageButton.click();}
        else {languageList.findBy(text("Wikipedia language")).click();}
        return this;

    }

    @Step("Выбираем нужный язык текста")
    public LanguageScreen selectLanguage() {
        if(tag.equals("local")){
            chooseLanguage.get(3).click();}
        else {languageName.findBy(text(LANGUAGE)).click();}
        return this;
    }

    @Step("Проверяем добавленную запись")
    public LanguageScreen checkAddedLanguage() {
        addedLanguage.shouldHave(text(LANGUAGE));
        return this;
    }


}
