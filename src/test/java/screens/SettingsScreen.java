package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreen {

    private final SelenideElement
            navigationButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            settingButton = $(id("org.wikipedia.alpha:id/explore_overflow_settings"));

    @Step("Нажимаем на кнопку 'Навигация'")
    public SettingsScreen clickNavigationButton(){
        navigationButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Settings'")
    public SettingsScreen clickSettingsButton() {
        settingButton.click();
        return this;

    }
}
