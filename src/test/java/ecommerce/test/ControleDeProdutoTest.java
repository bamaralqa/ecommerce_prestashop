package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleProdutoPage.buttonAdicionar.click();
        // TODO: remover esse clique assim que o sistema for corrigido
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
        // pra nao atrapalhar o proximo teste com o modal ja aberto.
        // TODO: O btn Sair tambem precisa de 2 clicks
        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    /*
     * @Test
     * public void
     * TC002_naoDeveSerPossivelCadastrarUmProdutosemPreenherTodosOsCampos() {
     * controleProdutoPage.buttonAdicionar.click();
     * 
     * controleProdutoPage.cadastrarProduto("00001", "Martelo", 10, 59.9, "");
     * // Aqui vamos capturar a mensagem
     * 
     * String mensagem = controleProdutoPage.spanMensagem.getText();
     * assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
     * }
     */

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutosemPreenherTodosOsCampos() {

        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleProdutoPage.buttonAdicionar.click();
     

        // Aqui cria o objeto para adc na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        // Aqui estamos testando se o produto é adicionado quando completo
        produtoBuilder
                .builder();

        // Aqui estamos testando se o produto é adicionado sem quantidade
        produtoBuilder
                .adicionarCodigo("00005")
                .adicionarQuantidade(null)
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem nome
        produtoBuilder
                .adicionarQuantidade(15)
                .adicionarNome("")
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem valor
        produtoBuilder
                .adicionarNome("Cimento")
                .adicionarValor(null)
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem código
        produtoBuilder
                .adicionarValor(50.0)
                .adicionarData("")
                .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
        // TODO: O btn Sair tambem precisa de 2 clicks
        controleProdutoPage.buttonSair.click();
    }

}
