package org.laplacita.testCaseImplements;

import org.testng.annotations.DataProvider;

public class DataProviderProducto {

    @DataProvider(name = "producto")
    public Object[][] data(){
        return new Object[][]{{"Laptop"}};
    }

}
