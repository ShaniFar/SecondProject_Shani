import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton
//מחלקה ליצירת דרייבר
{
    private static WebDriver driver;

    public static WebDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\shani_f\\Documents\\Automation\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }
}
