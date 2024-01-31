package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    public static By productsTitle = By.cssSelector("span.text-description");
    public static By productsTitle2 = By.xpath("(//b[text()='Tu producto fue añadido'])[1]");
    public static By envioGratis = By.xpath("//a[img[contains(@src, 'envio_gratis') and @style=''] and span[text()='Envío Gratis']]");
    public static By itemsCards = By.cssSelector("div.inventory_item");

}
