package Lesson11.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PayFormPage {
    private WebDriver driver;

    public PayFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLink() {
        return driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//a")).getAttribute("href");
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]/h2")).getText();
    }

    public List<WebElement> getLogos() {
        return driver.findElements(By.xpath("//div[@class=\"pay__partners\"]//li/img"));
    }

}
