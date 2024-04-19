package testngBasics.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoSeatsAvailableTest {

    @Test
    public void verifyTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();

        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "expected Page title is different from Actual");
        driver.quit();

    }


    @Test
    public void findSeats() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();

        WebElement flightsLink = driver.findElement(By.xpath("//a[text() = 'Flights']"));
        flightsLink.click();

        WebElement numOfPassDropdown = driver.findElement(By.xpath("//select[@name ='passCount']"));
        Select dropdown = new Select(numOfPassDropdown);
        dropdown.selectByVisibleText("2");
        Thread.sleep(2000);

        

        driver.quit();


    }
}