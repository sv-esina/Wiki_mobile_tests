# Проект по автоматизации тестирования мобильного приложения [Wikipedia](https://www.wikipedia.org/)

<p align="center">
  <img src="media/icons/wikipedia_png.png" width="500" height="90"/>
</p>

---
## :clipboard: Содержание:

- [Технологии и инструменты](#технологии-и-инструменты)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Allure-отчет](#allure-отчет)
    - [Overview](#overview)
    - [Детализаци отчета](#детализация-отчета)
- [Видео выполнения автотеста](#видео-выполнения-автотеста)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
    - [Дашборд](#дашборд)
    - [Тест-кейсы](#тест-кейсы)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомление в Telegram](#уведомление-в-telegram)

---

## **Технологии и инструменты:**

<p align="center">
    <a href="https://www.jetbrains.com/ru-ru/idea/">
        <img width="5%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"></a>
    <a href="https://gradle.org/">
        <img width="5%" title="Gradle" src="media/icons/Gradle.svg"></a>
    <a href="https://www.java.com/ru/">
        <img width="5%" title="Java" src="media/icons/Java.svg"></a>
    <a href="https://ru.selenide.org/">
        <img width="5%" title="Selenide" src="media/icons/Selenide.svg"></a>
    <a href="https://junit.org/">
        <img width="5%" title="JUnit5" src="media/icons/JUnit5.svg"></a>
    <a href="https://github.com/">
        <img width="5%" title="GitHub" src="media/icons/GitHub.svg"></a>
    <a href="https://aerokube.com/selenoid/">
        <img width="5%" title="Selenoid" src="media/icons/Selenoid.svg"></a>
    <a href="https://allurereport.org/">
        <img width="5%" title="Allure Report" src="media/icons/Allure_Report.svg"></a>
    <a href="https://qameta.io/">
        <img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg"></a>
    <a href="https://www.jenkins.io/">
        <img width="5%" title="Jenkins" src="media/icons/Jenkins.svg"></a>
    <a href="https://telegram.org/">
        <img width="5%" title="Telegram" src="media/icons/Telegram.svg"></a>
    <a href="https://www.atlassian.com/software/jira">
        <img width="5%" title="Jira" src="media/icons/Jira.svg"></a>
    <a href="https://developer.android.com">
        <img width="6%" title="Android" src="images/icons/android-original.svg"></a>
    <a href="https://developer.android.com/studio">
        <img width="6%" title="Android Studio" src="images/icons/androidstudio-original.svg"></a>
    <a href="https://appium.io">
        <img width="5%" title="Appium" src="images/icons/appium.png"></a>
    <a href="https://appium.io/docs/en/latest/quickstart/install/">
        <img width="6%" title="Appium Inspector" src="images/icons/appium_server.png"></a>
    <a href="https://www.browserstack.com">
        <img width="5%" title="Browserstack" src="images/icons/browserstack-original.svg"></a>
</p>

- В данном проекте представлены автоматизированные мобильный тесты, разработанные на языке <code>Java</code> с использованием фреймворка <code>Selenide</code>.
- В качестве сборщика использован <code>Gradle</code>.
- В качестве фреймворка модульного тестирования использован <code>JUnit 5</code>.
- Использована технология <code>Owner</code> для упрощения работы с файлами конфигурации.
- Для удаленного запуска тестов реализована джоба в [Jenkins](https://www.jenkins.io/).
- Для разработки тестов использованы следующие технологии:
- - Локально: Android Studio, Appium Server и Appium ([инструкция](https://autotest.how/appium-setup-for-local-android-tutorial-md)).
- - Удалённо: облачная платформа [Browserstack](https://app-automate.browserstack.com/dashboard/v2/quick-start/setup-browserstack-sdk).
- Реализовано формирование [Allure-отчета](https://jenkins.autotests.cloud/view/java_students/job/SvetlanaV_Esina-Jenkins_first-project/26/allure/) с отправкой результатов прогона тестов в <code>Telegram</code> при помощи бота.
- В проекте так же задействована интеграция с [Allure TestOps](https://qameta.io/) и [Jira](https://www.atlassian.com/software/jira).

## Запуск автотестов

### Локальный запуск тестов из терминала

Локальный запуск на эмуляторе Android Studio:
```bash 
 gradle clean local_test -Dtag=local
```
> Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium ([инструкция](https://autotest.how/appium-setup-for-local-android-tutorial-md))

Удалённые запуск на Browserstack:
```bash 
 gradle clean remote_test -Dtag=remote
```
### Удалённый запуск осуществляется через Jenkins

При удалённом запуске тесты запускаются на облачной платформе Browserstack.
При необходимости реализована возможность переопределить параметры запуска

```bash
clean
remote_test
-DdeviceName="$Device_Name"
-Dos_version="$Platform_Version"
-Dtag="$Tag_Build"
```

### Параметры сборки

- <code>Tag_Build</code> – запуск платформы, на которой будут выполняться тесты (local, browserstack).
- <code>Device_Name</code> — модель устройства, на котором будет выполняться тест.
- <code>Platform_Version</code>— версия операционной системы на целевом устройстве.

---

## **Сборка в Jenkins:**
>Запуск сборки осуществляется через раздел `Build with Parameters` путём нажатия кнопки `Build`

![Jenkins_build.png](media/screenshots/Jenkins_build.png)

---

## **Allure-отчет:**
### Overview

> Главная страница отчета, которая содержит общую информацию о прохождении тестов:
- <code>ALLURE REPORT</code>: Содержит дату и время прохождения тестов, общее количество кейсов и диаграмму с распределением успешных (passed), упавших (failed) и сломавшихся (broken) тестов.
- <code>TREND</code>: Показывает историю прохождения тестов от сборки к сборке.
- <code>SUITES</code>: Распределение результатов тестов по тестовым наборам (пакетам).
- <code>ENVIRONMENT</code>: Информация о тестовом окружении, на котором запускались тесты (версия браузера, ОС, URL стенда и т.д.).

![Allure_report.png](media/screenshots/Allure_report.png)

### Детализация отчета
> Для детального анализа прохождения тестов используется раздел Suites, где тесты отображаются в виде иерархического дерева, что помогает лучше ориентироваться в результатах.

![Allure_report_steps.png](media/screenshots/Allure_report_steps.png)

---

## **Видео выполнения автотеста:**
> К каждому тесту в отчете прилагается видео:

https://github.com/user-attachments/assets/cc4d25b8-a932-41a3-aa17-5328233a6082

---

## **Интеграция с Allure TestOps:**
### Дашборд
> Результат и статистика выполнения автотестов отображается в разделе Dashboard.

![TestOpsDashboard.png](media/screenshots/TestOpsDashboard.png)

### Тест-кейсы
> В разеделе Тест-кейсы представлен список автоматизированных и ручных тестов, реализованных в рамках проекта

![TestOps.png](media/screenshots/TestOps.png)

---

## **Интеграция с Jira:**

> Реализована интеграция Allure TestOps с Jira. В задаче отображен список связанных тестов и результаты их прогонов.

![Jira.png](media/screenshots/Jira.png)

---

## **Уведомление в Telegram:**
> По завершению сборки в чат Telegram автоматически направляется уведомление с результатом прогона тестов.
> Из уведомления возможен переход в Allure Report по указанной ссылке.

<img width="50%" title="TelegramBot" src="media/screenshots/TelegramBot.png">
