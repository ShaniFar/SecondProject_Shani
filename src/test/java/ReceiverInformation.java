import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//screen 4
public class ReceiverInformation extends BasePage {

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void receiverInformation() throws InterruptedException {
        pressRadioButton();
        receiverPresentName();
        pickAnEvent();
        enterBlessing();
        uploadPicture();
        pressContinued();

    }

    //בחירת ערך "למישהו אחר"
    private void pressRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("button-forSomeone"))).click();
    }

    //הזנת שם מקבל המתנה
    private void receiverPresentName() throws InterruptedException {
        WebElement receiverPresentName = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember2424\"]"));
        Thread.sleep(2500);
        receiverPresentName.sendKeys("Yael");
        String receiver = "Yael";
        Assert.assertEquals(DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember2424\"]")).getAttribute("value"), receiver);
    }

    //בחירת אירוע
    private void pickAnEvent() throws InterruptedException {
        WebElement mySelection = DriverSingleton.getDriverInstance().findElement(By.className("selected-name"));
        wait.until(ExpectedConditions.elementToBeClickable(mySelection));
        mySelection.click();
        WebElement valueInSelection = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember2519\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(mySelection));
        valueInSelection.click();
    }

    //הזנת ברכה
    private void enterBlessing() {
        DriverSingleton.getDriverInstance().findElement(By.className("parsley-success")).clear();
        DriverSingleton.getDriverInstance().findElement(By.className("parsley-success")).sendKeys("ברכות ליום הולדתך");
    }

    //העלאת תמונה
    private void uploadPicture() throws InterruptedException {
        Thread.sleep(5000);
        WebElement picture = DriverSingleton.getDriverInstance().findElement(By.id("ember2444"));
        Thread.sleep(5000);
        picture.sendKeys("C:\\Users\\shani_f\\Pictures\\Snow\\IMG_6107.JPG");
    }

    //לחיצה על המשך
    private void pressContinued() throws InterruptedException {
        Thread.sleep(20000);
        clickElement(By.cssSelector("button[type=submit]"));
    }


}
