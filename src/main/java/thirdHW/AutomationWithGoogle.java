package thirdHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utils.DriverInit;
import utils.Urls;

public class AutomationWithGoogle {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.google);
    }
}
