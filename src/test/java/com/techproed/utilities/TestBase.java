package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // testcase classını nesne üretmeyeceğimiz sadece miras alacağımız için abstract yaptık.
    // privatte, default, protected, public access modifier
    // private : sadece ilgili classta kullanılabilir.
    // default : miras(inheritance) alındığı zaman aynı package'de kullanılabilir.
    // protected : sadece parent ve childlarda kullanılabilir, başka package lerin
    // childlerindede kullanılabilir.
    // public : her yerde her şekilde ulaşılır olabiliyor. bu nedenle driverı protected yaptık.

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
  //      driver.quit();

    }
}
