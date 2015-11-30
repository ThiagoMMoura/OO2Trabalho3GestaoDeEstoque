
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class ItemNF {
    
    private int id;
    private int idNF;
    private int idProduto;
    private int quantidade;
    private float custo;
    private NotaFiscal nf;
    private Produto produto;

    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo, NotaFiscal nf, Produto produto) {
        this.id = id;
        this.idNF = idNF;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.custo = custo;
        this.nf = nf;
        this.produto = produto;
    }
    
    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo, NotaFiscal nf) {
        this(id,idNF,idProduto,quantidade,custo,nf,null);
    }
    
    public ItemNF(int id, int idNF, int idProduto, int quantidade, float custo) {
        this(id,idNF,idProduto,quantidade,custo,null,null);
    }
    
    public ItemNF(){
        this(0,0,0,0,0f);
    }
}
