package org.laplacita.testCaseImplements;

import org.testng.annotations.DataProvider;

public class DataProviderUser {

    @DataProvider(name = "email")
    public Object[][] data(){
        return new Object[][]{{"juan.perez@example.com"}};
    }
}
