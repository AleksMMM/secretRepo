package gitHubPage;

import core.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class MainPage extends BaseSeleniumTest {

   // MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

    @FindBy(xpath = "//a[@href = '/login']")
    WebElement signIn;

    @FindBy(xpath = "//div[@class = 'd-flex flex-items-center']/a[contains(@href, '/signup')]")
    WebElement signUp;

    @FindBy(xpath = "//button[contains(@data-optimizely-event, \'click.signup_continue.username\')]")
    WebElement continueEnterUsername;

    public SignUpPage clickSignUp() {
        signUp.click();
        return new SignUpPage();
    }

    public LoginPage clickSignIn() {
        driver.get("https://github.com/");
        signIn.click();
        return new LoginPage();
    }


}
