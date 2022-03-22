import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//screen 2
public class HomeScreen extends BasePage {
    //    private static WebDriverWait wait;
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    //בחירת ערכים למתנות
    public void loggedIn() throws InterruptedException {
        pickPricePoint();
        PickRegion();
        PickCategory();
        pressChooseGift();
    }
//בחירת סכום
    private void pickPricePoint() throws InterruptedException {
        WebElement price = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(price));
        price.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();
    }
//בחירת איזור
    private void PickRegion() {
        clickElement(By.cssSelector("span[alt=אזור]"));
        clickElement(By.id("ember1103"));
    }
//בחירת קטגוריה
    private void PickCategory() {
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        clickElement(By.id("ember1161"));
    }
//לחיצה על בחירת מתנה
    private void pressChooseGift() {
        clickElement(By.id("ember1188"));
    }


}
