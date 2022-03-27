import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class MainTest {

    //הגדרת משתנים להפקת דוחות
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");


    @BeforeClass
    public void beforeAll() {
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
        DriverSingleton.getDriverInstance().manage().window().maximize();
       //יצירת אובייקטי הפקת דוחות
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");

    }

    @Test
    //הרשמה לאתר
    public void test01_testLogin() throws InterruptedException {
       try {
           LoginPage loginPage = new LoginPage();
           loginPage.login();
           test.log(Status.PASS, "test 1 passed");
       } catch (Exception e)
       {
           e.printStackTrace();
           String timeNow = String.valueOf(System.currentTimeMillis());
           test.log(Status.FAIL,"test 2 failed"+e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
       }
    }

    @Test
    //בחירת הגדרות מתנה
    public void test02_loggedIn() throws InterruptedException {
        try {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.loggedIn();
            test.pass("test 2 passed");
        } catch (Exception e)
        {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"test 1 failed"+e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }

    @Test
    //כניסה למתנה ובחירת סכום
    public void test03_PickBusiness() {
       try {
           String businessURL = "https://buyme.co.il/search?budget=3&category=204&region=14";
           Assert.assertEquals(businessURL, DriverSingleton.getDriverInstance().getCurrentUrl());
           PickBusiness pickBusiness = new PickBusiness();
           pickBusiness.pickBusiness();
           test.pass("test 3 passed");
       }catch (Exception e)
       {
           e.printStackTrace();
           String timeNow = String.valueOf(System.currentTimeMillis());
           test.log(Status.FAIL,"test 3 failed"+e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
       }

    }

    @Test
    //הזנת פרטי מקבל המתנה
    public void test_04_ReceiverInformation() throws InterruptedException {
       try {
           ReceiverInformation receiverInformation = new ReceiverInformation();
           receiverInformation.receiverInformation();
           test.pass("test 4 passed");
       }catch (Exception e)
       {
           e.printStackTrace();
           String timeNow = String.valueOf(System.currentTimeMillis());
           test.log(Status.FAIL,"test 4 failed"+e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
       }


    }

    @Test
    //הזנת פרטי שולח המתנה
    public void test_05_sendInformation() {
        try {
            SendInformation sendInformation = new SendInformation();
            sendInformation.sendInformation();
            test.pass("test 4 passed");
        }catch (Exception e)
        {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"test 5 failed"+e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        DriverSingleton.getDriverInstance().quit();
        extent.flush();
    }
//פונקצית תשתית ליצירת צילומי מסך
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }


}