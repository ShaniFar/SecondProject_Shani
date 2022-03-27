import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//screen 5
public class SendInformation extends BasePage {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void sendInformation() {
        pressRadioButtonNow();
        pickEmail();
        insertMail();
//        assertSender();
        clickForPay();
    }

    //בחירת ערך עכשיו
    private void pressRadioButtonNow() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("button-now"))).click();
        clickElement(By.className(("button-now")));
    }

    //בחירת האופציה של אימייל
    private void pickEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[gtm=method-email]"))).click();
    }

    //הזנת אימייל
    private void insertMail() {
        sendKeysToElement(By.id("email"), "sp0548412037@gmail.com");
    }

 /*   //הזנת שולח והשוואת הערכים
    private void assertSender() {
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).clear();
      sendKeysToElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input"), "Shani");
        String sender = "Shani";
        Assert.assertEquals(sender, DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).getAttribute("value"));
    }*/

    //לחיצה על לתשלום
    private void clickForPay() {
//      WebElement clickPay = DriverSingleton.getDriverInstance().findElement(By.id("ember2593"));
       /* WebElement clickPay = DriverSingleton.getDriverInstance().findElement(By.className("label"));
        wait.until(ExpectedConditions.elementToBeClickable(clickPay));
        clickPay.click();*/
        wait.until(ExpectedConditions.elementToBeClickable(By.className("bm-btn"))).click();
    }
}