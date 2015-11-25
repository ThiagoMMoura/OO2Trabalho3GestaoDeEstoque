
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Telefone {

    private int id;
    private int id_pessoa;
    private int ddd;
    private String telefone;
    private String descricao;
    private boolean principal;

    public Telefone(int id, int id_pessoa, int ddd, String telefone, String descricao, boolean principal) {
        this.id = id;
        this.id_pessoa = id_pessoa;
        this.ddd = ddd;
        this.telefone = telefone;
        this.descricao = descricao;
        this.principal = principal;
    }

    public Telefone() {
        this(0,0,0,null,null,false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
