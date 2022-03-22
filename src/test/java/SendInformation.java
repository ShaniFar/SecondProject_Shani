import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

//screen 5
public class SendInformation extends BasePage {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void sendInformation() throws InterruptedException {
        pressRadioBottomNow();
        pickEmail();
        insertMail();
        assertSender();
        clickForPay();
    }
//בחירת ערך עכשיו
    private void pressRadioBottomNow() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("button-now"))).click();
        clickElement(By.className(("button-now")));
    }
//בחירת האופציה של אימייל
    private void pickEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[gtm=method-email]"))).click();
    }
//הזנת אימייל
    private void insertMail() {
        sendKeysToElement(By.id("ember2596"), "sp0548412037@gmail.com");
    }
//הזנת שולח והשוואת הערכים
    private void assertSender() {
        DriverSingleton.getDriverInstance().findElement(By.cssSelector("input[maxlength=25]")).clear();
        sendKeysToElement(By.cssSelector("input[maxlength=25]"), "Shani");
        String sender = "Shani";
        Assert.assertEquals(sender, DriverSingleton.getDriverInstance().findElement(By.cssSelector("input[maxlength=25]")).getAttribute("value"));
    }
//לחיצה על לתשלום
    private void clickForPay() throws InterruptedException {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember2593"))).click();
      Thread.sleep(5000);
       clickElement(By.id("ember2673"));
    }
}
