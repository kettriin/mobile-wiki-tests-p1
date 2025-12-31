package tests;

import org.junit.jupiter.api.Test;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();
    String query = "Appium";

    @Test
    void successfullSearchTest() {
        step("Ввести поисковый запрос", () -> searchPage.searchInputActivate().inputSearchQuery(query));
        step("По запросу найдены результаты", () -> {
            searchPage.resultListNotEmpty();
        });
    }

    @Test
    void negativeSearchArticleOpeningTest() {

        step("Ввести поисковый запрос", () -> searchPage.searchInputActivate().inputSearchQuery(query));
        step("По запросу найдены результаты", () -> {
            searchPage.resultListNotEmpty();
        });
        step("Выбрать статью из списка результатов", () -> searchPage.clickFirstResult());
        step("Отображается ошибка при открытии статьи", () -> searchPage.errorWithArticle());
    }
}
