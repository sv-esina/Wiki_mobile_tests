package screens;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.className;

public class LanguageScreen {

    private final ElementsCollection
            languageList = $$(className("android.widget.TextView")),
            languageName = $$((id("org.wikipedia.alpha:id/localized_language_name"))),
            checkLanguageText = $$(className("android.widget.TextView"));

    @Step("Кликаем на иконку 'Wikipedia languages'")
    public LanguageScreen languageListClick() {
        languageList.findBy(text("Wikipedia language")).click();
        return this;

    }

    @Step("Выбираем нужный язык текста")
    public LanguageScreen selectLanguage(String value) {
        languageName.findBy(text(value)).click();
        return this;
    }

    @Step("Проверяем смену языка")
    public LanguageScreen checkLanguage(String value) {
        checkLanguageText.findBy(text(value)).shouldBe(visible);
        return this;
    }


}
