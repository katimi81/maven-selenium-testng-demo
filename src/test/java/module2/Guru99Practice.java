package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "http://demo.guru99.com/test/newtours/";
        driver.get(url);

        WebElement usernameInput = driver.findElement(By.name("userName"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        String username = "test@email.com";
        String password = "test";

        usernameInput.sendKeys(username);
        Thread.sleep(2000);
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(5000);

        WebElement vacation = driver.findElement(By.linkText("Vacations"));
        vacation.click();

        Thread.sleep(10000);

        WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
        registerLink.click();
        Thread.sleep(10000);

        String expectedUrlPostfix = "/register.php";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.endsWith(expectedUrlPostfix)){
            System.out.println("Registration page Test: PASSED");
        }else {
            System.err.println("Registration page Test: FAILED");
        }
        
        driver.quit();


    }
}
