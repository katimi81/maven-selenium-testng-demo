package testngBasics.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRadioButtonsFunctionality {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }
    @Test
    public void verifyResultIsDisplayed(){
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='Female'][1]"));
        femaleButton.click();
        WebElement valueButton = driver.findElement(By.cssSelector("#buttoncheck"));
        valueButton.click();
        WebElement getValueResults = driver.findElement(By.xpath("//div[@class='px-10 pt-20 pb-5']/p[contains(@class, 'radiobutton')]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getValueResults.isDisplayed(), "Message is not Displayed");
    }

    //Verify that in second radio button selection the third radio button is disabled.
    @Test
    public void isRadioButtonDisabled(){
        WebElement disabledRadioButton = driver.findElement(By.xpath("//input[@value='RadioButton3']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(disabledRadioButton.isEnabled());
    }








}
