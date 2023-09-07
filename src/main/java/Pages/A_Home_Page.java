package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;

public class A_Home_Page {
    private WebDriver d;

    public A_Home_Page(WebDriver d) {
        this.d = d;
    }

    private By FromTo_filed = By.xpath("//a[text()=\" Chikkamagaluru - Bengaluru\"]");
    private By Departure_filed = By.id("txtJourneyDate");
    private By List_arrival_Date_filed = By.xpath("(//div[@id=\"ui-datepicker-div\"]//td)");

    private By ButtonSearch_filed = By.xpath("//button[contains(text(),\"Search for Bus\")]");

    public void FromTo_Click()  {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(FromTo_filed));
        d.findElement(FromTo_filed).click();
    }
    public void Departure_click()  {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(Departure_filed));
        d.findElement(Departure_filed).click();
    }
//    public void select_arrival_date(){
//        for(int a=1;a<=30;a++){
//            System.out.println(d.findElements(List_arrival_Date_filed).get(a).isEnabled());
//     if( d.findElements(List_arrival_Date_filed).get(a).isEnabled()){
//         d.findElements(List_arrival_Date_filed).get(a).click();break;
//     }
//
//        }
//    }
public void select_arrival_date(int day){

    d.findElements(List_arrival_Date_filed).get(5+day).click();
}
    public  B_services_page click_ButtonSearch(){
        waitf().until(ExpectedConditions.visibilityOfElementLocated(ButtonSearch_filed));
        d.findElement(ButtonSearch_filed).click();
        return new B_services_page(d);
    }

    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }
}
