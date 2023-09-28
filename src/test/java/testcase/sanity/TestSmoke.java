package testcase.sanity;

import org.testng.annotations.Test;

public class TestSmoke {
    @Test(groups = {"smoke"})
    public void t1(){
        System.out.println("Smoke test 3");
    }
}
