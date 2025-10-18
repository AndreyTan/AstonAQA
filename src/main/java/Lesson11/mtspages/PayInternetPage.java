package Lesson11.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayInternetPage extends PagePayServices {


    public PayInternetPage(WebDriver driver) {
        super(driver, "Домашний интернет");
    }

    private WebElement getInputInternetPhone() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-internet\"]//input[@id=\"internet-phone\"]"));
    }

    private WebElement getInputInternetSum() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-internet\"]//input[@id=\"internet-sum\"]"));
    }

    private WebElement getInputInternetEmail() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-internet\"]//input[@id=\"internet-email\"]"));
    }

    public void enterInternetPhone(String phone) {
        enterToInputElement(getInputInternetPhone(), phone);
    }

    public void enterSum(String sum) {
        enterToInputElement(getInputInternetSum(), sum);
    }

    public void enterEmail(String email) {
        enterToInputElement(getInputInternetEmail(), email);
    }

    public boolean checkPlaceholders(String phone, String sum, String email) {
        return phone.equals(getInputInternetPhone().getAttribute("placeholder")) &&
                sum.equals(getInputInternetSum().getAttribute("placeholder")) &&
                email.equals(getInputInternetEmail().getAttribute("placeholder"));
    }

}
