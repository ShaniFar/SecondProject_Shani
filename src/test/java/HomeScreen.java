import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(By.cssSelector("span[alt=סכום]"))));
        clickElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();
    }
//בחירת איזור
    private void PickRegion() throws InterruptedException {
        clickElement(By.cssSelector("span[alt=אזור]"));
        Thread.sleep(2000);
        clickElement(By.id("ember1103"));
    }
//בחירת קטגוריה
    private void PickCategory() throws InterruptedException {
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        Thread.sleep(2000);
        clickElement(By.id("ember1161"));
    }
//לחיצה על בחירת מתנה
    private void pressChooseGift() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(By.id("ember1188"));
    }


}
