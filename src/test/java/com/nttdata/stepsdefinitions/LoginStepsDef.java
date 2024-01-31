package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.nttdata.Util.esperaElemento;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Dado("que me encuentro en la página de login de Juntoz")
    public void que_me_encuentro_en_la_página_de_login_de_juntoz() {
        driver.get("https://juntoz.com/account/login");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales correo: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String correo, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(correo);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }
    @Entonces("valido que debería aparecer el título de {string}")
    public void valido_que_debería_aparecer_el_título_de(String expectedTitle) {
        String title =  inventorySteps(driver).getTitle();
        //prueba: validamos el título del producto
        Assertions.assertEquals(expectedTitle, title);
    }
    @Y("también valido que al menos exista un item")
    public void también_valido_que_al_menos_exista_un_item() {
        int itemsListSize = inventorySteps(driver).getItemSize();
        //prueba: validar que al menos exista un item
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Y("hago clic en Envío Gratis")
    public void hagoClicEnEnvíoGratis() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.clickBuscar();
    }


    @Y("selecciono el primer producto y hago clic en agregar al carrito")
    public void seleccionoElPrimerProductoYHagoClicEnAgregarAlCarrito() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.agregarProductoCarrito();



        screenShot();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        esperaElemento(driver, LoginPage.AgregarCarrito);
    }


    @Y("hago clic en Ir al carrito")
    public void hagoClicEnIrAlCarrito() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.irAlCarrito();



        screenShot();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Entonces("Valido que se haya agregado exitosamente al Carrito {string}")
    public void validoQueSeHayaAgregadoExitosamenteAlCarrito(String expectedTitle2) {
        String title =  inventorySteps(driver).getTitle2();
        //prueba: validamos el título del producto
        Assertions.assertEquals(expectedTitle2, title);
    }
}
