import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//screen 2
public class HomeScreen extends BasePage {
    public void loggedIn() {
       pressLogin();
        enterUserDetails();
        pressIn();
       pickPricePoint();
        PickRegion();
        PickCategory();

    }

   private void pressLogin() {
        clickElement(By.xpath("//*[@id=\"ember993\"]/div/ul[1]/li[3]/a/span"));
    }

   private void enterUserDetails() {
        sendKeysToElement(By.xpath("//*[@id=\"ember1768\"]"), "sp0548412037@gmail.com");
        sendKeysToElement(By.xpath("//*[@id=\"ember1775\"]"), "Sp123456");
    }

   private void pressIn()
    {
       clickElement(By.xpath("//*[@id=\"ember1784\"]"));
    }


   private void pickPricePoint() {
       clickElement(By.cssSelector("span[alt='סכום']"));
       clickElement(By.id("ember2147"));

   }

    private void PickRegion(){
           clickElement(By.cssSelector("span[alt=אזור]"));
           clickElement(By.id("ember2169"));
    }


    private void PickCategory(){
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        clickElement(By.id("ember2200"));
    }


}
