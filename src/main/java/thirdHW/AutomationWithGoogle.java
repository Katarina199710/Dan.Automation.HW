package thirdHW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverInit;
import utils.Urls;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AutomationWithGoogle {
    private static class Locators {
        private static final By googleSearch = By.id("APjFqb");
        private static final By guinnessCreateAccount = By.xpath("//h3[text()='Create account'][1]");
        private static final By clearButton = By.xpath("//span[@class='ExCKkf z1asCe rzyADb']");
        private static final By alertsDemo = By.xpath("//h3[text()='AlertsDemo']");
        private static final By iFrame = By.id("iframeResult");
        private static final By nameField = By.id("fname");
        private static final By lastNameField = By.id("lname");
        private static final By submitButton = By.xpath("//input[@value='Submit']");
        private static final By note = By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']");
        private static final By guinnessLastNameField = By.id("LastName");
        private static final By guinnessNameField = By.id("FirstName");
        private static final By birthDayField = By.id("DateOfBirthDay");
        private static final By birthMonthField = By.id("DateOfBirthMonth");
        private static final By birthYearField = By.id("DateOfBirthYear");
        private static final By selectCountry = By.id("Country");
        private static final By inputCity = By.id("State");
        private static final By inputMail = By.id("EmailAddress");
        private static final By confirmMail = By.id("ConfirmEmailAddress");
        private static final By inputPassword = By.id("Password");
        private static final By confirmPassword = By.id("ConfirmPassword");
        private static final By validationPassword = By.xpath("//span[@for='ConfirmPassword']");

    }
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.google);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.findElement(Locators.googleSearch).sendKeys(Urls.recordRegister);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        actions.moveToElement(driver.findElement(Locators.guinnessCreateAccount)).keyDown(Keys.COMMAND)
                .click().keyUp(Keys.COMMAND)
                .build().perform();
        driver.findElement(Locators.clearButton).click();
        driver.findElement(Locators.googleSearch).sendKeys(Urls.alertsDemo);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        actions.moveToElement(driver.findElement(Locators.alertsDemo)).keyDown(Keys.COMMAND)
                .click().keyUp(Keys.COMMAND)
                .build().perform();
        driver.navigate().to(Urls.w3SchoolSubmitForm);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.iFrame));
        driver.findElement(Locators.nameField).clear();
        driver.findElement(Locators.nameField).sendKeys("Katrin");
        driver.findElement(Locators.lastNameField).clear();
        driver.findElement(Locators.lastNameField).sendKeys("Kolomiets");
        driver.findElement(Locators.submitButton).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.note)).getText());
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandles = new ArrayList<>(allWindows);
        for (String window : windowHandles) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains(Urls.recordRegister)) {
                    break;
                }
            }
        }

        driver.findElement(Locators.guinnessLastNameField).sendKeys("Kolomiets");
        driver.findElement(Locators.guinnessNameField).sendKeys("Katrin");
        driver.findElement(Locators.birthDayField).sendKeys("31");
        driver.findElement(Locators.birthMonthField).sendKeys("12");
        driver.findElement(Locators.birthYearField).sendKeys("1997");
        Select country = new Select(driver.findElement(Locators.selectCountry));
        country.selectByVisibleText("Ukraine");
        driver.findElement(Locators.inputCity).sendKeys("Kyiv");
        driver.findElement(Locators.inputMail).sendKeys("gratemail@mail.cmm");
        driver.findElement(Locators.confirmMail).sendKeys("gratemail@mail.cmm");
        driver.findElement(Locators.inputPassword).sendKeys("Password");
        driver.findElement(Locators.confirmPassword).sendKeys("Password1");
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.validationPassword)).getText());

        for (String window : windowHandles) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(windowHandles.get(2));
                if (driver.getCurrentUrl().contains(Urls.alertsDemo)) {
                    break;
                }
            }
        }
    }
}
