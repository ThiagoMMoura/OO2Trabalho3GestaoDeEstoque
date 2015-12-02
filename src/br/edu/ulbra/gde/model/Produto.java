package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura, Douglas Angeli
 */
public class Produto extends DbModel {

    private String ref;
    private String refFornecedor;
    private String descricao;
    private float preco;
    private float lucro;
    private int quantidade;
    private String unidade;
    private boolean ativo;

    public Produto(int id, String ref, String refFornecedor, String descricao, float preco, float lucro, int quantidade, String unidade, boolean ativo) {
        super(id);
        this.ref = ref;
        this.refFornecedor = refFornecedor;
        this.descricao = descricao;
        this.preco = preco;
        this.lucro = lucro;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.ativo = ativo;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefFornecedor() {
        return refFornecedor;
    }

    public void setRefFornecedor(String refFornecedor) {
        this.refFornecedor = refFornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
