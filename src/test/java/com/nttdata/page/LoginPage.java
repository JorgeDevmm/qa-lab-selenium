package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("UserName");
    public static By passInput = By.id("Password");
    public static By loginButton = By.xpath("//input[@class='btn btn-primary form-control']");
    public static By AgregarCarrito = By.xpath("(//button[@class='btn-add-car'])[1]");
    public static By irAlCarrito = By.xpath("(//a[@href='https://juntoz.com/cart' and @class='btn-add-car-modal' and @type='button'])[1]");

}
