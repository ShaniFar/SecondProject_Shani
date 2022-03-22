import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class mainTest {
    @BeforeClass
    public void beforeAll() {
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
    }

    @Test
    //הרשמה לאתר
    public void test01_testLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    //כניסה לחשבון  ובחירת הגדרות מתנה
    public void test02_loggedIn() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.loggedIn();
    }

    @Test
    //כניסה למתנה ובחירת סכום
    public void test03_PickBusiness() {
        String businessURL = "https://buyme.co.il/search?budget=3&category=204&region=14";
        Assert.assertEquals(businessURL, DriverSingleton.getDriverInstance().getCurrentUrl());
        PickBusiness pickBusiness = new PickBusiness();
        pickBusiness.pickBusiness();
    }

    @Test
    public void test_04_ReceiverInformation() throws InterruptedException {
        ReceiverInformation receiverInformation = new ReceiverInformation();
        receiverInformation.receiverInformation();
    }

    @Test
    public void test_05_sendInformation(){
        SendInformation sendInformation =new SendInformation();
        sendInformation.sendInformation();
    }
}
