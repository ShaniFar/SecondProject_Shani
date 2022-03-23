import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public void clickElement(By locator)
    //פונקצית תשתית ללחיצה על אלמנטים
    {
        getWebElement(locator).click();
    }
    public void sendKeysToElement(By locator, String text)
    //פונקצית תשתית לשליחת ערך לאלמנטים
    {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator)
    //פונקציה למציאת אלמנט - משמשת לשתי הפונקציות העליונות
    {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }


}
