package firstHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utils.DriverInit;
import utils.Urls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OpenSeparateWindows {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.taxi838);
        Set<String> urls = new HashSet<>();
        urls.add(Urls.zoo);
        urls.add(Urls.w3School);
        urls.add(Urls.klopotenko);
        for (String url : urls) {
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get(url);
        }
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        for (String window : windows) {
            driver.switchTo().window(window);
            String pageTitle = driver.getTitle();
            String pageURL = driver.getCurrentUrl();
            System.out.println("Page Title: " + pageTitle);
            System.out.println("Page URL: " + pageURL);
            if (pageTitle.toLowerCase().contains("зоопарк")) {
                driver.close();
            }
        }
        driver.quit();
    }
}
