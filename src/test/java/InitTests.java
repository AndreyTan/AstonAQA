import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class InitTests {
    private static WebDriver _driver;

    public static WebDriver getDriver(){
        if(_driver == null)
            return new ChromeDriver();
        return _driver;
    }

    public static void initSetUpTests() {
        System.out.println("Онлайн пополнение\nбез комиссии".matches("Онлайн пополнение.*без комиссии"));
        WebDriverManager.chromedriver().setup();
        _driver = new ChromeDriver();
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        openMTS();
    }

    public static void openMTS(){
        _driver.get("https://mts.by/");
        try{
            _driver.findElement(By.xpath("//button[@class=\"btn btn_gray cookie__cancel\"]")).click();
        } catch (Exception ex){
            //System.out.println(ex);
        }
    }


}
