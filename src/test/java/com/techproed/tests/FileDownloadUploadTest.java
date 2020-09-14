package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase{

    @Test
    public void dosyaVarMi(){
        // Şuanda bulunduğumuz klasörün dosya yolunu veriyor.(String olarak)
        System.out.println(   System.getProperty("user.dir")   );
        // Kullanıcı ana klasörünün dosya yolunu veriyor. (String olarak)
        System.out.println(   System.getProperty("user.home")   );

        // Java ile belirtilen adreste, aradığımız dosyanın var olup olmadığını
        // aşağıdaki kod ile yapabiliyoruz.
        // Eğer dosya varsa, TRUE  - Eğer dosya yoksa, FALSE
        // /Users/Abc/IdeaProjects/SeleniumReviewTestNG--> pom.xml dosyasının adresi
       //    boolean varMi = Files.exists(Paths.get("buraya aradığımız dosyanın adresi"));
        // mesela çalıştığımız projede bir dosya indirme sözkonusuysa bu dosyanın indirilip indirilmediğini
        // kontrol etme amaçlı lazım olabilecek bir kod.

        boolean varMi = Files.exists(Paths.get("/Users/Abc/IdeaProjects/SeleniumReviewTestNG"));
        Assert.assertTrue(varMi);

        // bu şekilde de yapılabilir.
        boolean varMi1 = Files.exists(Paths.get(System.getProperty("user.dir")));
        Assert.assertTrue(varMi1);
}


    @Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
        // "dosya seç (choose file)" webelementini locate ettik.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
// sendKeys ile upload etmek istediğimiz dosyanın adresini göndermemiz gerekiyor.
        chooseFile.sendKeys("/Users/Abc/Documents/selenium libraries");

        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    // websitesinden, indirmek istediğimiz dosyayı indirdikten sonra,
    // bilgisayarımızda indirme klasöründe, o dosyanın var olup olmadığını kontrol
    // ediyoruz. Eğer dosya varsa, indirme işleminde bir problem yok diyebiliriz.
    // Dikkat edilmesi gereken bir husus : Bazen indirme işlemi uzun sürebilir. Bu yüzden
    // indirme işleminden sonra, bir müddet beklemek gerekir. Thread.sleep ile yapabiliriz.
    public void dosyaDownload(){
        driver.get("http://the-internet.herokuapp.com/download");
        // Bilgisayarımda Download klasörünün adresi /Users/Abc/Downloads

        driver.findElement(By.linkText("Penguins.jpg")).click();
        boolean penguen = Files.exists(Paths.get("Users/Abc/Downloads/Penguins.jpeg/"));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(penguen);

    }
}
