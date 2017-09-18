package test;


import framework.utils.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp () {
        Browser.navigate("http://todomvc.com/examples/angularjs");
    }

    @AfterClass
    public void tearDown(){
        Browser.quit();
    }
}
