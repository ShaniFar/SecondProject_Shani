import org.openqa.selenium.By;
import org.testng.Assert;

//screen 1
public class LoginPage extends BasePage {
    public void login()
    //פונקצית הלוגין - תהליך הלוגין
    {
        pressRegister();
        pressRegister2();
        enterValues();
        pressRegister3();
    }

    private void pressRegister() {
        clickElement(By.xpath("//*[@id=\"ember993\"]/div/ul[1]/li[3]/a/span"));
    }

    private void pressRegister2() {
        clickElement(By.className("text-link"));
    }

    private  void enterValues() {

        sendKeysToElement(By.xpath("//*[@id=\"ember1795\"]"), Constant.name);
        String name = DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1795\"]")).getAttribute("value");
        System.out.println(name);
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

    private void assertLoginValues() {

        String firstName = "Shani";
        String email = "sp0548412037@gmail.com";
        String password = "Sp123456";

    }

    private void pressRegister3() {
        clickElement(By.xpath("//*[@id=\"ember1822\"]/span"));
    }


}
