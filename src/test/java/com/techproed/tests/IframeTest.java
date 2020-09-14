package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    // https://the-internet.herokuapp.com/iframe
// 1. Adım : Sayfadaki iframe'i bulacağız.
// 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
// 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
// 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
// 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.


  /*
    ***** Iframe'e geçiş yapmak için 3 TANE yöntemimiz var.
            1. index ile            -> driver.switchTo().frame(0)
	2. id attribute ya da name ile    -> driver.switchTo().frame("mce_0_ifr")
	3. webelement ile       -> driver.switchTo().frame(webelement)
***** Iframe'den çıkış yapmak için 2 TANE yöntemimiz var.
            1. driver.switchTo().defaultContent()
	2. driver.switchTo().parentFrame()     * İÇ İÇE IFRAME VARSA

   */

    WebDriver driver;

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        WebElement ptag = driver.findElement(By.xpath("//p"));
        ptag.clear();
        ptag.sendKeys("selamlar");

        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
        link.click();

    }

}
