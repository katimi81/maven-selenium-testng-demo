package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class MultipleElements {
    public static void main(String[] args) throws InterruptedException {

        // Create a WebDriver object
        WebDriver driver = new ChromeDriver();
        // maximize the window
        driver.manage().window().maximize();

        String url = "https://www.bestbuy.com";
        driver.get(url);

        WebElement searchInput = driver.findElement(By.id("gh-search-input"));
        WebElement searchButton = driver.findElement(By.className("header-search-button"));

        // interact with located elements
        searchInput.sendKeys("iphone 15");
        Thread.sleep(2000);

        searchButton.click();
        Thread.sleep(2000);

        //collect all the items from result
        //findElements
        List<WebElement> products = driver.findElements(By.className("sku-title"));

        //If I want to know how many elements are in the list
        System.out.println("Items found:" + products.size());

        //Iterate over the list
        //We are gonna use the for each loop to go over the list.
        //1. What is the data type of your elements - WebElement
        //2. How do you want to call the current element - product
        //3. What is the source? The list we want tou use - products


        for(WebElement product : products){
           String text =  product.getText();
            System.out.println("Title: "+text);
            Thread.sleep(1000);

            if(text.toLowerCase(Locale.ROOT).contains("iphone 15 pro")) {
                System.out.println("Item Relevant");
            } else {
                System.err.println("Item Irrelevant");
            }
        }

        driver.quit();


    }
}
