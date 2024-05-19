package firstHW;

import org.openqa.selenium.*;
import utils.DriverInit;
import utils.Urls;

public class InfoAboutElement {
    public static void printElementInfo(WebElement element) {
        String id = element.getAttribute("id");
        String tagName = element.getTagName();
        String className = element.getAttribute("class");
        String name = element.getAttribute("name");
        String text = element.getText();
        Point location = element.getLocation();
        Dimension size = element.getSize();

        int centerX = location.getX() + size.getWidth() / 2;
        int centerY = location.getY() + size.getHeight() / 2;

        System.out.println("Element ID: " + (id.isEmpty() ? "Not available" : id));
        System.out.println("Tag Name: " + tagName);
        System.out.println("Class: " + (className.isEmpty() ? "Not available" : className));
        System.out.println("Name: " + (name.isEmpty() ? "Not available" : name));
        System.out.println("Text: " + (text.isEmpty() ? "Not available" : text));
        System.out.println("Center Coordinates: (" + centerX + ", " + centerY + ")");
    }

    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.uhomki);
        WebElement element = driver.findElement(By.xpath("//img[@alt='Інтернет-зоомагазин \"У Хомки\"']"));
        InfoAboutElement.printElementInfo(element);
        driver.quit();
    }
}
