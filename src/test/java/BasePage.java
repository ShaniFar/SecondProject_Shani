
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;



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

    public void sendKeysToElementList(int index, String text, List <WebElement> list) {
        list.get(index).sendKeys(text);
    }

    public WebElement getWebElementFromList(List <WebElement> list,int index)
    {
        return list.get(index);
    }

    public void clickElementInList(List <WebElement> list,int index){
        list.get(index).click();
    }

    public WebElement getWebElement(By locator)
    //פונקציה למציאת אלמנט - משמשת לשתי הפונקציות העליונות
    {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }



}
