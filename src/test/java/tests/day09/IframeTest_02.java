package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class IframeTest_02 extends TestBase {

    //Bir class olusturun: IframeTest 02
        //    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //        2) sayfadaki iframe sayısını bulunuz.
   //         3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
  //          4)ilk iframe'den çıkıp ana sayfaya dönünüz
  //          5)ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium
  //  project.html) tıklayınız
    @Test
    public void test(){
        driver.get("http://demo.guru99.com/test/guru99home/");


        List<WebElement> iframeTag=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi"+iframeTag.size() );

driver.switchTo().frame(0);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();



    }




}
