package Base_Package;


import Pages.A_Home_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;


public class base {
    protected WebDriver d;
    protected A_Home_Page Home_obj;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        d= new ChromeDriver();
        d.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
//        d.get("https://www.google.com/");
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        d.manage().window().maximize();
        Home_obj=new A_Home_Page(d);

    }
    @AfterMethod
    public void end(ITestResult result) throws InterruptedException {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) d;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(5000);
        d.quit();

    }

    public Wait waitf(){
        Wait wait = new FluentWait( d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }


}
