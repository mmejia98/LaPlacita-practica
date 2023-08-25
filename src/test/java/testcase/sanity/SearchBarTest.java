package testcase.sanity;

import org.laplacita.pages.home.HeaderPage;
import org.laplacita.testCaseImplements.TestCase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SearchBarTest extends TestCase {


    @Test
    public void searchTest(){

        HeaderPage headerPage = new HeaderPage(browser);

        headerPage.searchItems("laptop");

    }

}
