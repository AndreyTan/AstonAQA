package lesson10.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayArrearsPage extends PagePayServices {

    public PayArrearsPage(WebDriver driver) {
        super(driver,"Задолженность");
    }

    private WebElement getInputScore(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-arrears\"]//input[@id=\"score-arrears\"]"));
    }

    private WebElement getInputSum(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-arrears\"]//input[@id=\"arrears-sum\"]"));
    }

    private WebElement getInputEmail(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-arrears\"]//input[@id=\"arrears-email\"]"));
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
