package testcase.sanity;

import org.laplacita.pages.ContactUsPage;
import org.laplacita.pages.home.LeftMenuPage;
import org.laplacita.testCaseImplements.TestCase;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ContactUsTest extends TestCase {

    @Test
    public void contactUsTest(){
        ContactUsPage contactUsPage = new ContactUsPage(browser);
        LeftMenuPage leftMenuPage = new LeftMenuPage(browser);
        LeftMenuPage.Menu.CONTACTO.click();
        contactUsPage.nameInputSendText("Mario Jose");
        contactUsPage.emailInputSendText("mmejiaalvarenga@gmail.com");
        contactUsPage.phoneInputSendText("79989908");
        contactUsPage.subjectInputSendText("Probando formulario contacto");
        contactUsPage.messageInputSendText("Esto solo es una prueba en el ambiente de UAT");
        contactUsPage.sendButtonClick();
        assertTrue(contactUsPage.isSuccess());
    }

}
