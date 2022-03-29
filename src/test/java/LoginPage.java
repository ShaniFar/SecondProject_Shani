import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

//screen 1
public class LoginPage extends BasePage {
    public void login() throws InterruptedException
    //פונקצית הלוגין - תהליך הלוגין
    {
        pressRegister();
        pressRegisterInRegistrationWindow();
        enterValues();
        pressRegistrationConfirmation();
    }

    //לחיצה על כניסה\הרשמה
    private void pressRegister() {
        clickElement(By.xpath("//*[@id=\"ember993\"]/div/ul[1]/li[3]/a/span"));
    }

    //לחיצה על הרשמה
    private void pressRegisterInRegistrationWindow() {
        clickElement(By.className("text-link"));
    }

    //הכנסת ערכים לשדות ההרשמה
    private void enterValues() throws InterruptedException {
        List<WebElement> elements = DriverSingleton.getDriverInstance().findElements(By.tagName("input"));
        sendKeysToElementList(0, Constant.name, elements);
        Thread.sleep(5000);
        String name = getWebElementFromList(elements, 0).getAttribute("value");
        Assert.assertEquals(name, Constant.name);
        sendKeysToElementList(1, Constant.email, elements);
        Thread.sleep(2000);
        String email = getWebElementFromList(elements, 1).getAttribute("value");
        Assert.assertEquals(email, Constant.email);
        sendKeysToElementList(2, Constant.password, elements);
        Thread.sleep(2000);
        String password = getWebElementFromList(elements, 2).getAttribute("value");
        Assert.assertEquals(password, Constant.password);
        sendKeysToElementList(3, Constant.password, elements);
        Thread.sleep(2000);
        String passwordAuthentication = getWebElementFromList(elements, 3).getAttribute("value");
        Assert.assertEquals(password, Constant.password);


    }

    //לחיצה על הרשמה לBUYME
    private void pressRegistrationConfirmation() {
        clickElement(By.xpath("//*[@id=\"ember1822\"]"));
    }


}