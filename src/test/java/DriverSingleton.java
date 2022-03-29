import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DriverSingleton
//מחלקה ליצירת דרייבר
{
    private static WebDriver driver;


    public static WebDriver getDriverInstance() {
        String type = BasePage.getData("browserType");
        if (driver == null) {
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            } else if (type.equals("Edge")) {
                System.setProperty("webdriver.edge.driver", Constant.EDGEDRIVER_PATH);
                driver = new EdgeDriver();
            }
        }
        return driver;
    }


}