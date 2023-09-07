package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class C_MakePayment_Page {
    private WebDriver d;

    public C_MakePayment_Page(WebDriver d) {
        this.d = d;
    }
    private By  PaybyCreditCard = By.xpath("//a[text()=\"Pay by Credit Card\"]");

    public boolean Validate_PaybyCreditCardtxt(String expectedname) {
       return d.findElement(PaybyCreditCard).getText().contains(expectedname);
    }


    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }
}
