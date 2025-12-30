package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private final SelenideElement fakeSearchInput = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement trueSearchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection resultsList =
            $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement articleDescription =
            $(id("org.wikipedia.alpha:id/pcs-edit-section-title-description"));
    private final SelenideElement articleError = $(id("org.wikipedia.alpha:id/page_error"));


    @Step("Сделать поиск активным")
    public SearchPage searchInputActivate() {
        fakeSearchInput.click();
        return this;
    }

    @Step("Ввести запрос: {query}")
    public void inputSearchQuery(String query) {
        trueSearchInput.sendKeys(query);
    }

    @Step("Отображаются результаты поиска")
    public SearchPage resultListNotEmpty() {
        resultsList.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Выбрать первю статью")
    public void clickFirstResult() {
        resultsList.first().click();
    }

    @Step("Описание открытой статьи соответствует поисковому запросу")
    public void descriptionMatchesQuery(String queryDescription) {
        articleDescription.shouldHave(text(queryDescription));
    }

    @Step("При открытии статьи отображается ошибка")
    public void errorWithArticle() {
        articleError.shouldBe(visible);
    }
}
