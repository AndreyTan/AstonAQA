package lesson10.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PayPhonePage extends PagePayServices {

    public PayPhonePage(WebDriver driver) {
        super(driver, "Услуги связи");
    }

    private WebElement getInputPhone() {
        return this._driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-phone\"]"));
    }

    private WebElement getInputSum() {
        return this._driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-sum\"]"));
    }

    private WebElement getInputEmail() {
        return this._driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-email\"]"));
    }

    public void enterPhone(String phone) {
        enterToInputElement(getInputPhone(), phone);
    }

    public void enterSum(String sum) {
        enterToInputElement(getInputSum(), sum);
    }

    public void enterEmail(String email) {
        enterToInputElement(getInputEmail(), email);
    }

    public boolean checkPlaceholders(String phone, String sum, String email) {
        return phone.equals(getInputPhone().getAttribute("placeholder")) &&
                sum.equals(getInputSum().getAttribute("placeholder")) &&
                email.equals(getInputEmail().getAttribute("placeholder"));
    }

    public boolean checkSum(double sum) {
        String titleCost = this._driver.findElement(By.xpath("//div[@class=\"pay-description__cost\"]//span")).getAttribute("textContent");
        String btnCost = this._driver.findElement(By.xpath(" //div[@class=\"card-page__card\"]//button[@type=\"submit\"]")).getAttribute("textContent");

        return titleCost.matches(".*" + sum + ".*") && btnCost.matches(".*" + sum + ".*");
    }

    public boolean checkPhoneNumber(String phone) {
        String phoneTitle = this._driver.findElement(By.xpath("//div[@class=\"pay-description__text\"]//span")).getAttribute("textContent");
        phoneTitle = phoneTitle.replace('\n', ' ');

        return phoneTitle.matches(".*375" + phone + ".*");
    }

    public boolean checkPlaceholders() {
        String phdCard = this._driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-1 ng-star-inserted\"]")).getAttribute("textContent");
        String phdTime = this._driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-4 ng-star-inserted\"]")).getAttribute("textContent");
        String phdCVC = this._driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-5 ng-star-inserted\"]")).getAttribute("textContent");
        String phdName = this._driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-3 ng-star-inserted\"]")).getAttribute("textContent");

        return phdCard.matches(".*Номер карты.*") &&
                phdTime.matches(".*Срок действия.*") &&
                phdCVC.matches(".*CVC.*") &&
                phdName.matches(".*Имя и фамилия на карте.*");

    }

    public int checkIcons() {
        List<WebElement> icons = this._driver.findElements(By.xpath("//img[@class='ng-tns-c891095944-0 ng-star-inserted']"));
        WebElement groupIcons = null;

        try {
            groupIcons = this._driver.findElement(By.xpath("//div[contains(@class,'cards-brands_random')]"));
        } catch (Exception ex) {
            //System.out.println(ex);
        }


        return icons.size() + (groupIcons != null ? 1 : 0);
    }

}
