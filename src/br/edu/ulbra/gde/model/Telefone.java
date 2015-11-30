package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Telefone {

    private int id;
    private int idPessoa;
    private int ddd;
    private String telefone;
    private String descricao;
    private boolean principal;

    public Telefone(int id, int idPessoa, int ddd, String telefone, String descricao, boolean principal) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.ddd = ddd;
        this.telefone = telefone;
        this.descricao = descricao;
        this.principal = principal;
    }

    public Telefone() {
        this(0, 0, 0, null, null, false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int id_pessoa) {
        this.idPessoa = id_pessoa;
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
