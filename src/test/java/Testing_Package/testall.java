package Testing_Package;

import Base_Package.base;
import DataMethodo.apachi_POI;
import Pages.B_services_page;
import Pages.C_MakePayment_Page;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.font.NumericShaper;

public class testall extends base {

    @Test(dataProvider = "exceldata", dataProviderClass = apachi_POI.class)
    public void test1(String statusButton, String FromBordingpointList, String FromDoarPPingPointList, String MobileNo, String EmailId, String passengerName, String gender, String age, String ConcessionOPT, String nationality, String passportNo, String Address, String DateofBrith, String Validate_PaybyCreditCardtxt) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Home_obj.FromTo_Click();
        Home_obj.Departure_click();
        Home_obj.select_arrival_date((java.time.LocalDateTime.now().getDayOfMonth() + 1));
        B_services_page Service_Obj = Home_obj.click_ButtonSearch();
        Service_Obj.statusButton_click(Integer.parseInt(statusButton));
        Service_Obj.Select_avilable_seat();
        Service_Obj.clickBoardingPoint();
        Service_Obj.SelectFromBordingpointList(Integer.parseInt(FromBordingpointList));
        Service_Obj.clickDoarPPingPoint();
        Service_Obj.SelectFromDoarPPingPointList(Integer.parseInt(FromDoarPPingPointList));
        Service_Obj.Click_radio_botton_continuAsGestUser();
        Service_Obj.send_MobileNo(MobileNo);
        Service_Obj.send_EmailId(EmailId);
        Service_Obj.send_passengerName(passengerName);
        Service_Obj.Select_gender(gender);
        Service_Obj.send_age(age);
        Service_Obj.Select_Concession(Integer.parseInt(ConcessionOPT));
        Service_Obj.Select_nationality(nationality);
        Service_Obj.send_passportNo(passportNo);
        Service_Obj.send_foreignerAddress(Address);
        Service_Obj.send_DateofBrith(DateofBrith);
        Service_Obj.Select_paymentGatway();
        C_MakePayment_Page Payment_Obj = Service_Obj.Click_MakePayment_Botton();
        softAssert.assertTrue(Payment_Obj.Validate_PaybyCreditCardtxt(Validate_PaybyCreditCardtxt));
        softAssert.assertAll();
    }
}
