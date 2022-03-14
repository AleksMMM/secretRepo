package gitHubPage;

import core.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class LoginPage extends BaseSeleniumTest {

    @FindBy(xpath = "//input[@id = 'login_field']")
    WebElement loginFild;

    @FindBy(xpath = "//input[@id = 'password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value = 'Sign in']")
    WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class = 'px-2']")
    WebElement inCorrectLogin;

    @FindBy(xpath = "//a[text() = 'Create an account']")
    WebElement returnSignUpPage;

    public LoginPage typeUserName(String userName) {
        loginFild.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickButtonInCorrect(String userName, String password) {
        this.loginFild.sendKeys(userName);
        this.passwordField.sendKeys(password);
        buttonSignIn.click();
        return new LoginPage();
    }

    public String getHeadingText() {
        return inCorrectLogin.getText();
    }

    public SignUpPage returnPage() {
        returnSignUpPage.click();
        return new  SignUpPage();
    }
}
