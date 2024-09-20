package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Actions {
    private WebDriver driver;
    private WebDriverWait wait;

    public Actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera de 10 segundos
    }

    public By locationElement(String typelocation, String locator) {
        By location = null;
        switch (typelocation.toUpperCase()) {
            case "CLASSNAME":
                location = By.className(locator);
                break;
            case "ID":
                location = By.id(locator);
                break;
            case "XPATH":
                location = By.xpath(locator);
                break;
            default:
                System.out.println("Can't find the type location");
        }
        return location;
    }

    public void openUrl(String url) {
        this.driver.get(url);
    }

    public void clickElement(String typeLocation, String locator) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.locationElement(typeLocation, locator)));
        this.driver.findElement(this.locationElement(typeLocation, locator)).click();
    }

    public void sendKeys(String typeLocation, String locator, String textToSend) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.locationElement(typeLocation, locator)));
        this.driver.findElement(this.locationElement(typeLocation, locator)).sendKeys(textToSend);
    }

    public String clickRandomElement(String typeLocation, String locator) {
        List<WebElement> elements = this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.locationElement(typeLocation, locator)));
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("No elements found for the given locator: "+elements+""+locator);
        }
        Random random = new Random();
        int index = random.nextInt(elements.size());
        WebElement element = elements.get(index);
        String text = element.getText();
        System.out.println("This is the text: "+text);
        element.click();
        return text;
    }

    public void assertText(String typeLocation, String locator, String textWait) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.locationElement(typeLocation, locator)));
        String text = this.driver.findElement(this.locationElement(typeLocation, locator)).getText();
        Assert.assertEquals(text, textWait);
    }

    public void clickAlert() {
        this.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }

    public boolean validateVisible(String typeLocation, String locator) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.locationElement(typeLocation, locator)));
            return this.driver.findElement(this.locationElement(typeLocation, locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
