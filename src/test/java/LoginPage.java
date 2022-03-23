import org.openqa.selenium.By;
import org.testng.Assert;

//screen 1
public class LoginPage extends BasePage {
    public void login()
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
    private void enterValues() {
        sendKeysToElement(By.xpath("//*[@id=\"ember1795\"]"), Constant.name);
        String name = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1795\"]")).getAttribute("value");
        Assert.assertEquals(name, Constant.name);
        sendKeysToElement(By.xpath("//*[@id=\"ember1802\"]"), Constant.email);
        String email = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1802\"]")).getAttribute("value");
        Assert.assertEquals(email, Constant.email);
        sendKeysToElement(By.id("valPass"), Constant.password);
        String password = DriverSingleton.getDriverInstance().findElement(By.id("valPass")).getAttribute("value");
        Assert.assertEquals(password, Constant.password);
        sendKeysToElement(By.xpath("//*[@id=\"ember1816\"]"), Constant.password);
        String passwordAuthentication = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1816\"]")).getAttribute("value");
        Assert.assertEquals(passwordAuthentication, Constant.password);

    }

    //לחיצה על הרשמה לBUYME
    private void pressRegistrationConfirmation() {
        clickElement(By.xpath("//*[@id=\"ember1822\"]/span"));
    }


}
