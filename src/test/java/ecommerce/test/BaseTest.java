package ecommerce.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança paratodas as classes de teste.
 */
public abstract class BaseTest {

    /** Driver navegador da pagina atual. */
    protected static WebDriver driver;

    /** Caminho base d URL do sistema a ser testado. */
    private static final String URL_BASE = "https://marcelodebittencourt.com/demoprestashop/";
    /** Caminho relativo do driver ao projeto referente ao */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver10104951.exe";

    /**
     * Metodo para iniciar o driver no navegador antes de qual classe de teste.
     */
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Metodo para finlizar o driver no navegador depois de qual classe de teste.
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
