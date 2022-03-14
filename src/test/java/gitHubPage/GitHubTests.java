package gitHubPage;

import core.BaseSelenideTest;
import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GitHubTests extends BaseSeleniumTest {

    @Test
    public void signInTest() {
        LoginPage loginPage = new MainPage().clickSignIn();
        String heading = loginPage.getHeadingText();
        Assertions.assertEquals("", heading);

        int a = 9;

    }

}
