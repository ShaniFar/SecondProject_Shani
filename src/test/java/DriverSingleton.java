import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton
//מחלקה ליצירת דרייבר
{
    private static WebDriver driver;

    public static WebDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }

        return driver;
    }
}