package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FhcTripHotelCreatePage {

    // Başka class'larda kullanabilmek için mutlaka bir constructor oluşturmak durumundayız.

   WebDriver driver;
    public FhcTripHotelCreatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // http://fhctrip-qa.com/admin/HotelAdmin/Create
    //manager2
    //Man1ager2!

    // Sitedeki Webelementleri locate edelim.

    @FindBy ( id = "Code")
    public WebElement codeKutusu;
    @FindBy ( id = "Name")
    public WebElement nameKutusu;
    @FindBy ( id = "Address")
    public WebElement adressKutusu;
    @FindBy ( id = "Phone")
    public WebElement phoneKutusu;
    @FindBy ( id = "Email")
    public WebElement emailKutusu;
    @FindBy ( id = "IDGroup")
    public WebElement idGroupDropDown;
    @FindBy ( id = "btnSubmit")
    public WebElement saveButonu;
    @FindBy ( className = "bootbox-body")
    public WebElement text;

}
