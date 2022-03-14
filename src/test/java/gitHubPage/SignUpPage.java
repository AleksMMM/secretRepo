package gitHubPage;

import core.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseSeleniumTest {

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement email;

    @FindBy(xpath = "//input[@id = 'password']")
    WebElement password;

    @FindBy(xpath = "//input[@id = 'login']")
    WebElement usernameFild;

    @FindBy(xpath = "//button[contains(@data-optimizely-event, \'click.signup_continue.username\')]")
    WebElement continueEnterUsername;

    @FindBy(xpath = "//button[contains(@data-optimizely-event, 'click.signup_continue.email')]")
    WebElement continueEnterEmail;

    @FindBy(xpath = "//button[contains(@data-optimizely-event, 'click.signup_continue.password')]")
    WebElement continueEnterPassword;

    /**
     *
     * @param email
     * @param userName
     * @param password
     * @return
     *
     * метод для регистрации нового юзера
     */
    public SignUpPage registerNewUser(String email, String userName, String password) {
        this.email.sendKeys(email);
        this.continueEnterEmail.click();
        this.password.sendKeys(password);
        this.continueEnterPassword.click();
        this.usernameFild.sendKeys(userName);
        this.continueEnterUsername.click();

        return this;

    }
}
