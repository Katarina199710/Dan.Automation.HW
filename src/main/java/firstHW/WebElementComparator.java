package firstHW;

import org.openqa.selenium.*;
import utils.DriverInit;
import utils.Urls;

public class WebElementComparator {
    public static void compareWebElements(WebElement element1, WebElement element2) {
        Point location1 = element1.getLocation();
        Dimension size1 = element1.getSize();

        Point location2 = element2.getLocation();
        Dimension size2 = element2.getSize();

        if (location1.getY() < location2.getY()) {
            System.out.println("Element 1 is higher on the page than Element 2.");
        } else if (location1.getY() > location2.getY()) {
            System.out.println("Element 2 is higher on the page than Element 1.");
        } else {
            System.out.println("Element 1 and Element 2 are at the same height on the page.");
        }

        if (location1.getX() < location2.getX()) {
            System.out.println("Element 1 is on the left side of the page compared to Element 2.");
        } else if (location1.getX() > location2.getX()) {
            System.out.println("Element 2 is on the left side of the page compared to Element 1.");
        } else {
            System.out.println("Element 1 and Element 2 are at the same horizontal position on the page.");
        }

        int area1 = size1.getWidth() * size1.getHeight();
        int area2 = size2.getWidth() * size2.getHeight();

        if (area1 > area2) {
            System.out.println("Element 1 occupies a larger area than Element 2.");
        } else if (area1 < area2) {
            System.out.println("Element 2 occupies a larger area than Element 1.");
        } else {
            System.out.println("Element 1 and Element 2 occupy the same area.");
        }
    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.myShop);
        WebElement element1 = driver.findElement(By.linkText("Women"));
        WebElement element2 = driver.findElement(By.xpath("//a[@class='item-link'][1]"));
        WebElementComparator.compareWebElements(element1, element2);
        driver.quit();
    }
}
