package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginFlow {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("http://dev-hrm.yoll.io/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement userNameInput = driver.findElement(By.name("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        userNameInput.sendKeys("yoll-student");
        passwordInput.sendKeys("Bootcamp5#");
        loginButton.click();

        Thread.sleep(5000);

        //driver.getCurrentUrl().endsWith();

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        //create a variable that contains the expected page heaser
        String expectedPageHeader = "Dashboard";

        WebElement pageHeader = driver.findElement(By.cssSelector(".head>h1"));
       String  actualPageHeader = pageHeader.getText();


        //Validate if the page header is dashboard

        if (expectedPageHeader.equals(actualPageHeader)){
            System.out.println("TEST PASSED");
        }else{
            System.err.println("TEST FAILED");
        }
        driver.quit();



    }
}
