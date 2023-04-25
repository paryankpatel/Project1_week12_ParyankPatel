package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    static String product;

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //Click on Computers Menu
        clickOnElement(By.xpath("(//a[text()='Computers '])[1]"));
        //Click on Desktops
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(2000);
        //Verify the Product will arrange in Descending order.
        //List<String> list1 = new ArrayList<>();
        // int listSize = list1.size();
        //for(int j =0;j < list1.size();j++){
        //list1.add(product);
//            Thread.sleep(2000);
        //System.out.println("l1"+list1);

        List<WebElement> productList = driver.findElements(By.xpath("//h2[@class='product-title']/a"));


        List<String> list = null;
        for (WebElement element : productList) {
            //System.out.println(productList);

            product = element.getText();
            list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            list.add(product);
            System.out.println("p" + product);
            System.out.println("l" + list);
        }
        driver.quit();
    }



        @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
            //Click on Computers Menu
            clickOnElement(By.xpath("(//a[text()='Computers '])[1]"));
            //Click on Desktops
            clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
            //Select Sort By position "Name: A to Z"
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
            //Click on "Add To Cart"
            Thread.sleep(2000);
            clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
            //Verify the Text "Build your own computer"
            verifyFromElement(By.xpath("//a[normalize-space()='Build your own computer']"), "Build your own computer");
            //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
           //2.7.Select "8GB [+$60.00]" using Select class.
            selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"),3);
            //Select HDD radio "400 GB [+$100.00]"
            clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
            //Select OS radio "Vista Premium [+$60.00]"
            clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
            //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
            Thread.sleep(2000);
            clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
            //Verify the price "$1,475.00"
            Thread.sleep(1000);
            verifyFromElement(By.xpath("//span[@id='price-value-1']"),"$1,475.00");
            //Click on "ADD TO CARD" Button.
            clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
            //Verify the Message "The product has been added to your shopping cart" on Top green Bar
             verifyFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
             clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
             //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
            clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
            //Verify the message "Shopping cart"
            verifyFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
            //Change the Qty to "2" and Click on "Update shopping cart"
            clickOnElement(By.xpath("//input[@class='qty-input']"));
            driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
            sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
            clickOnElement(By.xpath("//button[@id='updatecart']"));
            //Verify the Total"$2,950.00"
            verifyFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$2,950.00");
            //click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            //Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));
            //Verify the Text “Welcome, Please Sign In!”
            verifyFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
            //2.21Click on “CHECKOUT AS GUEST” Tab
            clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
            //Fill the all mandatory field
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Prachi");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Desai");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"pdesai12@gmail.com");
            sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Los Angeles");
            //sendTextToElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"California");
            Thread.sleep(1000);
            clickOnElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
            selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"47");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"123 McIntosh Boulevard");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"36541");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"0016464569898");
            //Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
            //Click on Radio Button “Next Day Air($0.00)”
            clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
            //Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
            //Select Radio Button “Credit Card”
            clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
            clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
            //Select “Master card” From Select credit card dropdown
            selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");
            //Fill all the details
            sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Prachi Desai");
            sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5012 3456 3456 9879");
            selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"5");
            selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
            sendTextToElement(By.xpath("//input[@id='CardCode']"),"2244");
            // Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
            //Verify “Payment Method” is “Credit Card”
            verifyFromElement(By.xpath("//span[contains(text(), 'Credit Card')]"),"Credit Card");
            //Verify “Shipping Method” is “Next Day Air”
            verifyFromElement(By.xpath("(//span[contains(text(), 'Next Day Air')])[1]"),"Next Day Air");
            //Verify Total is “$2,950.00”
            verifyFromElement(By.xpath("(//strong[text()= '$2,950.00'])[2]"),"$2,950.00");
            //Click on “CONFIRM”
            clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
            //Verify the Text “Thank You”
            verifyFromElement(By.xpath("//h1[text()='Thank you']"),"Thank you");
            //Verify the message “Your order has been successfully processed!”
            verifyFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
            //Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
            //Verify the text “Welcome to our store”
            verifyFromElement(By.xpath("//h2[text()='Welcome to our store']"),"Welcome to our store");
    }
    @After
    public void tearDown(){

        closeBrowser();
    }
}
