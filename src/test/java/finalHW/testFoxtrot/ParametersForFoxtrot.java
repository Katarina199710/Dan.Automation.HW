package finalHW.testFoxtrot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.CustomWaiters;
import utils.DriverInit;

public class ParametersForFoxtrot {
    static WebDriver driver;
    static CustomWaiters waiters;

    @BeforeClass
    public void setUp() {
        driver = DriverInit.setUpDriver();
        waiters = new CustomWaiters(driver);
    }

    @AfterClass
    public void stopDriver() {
//        driver.quit();
    }

    @Parameters({"word_for_test"})
    @Test
    public void check_search_string(String word) {
        driver.get(" https://www.foxtrot.com.ua/");
        waiters.waitForVisibility(By.xpath("//i[@class='icon icon-close']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(word);
        driver.findElement(By.xpath("//input[@value='Знайти']")).click();
        switch (word) {
            case "машина" -> Assert.assertTrue(driver.findElement(By.xpath("//h1[1]")).getText()
                    .contains("машина"));
            case "input" -> Assert.assertTrue(driver.findElement(By.xpath("//h1[1]")).getText()
                    .contains("input"));
            case "стив" -> Assert.assertTrue(driver.findElement(By.xpath("//div[@class='search-page__box-title']"))
                    .getText().contains("стив")); //в задании было другое слово, но по нему можно что-то найти на сайте
        }
    }
}
