import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InitTests {

    public static ChromeDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void openMTS(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mts.by/");
        try {
            driver.findElement(By.xpath("//button[@class=\"btn btn_gray cookie__cancel\"]")).click();
        } catch (Exception ex) {
            //System.out.println(ex);
        }
    }


}
