import org.openqa.selenium.By;


//screen 3
public class PickBusiness extends BasePage {

    public void pickBusiness() {
        selectBusiness();
        choosePrice();
        pressChoose();
    }

    private void selectBusiness() {
        clickElement(By.id("ember2034"));
    }

    //בחירת מחיר למתנה
    private void choosePrice() {
        sendKeysToElement(By.cssSelector("input[type=tel]"), "200");

    }

    //לחיצה על בחירה
    private void pressChoose() {
        clickElement(By.className("money-btn"));
    }
}

