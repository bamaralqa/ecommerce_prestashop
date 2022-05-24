package base.builder;

import base.page.ControleDeProdutoPO;
/**
 * Classe que sabe construir ou adc um produto na tela
 */
public class ProdutoBuilder {

    public String codigo = "00001";
    public String nome = "Produto Padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "18/05/2022";

    public ControleDeProdutoPO controleDeProdutoPO;

    /**Construtor do ProdutoBuilder que recebe a pagina de controle de produtos.  */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {
        this.controleDeProdutoPO = controleDeProdutoPO;

    }

    /**
     * Metodo que sabe adc um codigo ao builder
     * @param codigo Código que sera adc
     * @return Retorna a proria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

     /**
     * Metodo que sabe adc um nome ao builder
     * @param nome Nome que sera adc
     * @return Retorna a proria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

     /**
     * Metodo que sabe adc uma quantidade ao builder
     * @param quantidade Quantidade que sera adc
     * @return Retorna a proria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

     /**
     * Metodo que sabe adc um valor ao builder
     * @param valor Valor que sera adc
     * @return Retorna a proria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarValor(Double valor) {
        this.valor = valor;
        return this;
    }

     /**
     * Metodo que sabe adc uma data ao builder
     * @param data Data que sera adc
     * @return Retorna a proria classe ProdutoBuilder
     */
    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Metodo que constroi o produto, ou seja, adc o produto pela tela de cadastro de produto. 
     */
    public void builder() {

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();
    }

}
