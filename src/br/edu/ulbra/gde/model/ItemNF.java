package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class ItemNF extends DbModel {

    private int idNF;
    private int idProduto;
    private int quantidade;
    private float custo;
    private NotaFiscal nf;
    private Produto produto;

    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo, NotaFiscal nf, Produto produto) {
        super(id);
        this.idNF = idNF;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.custo = custo;
        this.nf = nf;
        this.produto = produto;
    }

    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo, NotaFiscal nf) {
        this(id, idNF, idProduto, quantidade, custo, nf, null);
    }

    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo) {
        this(id, idNF, idProduto, quantidade, custo, null, null);
    }

    public ItemNF() {
        this(0, 0, 0, 0, 0f);
    }

    public int getIdNF() {
        return idNF;
    }

    public void setIdNF(int idNF) {
        this.idNF = idNF;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public NotaFiscal getNf() {
        return nf;
    }

    public void setNf(NotaFiscal nf) {
        this.nf = nf;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
