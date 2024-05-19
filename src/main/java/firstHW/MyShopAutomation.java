package firstHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverInit;
import utils.Urls;

public class MyShopAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.myShop);
        Thread.sleep(1000);
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Printed Summer Dress")).click();
    }
}
