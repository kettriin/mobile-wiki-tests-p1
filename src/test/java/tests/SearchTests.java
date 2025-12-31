package tests;

import org.junit.jupiter.api.Test;
import screens.SearchScreen;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();
    String query = "Appium";

    @Test
    void successfullSearchTest() {
        step("Ввести поисковый запрос", () -> searchScreen.searchInputActivate().inputSearchQuery(query));
        step("По запросу найдены результаты", () -> {
            searchScreen.resultListNotEmpty();
        });
    }

    @Test
    void negativeSearchArticleOpeningTest() {

        step("Ввести поисковый запрос", () -> searchScreen.searchInputActivate().inputSearchQuery(query));
        step("По запросу найдены результаты", () -> {
            searchScreen.resultListNotEmpty();
        });
        step("Выбрать статью из списка результатов", () -> searchScreen.clickFirstResult());
        step("Отображается ошибка при открытии статьи", () -> searchScreen.errorWithArticle());
    }
}
