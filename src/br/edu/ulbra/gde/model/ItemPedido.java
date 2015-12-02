package br.edu.ulbra.gde.model;

/**
 *
 * @author Douglas, Thiago
 */
public class ItemPedido extends DbModel {

    private int idPedido;
    private int idProduto;
    private int quantidade;
    private float custo;

    public ItemPedido(int id, int idPedido, int idProduto, int quantidade, float custo) {
        super(id);
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.custo = custo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
    
}
