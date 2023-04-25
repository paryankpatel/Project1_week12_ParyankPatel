package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ ";
    static String menu = "Computers";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("(//a[text()='"+menu+" '])[1]"));
    }
    @Test
    public void verifyPageNavigation() {

        selectMenu("Gift Cards");
    }
}



