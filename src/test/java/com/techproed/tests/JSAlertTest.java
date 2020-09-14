package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver driver;
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // sayfada alert varsa buna tamam demeden işlem yapamıyoruz.
        // switchTo : geçiş yap demek

        WebElement button = driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().sendKeys("selamlar");
        // aşağıdaki accept kodunu yazmadan selamlar yazısı gözükmedi.
     //   driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();


    }
}
