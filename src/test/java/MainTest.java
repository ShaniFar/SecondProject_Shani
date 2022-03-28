import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class MainTest {

    //הגדרת משתנים להפקת דוחות
    private static ExtentReports extent;
    private static ExtentTest test;
    String timeNow = String.valueOf(System.currentTimeMillis());

    @BeforeClass
    public void beforeAll() throws Exception {

        //יצירת אובייקטי הפקת דוחות

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");

        // log results
        test.log(Status.INFO, "@Before class");

        try {
            DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
            DriverSingleton.getDriverInstance().manage().window().maximize();
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }

    }

    @Test
    //הרשמה לאתר
    public void test01_testLogin() throws InterruptedException {
        try {
            LoginPage loginPage = new LoginPage();
            loginPage.login();
            test.log(Status.PASS, "test 1 testLogin passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 2 testLogin failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test
    //בחירת הגדרות מתנה
    public void test02_loggedIn() throws InterruptedException {
        try {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.loggedIn();
            test.pass("test 2 loggedIn passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 2 loggedIn failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
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
            test.pass("test 3 PickBusiness passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 3 PickBusiness failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }

    @Test
    //הזנת פרטי מקבל המתנה
    public void test_04_ReceiverInformation() throws InterruptedException {
        try {
            ReceiverInformation receiverInformation = new ReceiverInformation();
            receiverInformation.receiverInformation();
            test.pass("test 4 ReceiverInformation passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 4 ReceiverInformation failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }


    }

    @Test
    //הזנת פרטי שולח המתנה
    public void test_05_sendInformation() {
        try {
            SendInformation sendInformation = new SendInformation();
            sendInformation.sendInformation();
            test.pass("test 4 sendInformation passed");
        } catch (Exception e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "test 5 sendInformation failed" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
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