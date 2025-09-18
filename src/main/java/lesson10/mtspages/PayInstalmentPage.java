package lesson10.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayInstalmentPage extends PagePayServices {

    public PayInstalmentPage(WebDriver driver) {
        super(driver,"Рассрочка");
    }

    private WebElement getInputScore(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-instalment\"]//input[@id=\"score-instalment\"]"));
    }

    private WebElement getInputSum(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-instalment\"]//input[@id=\"instalment-sum\"]"));
    }

    private WebElement getInputEmail(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-instalment\"]//input[@id=\"instalment-email\"]"));
    }

    public void enterScore(String score){
        enterToInputElement(getInputScore(),score);
    }

    public void enterSum(String sum){
        enterToInputElement(getInputSum(),sum);
    }

    public void enterEmail(String email){
        enterToInputElement(getInputEmail(),email);
    }

    public boolean checkPlaceholders(String score,String sum, String email){
        return score.equals(getInputScore().getAttribute("placeholder")) &&
                sum.equals(getInputSum().getAttribute("placeholder")) &&
                email.equals(getInputEmail().getAttribute("placeholder"));
    }
}
