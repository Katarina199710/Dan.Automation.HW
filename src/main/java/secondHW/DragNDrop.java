package secondHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.DriverInit;
import utils.Urls;

public class DragNDrop {
    private static class Locators{
        private static final By firstDragElement = By.xpath("//li[@id='fourth'][1]");
        private static final By secondDragElement = By.xpath("//li[@id='fourth'][2]");
        private static final By bankElement = By.id("credit2");
        private static final By salesElement = By.id("credit1");
        private static final By firstDropAria = By.id("amt7");
        private static final By secondDropAria = By.id("amt8");
        private static final By thirdDropAria = By.id("bank");
        private static final By forthDropAria = By.id("loan");
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.guru99);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(Locators.firstDragElement), driver.findElement(Locators.firstDropAria)).perform();
        Thread.sleep(1000);
        actions.dragAndDrop(driver.findElement(Locators.secondDragElement), driver.findElement(Locators.secondDropAria)).perform();
        Thread.sleep(1000);
        actions.dragAndDrop(driver.findElement(Locators.bankElement), driver.findElement(Locators.thirdDropAria)).perform();
        actions.dragAndDrop(driver.findElement(Locators.salesElement), driver.findElement(Locators.forthDropAria)).perform();
        driver.findElement(By.linkText("Perfect!")).click();
        System.out.println(driver.findElement(By.linkText("Perfect!")).getText());
        driver.quit();
    }
}
