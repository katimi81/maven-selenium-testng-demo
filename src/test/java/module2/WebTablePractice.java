package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class WebTablePractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        Thread.sleep(1000);

        //WebElement thirdTableCell = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[2]"));
        //String thirdTableCellText = thirdTableCell.getText();
        //System.out.println("The data from table cell is: " +thirdTableCellText);
        //Extract the content text from the element - getText() - returns a string

        //we created a method(Look below) to get the data we need without repeating the same code.

        getDataByRowAndColumn(driver, 3, 2);
        getDataByRowAndColumn(driver, 5, 2);
        getDataByRowAndColumn(driver, 1, 2);

        // now we want to get the data from the second column (All Rows)

        //List<WebElement> columnData = driver.findElements(By.xpath("//*[@id = 'productTable']/tbody/tr/td[2]"));

        //for (WebElement eachElement : columnData){
           // String eachCellData = eachElement.getText();
           // System.out.println(eachCellData);
        //}
        System.out.println("Entire columns Data");
        getDataByColumnNumber(driver, "1");
        getDataByColumnNumber(driver, "2");
        getDataByColumnNumber(driver, "3");

        //identify the auther name by book name.
        //in this case, we use the "/.." to go back to the parent table
        // to select the row next to row with the book name.
        //"//

        WebElement autherNameElement = driver.findElement(By.xpath("//*[@name = 'BookTable']/tbody//td[text() = 'Master In Java']/../td[2]"));
        String autherName = autherNameElement.getText();
        System.out.println("The auther name of the Master In Java book is: " + autherName);

        driver.quit();
    }
         //Instead of repeating the code as previously seen, mean selecting data from the same table
         // the only changing thing is the row and table numbers.
         // we are gonna create a reusable method that will take two parameters (row and colomn)
         //Those parameters data will be used to build a dynamic xpath
         //The rule of static method: we cannot call directly any non static members
    public static void getDataByRowAndColumn(WebDriver driver, int row, int column){
        String dynamicXpath = "//table[@id='productTable']/tbody/tr[" + row + "]/td[" + column + "]";

        WebElement cellData = driver.findElement(By.xpath(dynamicXpath));
        String cellText = cellData.getText();
        System.out.println("The data in the row "+ row + " and " + column + " cell is: " + cellText);

    }
    //Creat a reusable method that will return the data from the specified column.

    public static void getDataByColumnNumber(WebDriver driver, String column) {
        String dynamicXpath = "//*[@id = 'productTable']/tbody/tr/td[" + column + "]";

        List<WebElement> columnData = driver.findElements(By.xpath(dynamicXpath));

        for (WebElement eachElement : columnData) {
            String eachCellData = eachElement.getText();
            System.out.println(eachCellData);
        }
    }
}
