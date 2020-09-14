package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void sagTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);

        // <span class="context-menu-one btn btn-neutral">right click me</span>
        // linkText : HAYIR (çünkü link değil - "a" tagName'i yok)
        // className: HAYIR (çünkü class değerinin içerisinde BOŞLUK var)
        // tagName, xpath, cssSelector
        // By.xpath("//*[.='right click me']") -> içerdiği yazı "right click me" olan webelement
        WebElement rightClick = driver.findElement(By.xpath("//span [@class =\"context-menu-one btn btn-neutral\"]"));
        actions.contextClick(rightClick).perform();

        // perform artık komut bitti uygulamaya geçebilirsin manasında.

    }

    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);

        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform();
    }

    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void asagiYukariGitme(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        //web sayfasının en altına gitmek için
        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //web sayfasında yukarı çıkmak istiyorsak
        //1.YÖNTEM -> PAGE_UP butonu
        //2.YÖNTEM -> ARROW_UP (yukarı yön tuşu)

        actions.sendKeys(Keys.PAGE_UP).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        }

    @Test
    public void keyUpKeyDown(){
        // MERHABA nasılsınız
        // shift'e basılı tutarak MERHABA
        // shift'ten elimizi çekerek nasılsınız yazalım

        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);

        actions.moveToElement(aramaKutusu).
                click().
                keyDown(Keys.SHIFT).
                sendKeys("merhaba").
                keyUp(Keys.SHIFT).
                sendKeys("nasılsınız").perform();
    }

    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        // ALT + F4 : sayfayı kapatması gerekiyor
        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();
    }

}



