package firstHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.DriverInit;
import utils.Urls;

public class MyShopAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.myShop);
        Thread.sleep(1000);
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.linkText("Printed Chiffon Dress")).click();
        Select size = new Select(driver.findElement(By.id("group_1")));
        Thread.sleep(1000);
        size.selectByValue("3");
        Thread.sleep(1000);
        size.selectByValue("2");
        Thread.sleep(2000);
        driver.findElement(By.id("add_to_cart")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.linkText("Blouse")).click();
        Select size2 = new Select(driver.findElement(By.id("group_1")));
        Thread.sleep(1000);
        size2.selectByValue("2");
        Thread.sleep(1000);
        size2.selectByValue("3");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        driver.findElement(By.xpath("//b[text()='Cart']")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
