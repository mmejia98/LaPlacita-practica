package testcase.sanity;

import org.laplacita.pages.home.LeftMenuPage;
import org.laplacita.pages.home.RightMenuPage;
import org.laplacita.testCaseImplements.TestCase;
import org.testng.annotations.Test;

public class TestMenu extends TestCase {

    @Test(enabled = false)
    public void testMenuLeft(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(browser);

        LeftMenuPage.Menu.CATEGORIAS.click();

    }

    @Test
    public void testMenuRight() throws InterruptedException {
        RightMenuPage rightMenuPage = new RightMenuPage(browser);

        RightMenuPage.Menu.NUEVOS.click();
        Thread.sleep(2000);
        RightMenuPage.Menu.DETACADOS.click();
        Thread.sleep(2000);
        RightMenuPage.Menu.MENOS_DE_5.click();
        Thread.sleep(2000);
        RightMenuPage.Menu.MENOS_DE_10.click();
    }

}
