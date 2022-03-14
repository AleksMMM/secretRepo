package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
     //   driver = new ChromeDriver();
     //   driver.manage().window().maximize();
     //   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
     //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     //   BaseSeleniumPage.setDriver(driver);


        // настройки браузера по изменению директории для скачивания файла
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> preference = new HashMap<>();
        preference.put("download.default_directory", "C:\\Users\\aleks\\IdeaProjects\\You-qa-project\\src\\test\\java\\qaGuru");
        options.setExperimentalOption( "prefs" ,preference);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterEach
    public void tearDown(){
      //  driver.close();
      //  driver.quit();
    }
}
