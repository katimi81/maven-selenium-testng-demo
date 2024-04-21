package testngBasics.practice;

import org.testng.annotations.*;

public class TestBase {

    @BeforeSuite
    public void before_whole_suite(){
        System.out.println("- - - - I am Before Suite");
    }

    @AfterSuite
    public void after_whole_suite(){
        System.out.println("- - - - I am After Suite");
    }
    @BeforeTest
    public void before_whole_test(){
        System.out.println("- - - I am Before Test");
    }

    @AfterTest
    public void after_test(){
        System.out.println("- - - I am After Test");
    }

    @BeforeClass
    public void before_class(){
        System.out.println("- - I am Before CLass");
    }

    @AfterClass
    public void after_class(){
        System.out.println("- - I am After CLass");
    }

    @BeforeMethod
    public void before_method(){
        System.out.println("- I am Before Method");
    }

    @AfterMethod
    public void after_method(){
        System.out.println("- I am After Method");
    }




}
