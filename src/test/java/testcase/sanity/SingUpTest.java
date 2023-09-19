package testcase.sanity;

import org.laplacita.pages.PolitiesOfPrivacyPage;
import org.laplacita.pages.SignupPage;
import org.laplacita.pages.TermsAndConditionsPage;
import org.laplacita.pages.home.TopHeaderPage;
import org.laplacita.testCaseImplements.DataProviderUser;
import org.laplacita.testCaseImplements.TestCase;
import org.testng.annotations.Test;

public class SingUpTest extends TestCase {

    @Test(priority = 1)
    public void singUpTest() {
        TopHeaderPage topHeaderPage = new TopHeaderPage(browser);
        SignupPage signupPage = new SignupPage(browser);
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(browser);
        PolitiesOfPrivacyPage politiesOfPrivacyPage = new PolitiesOfPrivacyPage(browser);

        topHeaderPage.singUpClick();
        signupPage.termsAndConditionsClick();
        assertTrue(termsAndConditionsPage.isCorrectUrlTermsAndCondition());
        navigateBack();
        signupPage.politiesOfPrivacyClick();
        assertTrue(politiesOfPrivacyPage.isCorrectUrlPolitiesOfPrivacy());
        navigateBack();
        signupPage.firstNameInput().sendKeys("Juan");
        signupPage.lastNameInput().sendKeys("Perez");
        signupPage.phoneInput().sendKeys("78787878");
        signupPage.setEmailRandom();
        signupPage.passwordInput().sendKeys("$Klip2023.1");
        signupPage.confirmPasswordInput().sendKeys("$Klip2023.1");
        signupPage.acceptTermsCheckClick();
        signupPage.singUpButtonClick();
        assertTrue(signupPage.isSuccess());

    }

    @Test(dataProvider = "email", dataProviderClass = DataProviderUser.class, priority = 2)
    public void singUpWithExistEmail(String email){
        TopHeaderPage topHeaderPage = new TopHeaderPage(browser);
        SignupPage signupPage = new SignupPage(browser);

        topHeaderPage.singUpClick();
        signupPage.firstNameInput().sendKeys("Juan");
        signupPage.lastNameInput().sendKeys("Perez");
        signupPage.phoneInput().sendKeys("78787878");
        signupPage.emailInput().sendKeys(email);
        signupPage.passwordInput().sendKeys("$Klip2023.1");
        signupPage.confirmPasswordInput().sendKeys("$Klip2023.1");
        signupPage.acceptTermsCheckClick();
        signupPage.singUpButtonClick();
        assertTrue(signupPage.isAlertPresentWithMessage("El correo electrónico ya está registrado"));
    }

    @Test(priority = 3)
    public void requiredFieldTest(){
        TopHeaderPage topHeaderPage = new TopHeaderPage(browser);
        SignupPage signupPage = new SignupPage(browser);

        topHeaderPage.singUpClick();
        signupPage.firstNameInput().sendKeys("");
        signupPage.lastNameInput().sendKeys("");
        signupPage.phoneInput().sendKeys("");
        signupPage.emailInput().sendKeys("");
        signupPage.passwordInput().sendKeys("");
        signupPage.acceptTermsCheckClick();
        signupPage.acceptTermsCheckClick();
        signupPage.passwordInput().sendKeys("");
        assertTrue(signupPage.checkValidationMessage(signupPage.firstNameInput(), "Requerido"));
        assertTrue(signupPage.checkValidationMessage(signupPage.lastNameInput(), "Requerido"));
        assertTrue(signupPage.checkValidationMessage(signupPage.phoneInput(), "Requerido"));
        assertTrue(signupPage.checkValidationMessage(signupPage.emailInput(), "Requerido"));
        assertTrue(signupPage.checkValidationMessage(signupPage.passwordInput(), "Requerido."));
        assertTrue(signupPage.checkValidationMessage(signupPage.acceptTerms(), "Términos y condiciones"));
        assertTrue(signupPage.singUpButton().isDisplayed());
    }

}
