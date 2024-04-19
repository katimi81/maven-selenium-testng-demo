package testngBasics.practice;

import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 0)
    public void addUser(){
        System.out.println("Adding user to list.");
    }

    @Test(priority = 1)
    public void modifyUser(){
        System.out.println("Modify existing user test.");
    }

    @Test(priority = 2)
    public void deleteUser(){
        System.out.println("Delete existing user from the list.");
    }


}