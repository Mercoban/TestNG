package tests.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;


import java.util.concurrent.TimeUnit;


public class AlertTest extends TestBase {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"


    @Test
    public void Test() throws InterruptedException {
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");


        // click  "Alert with OK" and click 'click the button to display an alert box:'
        WebElement click = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));

       Thread.sleep(5000);
        click.click();
        Thread.sleep(5000);

        // accept Alert(I am an alert box!) and print alert on console
        driver.switchTo().alert();
        Thread.sleep(5000);
        String alertMessage1=driver.switchTo().alert().getText();
        Thread.sleep(5000);
        System.out.println("Alert Text : "+alertMessage1);
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        Thread.sleep(5000);
        // cancel Alert  (Press a Button !)
        //1.yol
        // driver.switchTo().alert().dismiss();
        //2.yol
        Actions actions=new Actions(driver);
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);


        // click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'


        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        Thread.sleep(3000);


        // and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProeducation");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        // finally print on console this message "Hello TechproEducation How are you today"
        String expectedMessage= "Hello TechProeducation How are you today";
        Thread.sleep(5000);
        String actualmessageLast = driver.findElement(By.id("demo1")).getText();
        Thread.sleep(5000);
        System.out.println("System Message: "+actualmessageLast);

        Thread.sleep(2000);


        Assert.assertEquals(actualmessageLast,expectedMessage);
    }

}