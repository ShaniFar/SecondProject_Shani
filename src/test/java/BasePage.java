import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

    public void sendKeysToElementList(int index, String text, List<WebElement> list)
    //פונקציה לשליחת ערך לאלמנט שהוא חלק מרשימה
    {
        list.get(index).sendKeys(text);
    }

    public WebElement getWebElementFromList(List<WebElement> list, int index)
    //פונקציה לשליפת אלמנט מתוך רשימה
    {
        return list.get(index);
    }

    public void clickElementInList(List<WebElement> list, int index)
    //פונקציה ללחיצה על אלמנט שהוא חלק מרשימה
    {
        list.get(index).click();
    }


    public WebElement getWebElement(By locator)
    //פונקציה למציאת אלמנט - משמשת לשתי הפונקציות העליונות
    {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }


    public static String getData(String keyName) {
        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}