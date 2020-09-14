package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test(){

        // Tüm webelementlere veri gönderiniz.
        // Save butonunu tıklayınız
        // Assert işlemi ile "Hotel was inserted succesfully" yazını doğrulayın

        FhcTripHotelCreatePage createPage = new FhcTripHotelCreatePage(driver);
        createPage.adressKutusu.sendKeys("istanbul" + Keys.ENTER);
        createPage.codeKutusu.sendKeys("606060" + Keys.ENTER);
        createPage.emailKutusu.sendKeys("abc@gmail.com" + Keys.ENTER);
        createPage.nameKutusu.sendKeys("Osman" + Keys.ENTER);
        createPage.phoneKutusu.sendKeys("35363463" + Keys.ENTER);

        Select options = new Select(createPage.idGroupDropDown);
        options.selectByIndex(2);

        createPage.saveButonu.click();

        // bekletme işlemini explicment wait ile yapalım.
        //Thread.sleep(3000);
        //Assert.assertTrue(createPage.basariliYazisi.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver , 60);
        //WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        boolean esitMi = wait.until(ExpectedConditions.textToBe( By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(esitMi);
    }

}
