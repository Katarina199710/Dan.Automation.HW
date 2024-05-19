package secondHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.DriverInit;
import utils.Urls;

import java.util.List;

public class OnlyTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.onlyTesting);
        Select cars = new Select(driver.findElement(By.id("Carlist")));
        List<WebElement> allCars = cars.getOptions();
        System.out.println("Автомобілі доступні для вибору:");
        for (WebElement element : allCars) {
            System.out.print(element.getText() + ", ");
        }
        System.out.println();
        cars.selectByVisibleText("Renault");
        Thread.sleep(1000);
        Select countries1 = new Select(driver.findElement(By.name("FromLB")));
        countries1.selectByVisibleText("France");
        countries1.selectByValue("India");
        countries1.deselectByValue("India");
        driver.findElement(By.id("check1")).click();
        driver.findElement(By.id("check2")).click();
        countries1.selectByVisibleText("Germany");
        countries1.selectByVisibleText("Italy");
        countries1.selectByValue("Malaysia");
        countries1.deselectByValue("Malaysia");
        countries1.selectByValue("Spain");
        driver.findElement(By.xpath("//input[@value='->']")).click();
        Thread.sleep(1000);
        Select countries2 = new Select(driver.findElement(By.name("ToLB")));
        System.out.println("Країни з першої таблиці:");
        List<WebElement> countriesFromFirstTable = countries1.getOptions();
        for (WebElement element : countriesFromFirstTable) {
            System.out.print(element.getText() + ", ");
        }
        System.out.println();
        System.out.println("Країни з другої таблиці:");
        List<WebElement> countriesFromSecondTable = countries2.getOptions();
        for (WebElement element : countriesFromSecondTable) {
            System.out.print(element.getText() + ", ");
        }
        System.out.println();
        driver.quit();
    }
}
