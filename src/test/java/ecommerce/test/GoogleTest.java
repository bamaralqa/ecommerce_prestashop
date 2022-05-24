package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest{

    private static GooglePO googlePage;
    
    @BeforeClass
    public static void prepararTestes(){
    driver.get("https://www.google.com/");
    googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita(){  
   //Pra pesquisar no campo do google
    googlePage.pesquisar("Batata frita");
    //escrever no campo do google
    String resultado = googlePage.obterResultadoDaPesquisa();
    //confirmar o resultado da pesquisa
    assertTrue(resultado, resultado.contains("Aproximadamente"));
    assertTrue(resultado, resultado.contains("resultados"));

    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella(){
   
    googlePage.pesquisar("Nutella");
    String resultado = googlePage.obterResultadoDaPesquisa();
    assertTrue(resultado, resultado.contains("Aproximadamente"));
    assertTrue(resultado, resultado.contains("resultados"));

    }
}