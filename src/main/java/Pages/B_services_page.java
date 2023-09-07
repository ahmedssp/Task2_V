package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class B_services_page {
    private WebDriver d;
    private By MobileNo_filed = By.id("mobileNo");
    private By Mailid_filed = By.id("email");
    private By passengerName_filed = By.id("passengerNameForward0");
    private By Genderlist_filed = By.id("genderCodeIdForward0");
    private By passengerage_filed = By.id("passengerAgeForward0");
    private By Concessionlist_filed = By.id("concessionIdsForward0");
    private By nationalitylist_filed = By.id("nationalityForward0");
    private By paymentGatway_filed = By.id("billdesk");
    private By passportNo_field = By.id("passportNoForward0");
    private By foreignerAddress_field = By.id("foreignerAddressForward0");
    private By DateofBrith_field = By.id("dobForward0");
    private By MakePaymentBotton_Filed = By.id("PgBtn");


    public B_services_page(WebDriver d) {
        this.d = d;
    }

    private By ListofBordingpoint_Filed = By.xpath("(//div[@id=\"myTabContent\"]//div[@class=\"col-sm-12\"])[1]//ul//li");
    private By ListofDroppingpoint_Filed = By.xpath("(//div[@id=\"myTabContent\"]//div[@class=\"col-sm-12\"])[2]//ul//li");
    private By statusButton_filed = By.xpath("(//div[@class=\"s-result-list\"]//input[@type=\"button\"])");
    private By Avilableseats_filed = By.xpath("//li[@class=\"availSeatClassS\"]");
    private By NonAvilableseats_filed = By.xpath("//li[@class=\"bookedSeatClassS\"]");
    private By BoardingPoint_filed = By.id("Forwardboarding-tab");
    private By DroppingPoint_filed = By.id("Forwarddroping-tab");
    private By radio_botton_continuAsGestUser_Filed = By.xpath("(//label[ text()=\"Continue As A Guest User\" ])[1]");


    public void statusButton_click(int index_status) {
        JavascriptExecutor j = (JavascriptExecutor) d;
        j.executeScript("arguments[0].click();", d.findElement(statusButton_filed));
    }

    //    public void Select_avilable_seat(){
//        for(int a=1;a<=45;a++){
//            if(a%2==0){
//                waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id=\"Forward'/"+a+"\"]")));
//                if( d.findElements(By.xpath("//li[@id=\"Forward'/"+a+"\"]")).get(a).getAttribute("class").equals("selectedSeatClassS")){
//                    d.findElements(By.xpath("//li[@id=\"Forward'/"+a+"\"]")).get(a).click();break;
//                }
//        }
//      }
//    }
    public void Select_avilable_seat() {
        int x = Integer.parseInt(d.findElements(Avilableseats_filed).get(1).getText());
        d.findElements(Avilableseats_filed).get(x).click();
    }

    public void clickBoardingPoint() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(BoardingPoint_filed));
        d.findElement(BoardingPoint_filed).click();
    }

    public void clickDoarPPingPoint() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(DroppingPoint_filed));
        d.findElement(DroppingPoint_filed).click();
    }

    public void SelectFromBordingpointList(int opt) {

        waitf().until(ExpectedConditions.visibilityOfElementLocated(ListofBordingpoint_Filed));
        System.out.println("SizeOfList:" + (d.findElements(ListofBordingpoint_Filed).size()));
        d.findElements(ListofBordingpoint_Filed).get(opt).click();
    }

    public void SelectFromDoarPPingPointList(int opt) {

        waitf().until(ExpectedConditions.visibilityOfElementLocated(ListofDroppingpoint_Filed));
        System.out.println("SizeOfList:" + (d.findElements(ListofDroppingpoint_Filed).size()));
        d.findElements(ListofDroppingpoint_Filed).get(opt).click();
    }


    public void Click_radio_botton_continuAsGestUser() {
        d.findElement(radio_botton_continuAsGestUser_Filed).click();
    }

    public void send_MobileNo(String phone_no) {
        d.findElement(MobileNo_filed).sendKeys(phone_no);
    }

    public void send_EmailId(String mail) {
        d.findElement(Mailid_filed).sendKeys(mail);

    }

    public void send_passengerName(String name) {
        d.findElement(passengerName_filed).sendKeys(name);

    }

    public void Select_gender(String GENDER) {

        Select objSelect = new Select(d.findElement(Genderlist_filed));
        objSelect.selectByVisibleText(GENDER);
        try {
            Alert alert = d.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public void send_age(String age) {
        d.findElement(passengerage_filed).sendKeys(age);

    }

    public void Select_Concession(int opt) {
        Select objSelect = new Select(d.findElement(Concessionlist_filed));
        objSelect.selectByIndex(opt);
    }

    public void Select_nationality(String nationality) {
        Select objSelect = new Select(d.findElement(nationalitylist_filed));
        objSelect.selectByVisibleText(nationality);
        try {
            Alert alert = d.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public void Select_paymentGatway() {
        d.findElement(paymentGatway_filed).click();
    }

    public void send_passportNo(String number) {
        d.findElement(passportNo_field).sendKeys(number);
    }

    public void send_foreignerAddress(String address) {
        d.findElement(foreignerAddress_field).sendKeys(address);
    }

    public void send_DateofBrith(String Date) {
        d.findElement(DateofBrith_field).sendKeys(Date);
    }

    public C_MakePayment_Page Click_MakePayment_Botton() {
//        waitf().until(ExpectedConditions.visibilityOfElementLocated(MakePaymentBotton_Filed));
        d.findElement(MakePaymentBotton_Filed).click();
        return new C_MakePayment_Page(d);
    }

    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }

}
