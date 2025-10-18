package Lesson11.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class PayPhonePage extends PagePayServices {

    public PayPhonePage(WebDriver driver) {
        super(driver, "Услуги связи");
    }

    private WebElement getInputPhone() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-phone\"]"));
    }

    private WebElement getInputSum() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-sum\"]"));
    }

    private WebElement getInputEmail() {
        return this.driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//input[@id=\"connection-email\"]"));
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
        String titleCost = this.driver.findElement(By.xpath("//div[@class=\"pay-description__cost ng-star-inserted\"]//span")).getAttribute("textContent");
        String btnCost = this.driver.findElement(By.xpath("//div[@class=\"card-page__card\"]//button[@type=\"submit\"]")).getAttribute("textContent");

        return titleCost.matches(".*" + sum + ".*") && btnCost.matches(".*" + sum + ".*");
    }

    public boolean checkPhoneNumber(String phone) {
        String phoneTitle = this.driver.findElement(By.xpath("//div[@class=\"pay-description__text\"]//span")).getAttribute("textContent");
        phoneTitle = phoneTitle.replace('\n', ' ');

        return phoneTitle.matches(".*375" + phone + ".*");
    }

    public boolean checkPlaceholders() {
        String phdCard = this.driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-3 ng-star-inserted\"]")).getAttribute("textContent");
        String phdTime = this.driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-6 ng-star-inserted\"]")).getAttribute("textContent");
        String phdCVC = this.driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-7 ng-star-inserted\"]")).getAttribute("textContent");
        String phdName = this.driver.findElement(By.xpath("//label[@class=\"ng-tns-c2312288139-5 ng-star-inserted\"]")).getAttribute("textContent");

        return phdCard.matches(".*Номер карты.*") &&
                phdTime.matches(".*Срок действия.*") &&
                phdCVC.matches(".*CVC.*") &&
                phdName.matches(".*Имя и фамилия на карте.*");

    }

    public boolean checkIcons() {
        HashSet<String> logos = new HashSet<>(5);
        ArrayList<String> foundLogos = new ArrayList<>(5);
        logos.add("visa");
        logos.add("belkart");
        logos.add("mastercard");
        logos.add("maestro");
        logos.add("mir");

        List<WebElement> icons = this.driver.findElements(By.xpath("//img[@class=\"ng-tns-c891095944-2 ng-star-inserted\"]"));
        List<WebElement> groupIcons = this.driver.findElements(By.xpath("//div[contains(@class, 'cards-brands_random')]//img"));

        for(WebElement elem : icons){
            foundLogos.add(elem.getAttribute("src"));
        }
        for(WebElement elem : groupIcons){
            foundLogos.add(elem.getAttribute("src"));
        }

        for (String logo : logos) {
            String patternLogo = ".*" + logo + ".*";
            Pattern pattern = Pattern.compile(patternLogo);
            boolean found = false;

            for(String foundLogo : foundLogos){
                if (pattern.matcher(foundLogo).find()) {
                    found = true;
                }
            }
            if(!found)
                return false;
        }

        return true;
    }

    public void fillForm(String phone, String sum,boolean needSwitch){
        enterPhone(phone);
        enterSum(sum);
        clickContinue();
        if(needSwitch)
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));
    }

}
