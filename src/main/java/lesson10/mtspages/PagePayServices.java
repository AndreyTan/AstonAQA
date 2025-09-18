package lesson10.mtspages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PagePayServices {
    protected WebDriver _driver;
    protected String _nameSelector;

    public PagePayServices(WebDriver driver, String nameSelector){
        this._driver = driver;
        this._nameSelector = nameSelector;
    }

    protected WebElement getBtnSelector(){
        return this._driver.findElement(By.xpath("//div[@class=\"pay__form\"]//button[@class=\"select__header\"]"));
    }

    protected WebElement getBtnFromListSelector(){
        return this._driver.findElement(By.xpath("//ul[@class=\"select__list\"]//p[text()=\"" + _nameSelector + "\"]"));
    }

    protected WebElement getBtnContinue(){
        return this._driver.findElement(By.xpath("//form[@id=\"pay-connection\"]//button[@class=\"button button__default \"]"));
    }

    public void clickContinue(){
        getBtnContinue().click();
    }

    protected void enterToInputElement(WebElement elem,String val){
        elem.click();
        elem.sendKeys(val);
    }

    public void openPage(){
        getBtnSelector().click();
        getBtnFromListSelector().click();
    }

}
