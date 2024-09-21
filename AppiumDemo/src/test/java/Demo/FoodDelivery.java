package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class FoodDelivery {
   public static void main(String[] args) throws MalformedURLException, InterruptedException {
       // Gather Desired capabilities
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("deviceName", "AndroidC");
       capabilities.setCapability("platformName", "Android");
       capabilities.setCapability("automationName", "uiautomator2");
       capabilities.setCapability("app", "C:\\Users\\DELL\\Desktop\\RPS\\Appium\\food-app.apk");
       capabilities.setCapability("platformVersion", "11");
       capabilities.setCapability("appPackage", "in.foodapp.demo");
       capabilities.setCapability("appActivity", "in.foodapp.demo.MainActivity");
       URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
       AndroidDriver driver = new AndroidDriver(url, capabilities);
       System.out.println("Application Started");

       WebDriverWait wait = new WebDriverWait(driver, 60);

       // Wait for element to become visible
       By letsGoButton = By.xpath("//android.widget.TextView[@text=\"Already a member? Sign in\"]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(letsGoButton));

       // Click on the element
       driver.findElement(letsGoButton).click();
       System.out.println("Sign in page");

       // Wait for username field to become visible
       By usernameField = By.xpath("//android.view.View[@resource-id=\"user_mobile\"]/android.widget.EditText");
       wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));

       // Enter username
       driver.findElement(usernameField).sendKeys("userid@rediffmail.com");

       // Wait for password field to become visible
       By passwordField = By.xpath("//android.widget.EditText[@text=\"Password\"]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

       // Enter password
       driver.findElement(passwordField).sendKeys("123456");

       // Click on the login button
       By loginSubmitButton = By.xpath("//android.widget.TextView[@text=\"Sign in\"]");
       wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton));
       driver.findElement(loginSubmitButton).click();
       System.out.println("Sign in Successful");
       
    // Location confirmation
       By LocationPermission = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");
       wait.until(ExpectedConditions.elementToBeClickable(LocationPermission));
       driver.findElement(LocationPermission).click();
       System.out.println("Location permission granted");
       Thread.sleep(2000);

       By locationConfirmation = By.xpath("//android.widget.TextView[@text=\"Confirm location\"]");
       wait.until(ExpectedConditions.elementToBeClickable(locationConfirmation));
       driver.findElement(locationConfirmation).click();
       System.out.println("Location confirmed");

       // Select restaurant
       By restaurantButton = By.xpath("(//android.view.View[@text=\"Deva\"])[1]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantButton));
       driver.findElement(restaurantButton).click();
       System.out.println("Restaurant selected");

       // Select menu item
       By menuItemButton = By.xpath("//android.view.View[@resource-id=\"resto_list_category\"]/android.view.View[2]/android.view.View[3]/android.view.View[2]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(menuItemButton));
       driver.findElement(menuItemButton).click();
       System.out.println("Menu item selected");

       // Select item to add to cart and Customize order (add extra toppings)
       By addItemButton = By.xpath("//android.view.View[@text=\"Veg Pizza\"]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(addItemButton));
       driver.findElement(addItemButton).click();
       System.out.println("Item added to cart");

       By customizeOrderButton = By.xpath("//android.widget.RadioButton[@resource-id=\"price-0\"]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(customizeOrderButton));
       driver.findElement(customizeOrderButton).click();
       System.out.println("Order customized");
       
       PointOption startPoint = PointOption.point(0, 1000);
       PointOption endPoint = PointOption.point(0, 500);
       new TouchAction(driver)
           .longPress(startPoint)
           .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
           .moveTo(endPoint)
           .release()
           .perform();

       // Add extra toppings
       By extraToppingsButton = By.xpath("//android.widget.CheckBox[@resource-id=\"addon-23\"]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(extraToppingsButton));
       driver.findElement(extraToppingsButton).click();
       System.out.println("Extra toppings added");


       // Add to cart
       By addToCartButton = By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]");
       wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
       driver.findElement(addToCartButton).click();
       System.out.println("Item added to cart");
       Thread.sleep(2000);

       // Cart validation
       By cartAccuracyButton = By.xpath("//android.view.View[@resource-id=\"item_page\"]/android.view.View[4]");
       wait.until(ExpectedConditions.visibilityOfElementLocated(cartAccuracyButton));
       driver.findElement(cartAccuracyButton).click();
       System.out.println("Cart accuracy validated");

       // Select Delivery Type
       By Delivery = By.xpath("//android.widget.CheckBox");
       wait.until(ExpectedConditions.elementToBeClickable(Delivery));
       driver.findElement(Delivery).click();
       System.out.println("Delivery ASAP Selected");
       
       // Add Address button
       By addAddressButton = By.xpath("//android.view.View[@resource-id=\"frm_cart\"]/android.view.View[3]/android.view.View[14]/android.view.View[2]/android.view.View[2]");
       wait.until(ExpectedConditions.elementToBeClickable(addAddressButton));
        driver.findElement(addAddressButton).click();
        System.out.println("Add Address button clicked");

        // Apply button
        By applyButton = By.xpath("//android.widget.TextView[@text=\"APPLY\"]");
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver .findElement(applyButton).click();
        System.out.println("Apply button clicked");
        
       // Checkout page
       By placeOrderButton = By.xpath("//android.view.View[@text=\"PLACE ORDER\"]");
       wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
       driver.findElement(placeOrderButton).click();
       System.out.println("Order placed");

       By paymentMethodButton = By.xpath("//android.widget.RadioButton[@resource-id=\"payment_provider-0\"]");
       wait.until(ExpectedConditions.elementToBeClickable(paymentMethodButton));
       driver.findElement(paymentMethodButton).click();
       System.out.println("Payment method selected");

       By payButton = By.xpath("//android.widget.TextView[@text=\"PAY ₹175.00\"]");
       wait.until(ExpectedConditions.elementToBeClickable(payButton));
       driver.findElement(payButton).click();
       System.out.println("Payment successful");

       driver.quit(); // CLOSE SESSION
   }
}