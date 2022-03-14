package qaGuru;

import com.codeborne.pdftest.PDF;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import core.BaseSeleniumTest;
import io.restassured.internal.mapping.Jackson1Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadChekcsTest extends BaseSeleniumTest {

@Test
public void downloadTest() throws InterruptedException {

    ChromeOptions options = new ChromeOptions();

    driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/file-download/");
    driver.findElement(By.xpath("//a[text() = 'Download']")).click();

    Thread.sleep(5000);

}
@Test
public void parsePdfTest() throws IOException {
   // BufferedReader br = new BufferedReader(new FileReader("qaGuru/test.pdf"));
    PDF pdf = new PDF(new File("C:\\Users\\aleks\\IdeaProjects\\You-qa-project\\src\\test\\java\\qaGuru\\test.pdf"));
    String a = pdf.author.toString();
    System.out.println(a);
    Assertions.assertEquals(a, "Athan");

}

    @Test
    public void parseExcelTest() {
    
}

    @Test
    public void parseJsonTest() throws Exception {

    // получаю json из файла и далее нахожу поле name выводя его значение
            Path path = Paths.get("src/test/resources/simple.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(Files.readString(path));
            System.out.println(jsonNode.get("name"));
        }

    }


