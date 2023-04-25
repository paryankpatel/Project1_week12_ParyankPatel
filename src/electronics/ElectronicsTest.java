package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl= "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldVerifyToCellPhonesPageSuccessfully(){
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //Verify the text “Cell phones”
        verifyFromElement(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //Verify the text “Cell phones”
        verifyFromElement(By.xpath("//h1[normalize-space()='Cell phones']"),"Cell phones");
        //Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        //Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
        //Verify the text “Nokia Lumia 1020”
        verifyFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"),"Nokia Lumia 1020");
        //Verify the price “$349.00”
        verifyFromElement(By.xpath("//span[@id='price-value-20']"),"$349.00");
        //Change quantity to 2
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyFromElement(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //Verify the message "Shopping cart"
        verifyFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //Verify the quantity is 2
        Thread.sleep(1000);
        String expectedQty = "2";
        WebElement actualElement = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String actualQty = actualElement.getAttribute("value");
        Assert.assertEquals(expectedQty,actualQty);
        //Verify the Total $698.00
        verifyFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"$698.00");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        verifyFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //Verify the text “Register”
        verifyFromElement(By.xpath("//h1[normalize-space()='Register']"),"Register");
        //Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Pari");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Jeswal");
        sendTextToElement(By.xpath("//input[@id='Email']"),"pjs1@hotmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"Abc@123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"Abc@123");
        //Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //Verify the message “Your registration completed”
        verifyFromElement(By.xpath("//div[@class='result']"),"Your registration completed");
        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //Verify the text “Shopping card”
        verifyFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Fill the Mandatory fields
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"1");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"California");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Wellington Avenue");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"54671");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"0016462233789");




    }
    @After
    public void tearDown(){

        closeBrowser();
    }
}
