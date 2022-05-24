package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    //#region Região dos WebElement
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spamMensagem;
    //#endregion Região dos WebElement

    //#region Reião Construtor
    /**
     * Construtor padrão para criação de uma nova instancia de pagina de Login
     * @param driver Driver da pagina de Login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Reião Construtor

    //#region Regiao dos Metodos
    /**
     * Metodo que obtem a mensagem disparada na tela
     * @return Texto da mensagem
     */
    public String obterMensagem() {
        return this.spamMensagem.getText();
    }

    /**
     * Metodo que tentar executar a ação de logar no sistema
     * 
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }
    //#endregion Regiao dos Metodos
}
