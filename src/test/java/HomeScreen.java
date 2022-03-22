import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//screen 2
public class HomeScreen extends BasePage {
    //    private static WebDriverWait wait;
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void loggedIn() throws InterruptedException {
        pickPricePoint();
        PickRegion();
        PickCategory();
        pressChooseGift();
    }

    private void pickPricePoint() throws InterruptedException {
        WebElement price = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(price));
        price.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();
    }

    private void PickRegion() {
        clickElement(By.cssSelector("span[alt=אזור]"));
        clickElement(By.id("ember1103"));
    }

    private void PickCategory() {
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        clickElement(By.id("ember1161"));

//        WebElement category = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=קטגוריה]"));
//        wait.until(ExpectedConditions.elementToBeClickable(category));
//        category.click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember2563"))).click();
    }

    private void pressChooseGift() {
        clickElement(By.id("ember1188"));
    }


}
