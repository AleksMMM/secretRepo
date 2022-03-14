package yandex;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class EbayTest extends BaseSeleniumTest {

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")
    private WebElement electronic;


    // //li[@class = 'hl-cat-nav__js-tab'] /a[text() = 'Электроника']
    @Test
    @DisplayName("Выполнение сложных действий class Actions")
    public void hardSkillsActionsTest() {
        driver.get("https://www.ebay.com/");
        WebElement link = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(link)
                .pause(100)
                .build()
                .perform();

        actions.dragAndDrop(element, link)
                .build()
                .perform();
        //нажатие левой кнопкой мыши на элемент и не отпускать ее moveToElement(link) - навожу на элемент
        // release() - отпустить кнопку после выполнения
        actions.clickAndHold(element).moveToElement(link).release().build().perform();

        // двойной клик по элементу
        actions.doubleClick(element);

        // эмитировать нажатие правой кнопкой мыши на элемент
        actions.contextClick(element);



        // присвоение переменной уменьшение количества кода
        Action action = actions.clickAndHold(element).moveToElement(link).release().build();
        action.perform();

        int a = 0;

    }

    @Test
    @DisplayName("Выполнение Javascript")
    public void javaScriptExecutorTest() {

        // проверка выполнения javaScript
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
      // jse.executeScript("alert('HEELO WORLD');");

        driver.get("https://www.ebay.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 1000)", "");

        int a = 0;

    }

    @Test
    @DisplayName("Работа с Alert")
    public void alertWorks() {
        driver.get("https://www.learnqa.ru/bash#payment");

    }
}
