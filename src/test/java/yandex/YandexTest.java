package yandex;


import core.BaseSeleniumTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition.*;

import javax.xml.bind.Element;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class YandexTest extends BaseSeleniumTest {

    @Test
    public void yandexSearchTest() {

        // клик по элементу
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@id = 'searchButton']")).click();
        int a = 0;
    }

    @Test
    public void textFildsWiki() {
        // переход на страницу, ввод текста и клик на поиск
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@class = 'vector-search-box-input']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id = 'searchButton']")).click();
        int a = 0;
    }

    @Test
    @DisplayName("клик на ссылку")
    public void hreftFildsWiki() {
        // переход на страницу, ввод текста и клик на поиск
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
       WebElement link = driver.findElement(By.xpath("//ul[@class = 'vector-menu-content-list']//span[text() = 'About Wikipedia']"));
        System.out.println(link.getText());
        link.click();
        int a = 0;
    }

    @Test
    @DisplayName("Работа с чекбоксами и радио кнопками")
    public void radioButtonYandexMarket() throws InterruptedException {
        // переход на страницу, ввод текста и клик на поиск
        driver.get("https://market.yandex.ru/catalog--smartfony/22489491/list?rs=eJwzUvdS5hJzMkxP988Mj7KMyDZzMQop8w_JNfFzFOK0NDEzNDK2NDBIYAQA3N8KJA%2C%2C&onstock=0&hid=91491&local-offers-first=0");
        driver.findElement(By.xpath("//span[text() = 'Apple']")).click();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        int a = 0;

        //a[@data-tid = '5378166a']//input[contains(@name, 'Производитель Apple')]
    }

    @Test
    @DisplayName("Работа с чекбоксами и радио кнопками")
    public void buttonYandexMarket() {
        // переход на страницу, ввод текста и клик на поиск
        driver.get("https://market.yandex.ru/catalog--smartfony/22489491/list?rs=eJwzUvdS5hJzMkxP988Mj7KMyDZzMQop8w_JNfFzFOK0NDEzNDK2NDBIYAQA3N8KJA%2C%2C&onstock=0&hid=91491&local-offers-first=0");
        driver.findElement(By.xpath("//input[@id = 'qrfrom_2']/../div")).click();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        int a = 0;

    }

    @Test
    @DisplayName("Работа с выпадающими списками")
    public void clickList() {
        driver.get("https://sitehere.ru/examples/03.09.2014/index.html");
        driver.findElement(By.xpath("//span[text() = 'Список элементов']")).click();
        driver.findElement(By.xpath("//ul/li[@data-value = 'twitter']")).click();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        int a = 0;

    }

    @Test
    @DisplayName("Поиск списка элементов")
    public void searchListElement() {
        driver.get("https://sitehere.ru/examples/03.09.2014/index.html");
        driver.findElement(By.xpath("//span[text() = 'Список элементов']")).click();
        driver.findElement(By.xpath("//ul/li[@data-value = 'twitter']")).click();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

        int a = 0;

    }
    //div[@class = 'home-logo__default']
    // implycitlyWait - ожидание если selenium не найдет элемент то будет ждать определенное время
    // можно использовать при работе с выпадающими списками, дождаться после клика что появился выпадающий список
    @Test
    @DisplayName("Явные ожидания (Explicit Wait)")
    public void ExplicitWaitElement() {
        driver.get("https://yandex.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(NoSuchElementException.class)
                        .ignoring(ElementNotInteractableException.class) // игнор исключений
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home-logo__default']"))); // ожидание до появления элемента

        int a = 0;

    }

    // Работа с окнами браузера
    @Test
    public void windowsClickTests() {
        driver.get("url"); // перехожу на url
        String mainWin = driver.getWindowHandle(); // сохраняю нужное окно в переменную
        driver.findElement(By.xpath("xpath")).click(); // нахожу элемент по xpath и выполняю клик

        // цикл для переключения на последнее окно
        for (String winHandle: driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.xpath("xpath")).click(); //

    }

    @Test
    @DisplayName("Работа с вкладками браузера")
    public void windowBrowserTests() {
        driver.get("url"); // перехожу на url
        String mainWin = driver.getWindowHandle(); // сохраняю нужное окно в переменную
        driver.findElement(By.xpath("xpath")).click(); // нахожу элемент по xpath и выполняю клик

        driver.switchTo().window(mainWin);

        // нахожу элемент в новой вкладке и кликаю на него
        driver.findElement(By.xpath("xpath")).click();


    }

    @Test
    @DisplayName("Проверка доступности элементов")
    public void buttonEnabledOrNo() {
        driver.get("url"); // перехожу на url
        driver.findElement(By.xpath("xpath")).click(); // нахожу элемент по xpath и выполняю клик

        // присвоил элементу переменную
        WebElement button1 = driver.findElement(By.xpath("xpath"));
        WebElement button2 = driver.findElement(By.xpath("xpath"));

        // клик если кнопка видна
        if (button1.isEnabled()) {
            button1.click();
        }

        // проверка включена ли кнопка
        if (button2.isSelected()) {
            button2.click();
        }


    }

    @Test
    @DisplayName("Проверка наличия элемента")
    public void elementYesOrNO() {
        driver.get("https://github.com/");
        driver.findElement(By.xpath("//a[@class = 'HeaderMenu-link flex-shrink-0 no-underline']"));
        // получаю list элементов и проверяю что он пуст, значит элемент не найден
        List<WebElement> elements = driver.findElements(By.xpath("//aaa"));

        if (elements.size() == 0) {
            System.out.println("no elements");
        }
    }

    @Test
    @DisplayName("Имитация нажатия клавиш клавиатуры")
    public void EnterTab() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
       WebElement searc =  driver.findElement(By.xpath("//input[@id = 'searchInput']"));
       searc.sendKeys("TEXT");

       // зажать клавишу SHIFT  и ввести текст
       searc.sendKeys(Keys.chord(Keys.SHIFT, "testttt"));


       // нажатие на клавиатуре кнопки ENTER
       searc.sendKeys(Keys.ENTER);

       int a = 9;

    }

    @Test
    @DisplayName("Загрузка файлов")
    public void uploadFile() {
        driver.get("https://images.google.com/");
        driver.findElement(By.xpath("//div[@aria-label = 'Поиск по картинке']/span")).click();
        driver.findElement(By.xpath("//a[text() = 'Загрузить изображение']")).click();
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\aleks\\IdeaProjects\\You-qa-project\\src\\test\\resources\\post-51189-1645519533aff6_thumb.jpg");

        int a = 0;
    }

    @Test
    @DisplayName("Запуск тестов в разных браузерах")
    public void browserUpdate() {
        // создал объект нового драйвера и теперь этот тест будет запускаться на этом экземрляре браузера
        driver = new FirefoxDriver();
    }


}
