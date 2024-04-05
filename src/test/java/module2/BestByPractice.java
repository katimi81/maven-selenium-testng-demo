package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestByPractice {
    public static void main(String[] args) throws InterruptedException {

        //create a driver object
        WebDriver driver = new ChromeDriver();
        //navigate to bestbuy
        driver.get("https://www.bestbuy.com/");
        Thread.sleep(2000);

        WebElement searchInputBox = driver.findElement(By.className("search-input"));
        searchInputBox.click();
        Thread.sleep(2000);

        searchInputBox.sendKeys("iPhone 15 pro max");
        Thread.sleep(5000);
        WebElement searchButton = driver.findElement(By.className("header-search-button"));
        searchButton.click();
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("searchpage")){
            System.out.println("TEST: PASSED");
        }else{
            System.out.println("TEST: FAIL");
        }

        System.out.println("Current URL: "+ currentUrl);
        driver.quit();

    }
}
