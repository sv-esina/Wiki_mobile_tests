package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreen {


    public static String host = System.getProperty("host");

    private final SelenideElement
            messageWiki = $(AppiumBy.id("android:id/message")),
            closeMessageWiki = $(AppiumBy.id("android:id/button1")),
            navigationButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            settingButton = $(id("org.wikipedia.alpha:id/explore_overflow_settings")),
            languageButton = $(id("org.wikipedia.alpha:id/langCodeText"));

    @Step("Нажимаем на кнопку 'Навигация'")
    public SettingsScreen clickNavigationButton(){
        if (messageWiki.is(visible)) {
            closeMessageWiki.click();
        }
        navigationButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Settings'")
    public SettingsScreen clickSettingsButton() {
        if(host.equals("local")){
            languageButton.click();}
        else {settingButton.click();}
        return this;
    }
}
