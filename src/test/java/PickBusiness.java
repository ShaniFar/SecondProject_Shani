import org.openqa.selenium.By;

//screen 3
public class PickBusiness extends BasePage{

    public void pickBusiness(){
        selectBusiness();
        choosePrice();
        pressChoose();
    }
private void selectBusiness()
{
    clickElement(By.xpath("//*[@id=\"ember1481\"]"));
}
private void choosePrice(){
        sendKeysToElement(By.xpath("//*[@id=\"ember1755\"]"), "200");

}

private void pressChoose(){
        clickElement(By.xpath("//*[@id=\"ember1753\"]/div[2]"));
}
}
