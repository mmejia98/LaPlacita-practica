package testcase.sanity;

import org.laplacita.pages.SignupPage;
import org.laplacita.pages.home.TopHeaderPage;
import org.laplacita.testCaseImplements.TestCase;
import org.testng.annotations.Test;

public class SingUpTest extends TestCase {

    @Test
    public void singUpTest() {
        TopHeaderPage topHeaderPage = new TopHeaderPage(browser);
        SignupPage signupPage = new SignupPage(browser);

        topHeaderPage.singUpClick();
        signupPage.firstNameSendText("Testing");
        signupPage.lastNameInput().sendKeys("Automatización");
        signupPage.phoneInput().sendKeys("77776666");
        //signupPage.setEmailRandom();
        signupPage.emailInput().sendKeys("mmejiaalvarenga@gmail.com");
        signupPage.passwordInput().sendKeys("Hola.123456");
        signupPage.confirmPasswordInput().sendKeys("Hola.123456");
        signupPage.acceptTermsCheckClick();
        signupPage.singUpButtonClick();
        assertTrue(signupPage.isSuccess());

    }

}
