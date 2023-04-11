package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SaucedemoMultibrowserTest {
    // static variable declaration and assigning values to it

    static String browser="Firefox";
    static String baseUrl="https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        //  1. Set up the browser
        if(browser.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            driver=new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver=new EdgeDriver();
        }else{
            System.out.println("Wrong browser name");
        }

        //  2. Open the Url into Browser
        driver.get(baseUrl);
        //  Maximise the Browser
        driver.manage().window().maximize();
        //  We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //  3. Print the Title of the page
        driver.getTitle();

        //  4. Print the currant Url
        driver.getCurrentUrl();

        //  5. Print the page source
        System.out.println(driver.getPageSource());

        //  6. Enter the email to email field after finding the elements
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //  7. Enter the password to password field after finding the elements
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //  8. Close the browser
        driver.close();

    }

}
