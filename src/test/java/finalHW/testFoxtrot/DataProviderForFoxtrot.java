package finalHW.testFoxtrot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CustomWaiters;
import utils.DriverInit;

public class DataProviderForFoxtrot {
    static WebDriver driver;
    static CustomWaiters waiters;

    @BeforeClass
    public void setUp() {
        driver = DriverInit.setUpDriver();
        waiters = new CustomWaiters(driver);
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }


    @Test(dataProvider = "wordValue")
    public void check_search_string(String word) {
        driver.get(" https://www.foxtrot.com.ua/");
        waiters.waitForVisibility(By.xpath("//i[@class='icon icon-close']")).click();
        //после вейтеров остальные два теста падают и я если честно не поняла как это исправить
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(word);
        driver.findElement(By.xpath("//input[@value='Знайти']")).click();
        waiters.waitForVisibility(By.xpath("//h1[1]"));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[1]")).getText()
                .contains(word));
    }
    @DataProvider(name = "wordValue")
    public Object [] createData(){
        return new Object[]{"машина","input","стив"};
    }
}
