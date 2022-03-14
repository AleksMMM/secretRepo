package qaGuru;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//параметризованные тесты
public class ParametrazedTests extends BaseSeleniumTest {

    // преимущество работает в многопоточности
    @BeforeEach
    void precondition() {
        driver.get("https://yandex.ru/");
    }
    // преимущество работает в многопоточности
    @AfterEach
    void close() {
        driver.close();
        driver.quit();
    }
    //аннотация для тестовых данных
    @ValueSource(strings = {"Selenide", "Junit5"})

    // аннотация если нужно проверить несколько параметров (если слово с запятой то использовать delimeter)
    @CsvSource( value = {
            "Selenide, concise UI",
            "JUnit 5, Intelij IDEA"
    }
    )
    //аннотация для того чтобы использовать свой метод с тестовыми данными, которые передаются с помощью stream
    @MethodSource(value = "dataProvider")
    // аннотация для параметризованных тестов можно указывать имя теста и применяемые тестовые данные
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в яндексе \"{0}\"")
    @DisplayName("Проверка отображения поисковых результатов в яндексе")
    void searchCommandTest(String testdata) {
      WebElement searchLine = driver.findElement(By.xpath("//input[@id = 'text']"));
      searchLine.sendKeys(testdata);
      driver.findElement(By.xpath("//button[@class = 'button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//span[@class = 'OrganicTitleContentSpan organic__title']"));
        list.forEach(System.out::println);

    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Selenide", Arrays.asList(1, 2, 3)),
                Arguments.of("Selenide", Arrays.asList(5, 7, 9))

        );
    }



}
