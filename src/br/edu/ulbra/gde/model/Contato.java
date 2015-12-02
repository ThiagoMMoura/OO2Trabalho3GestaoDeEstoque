package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Contato extends DbModel {

    private int idPessoa;
    private String descricao;
    private String contato;

    public Contato(int id, int idPessoa, String descricao, String contato) {
        super(id);
        this.idPessoa = idPessoa;
        this.descricao = descricao;
        this.contato = contato;
    }

    public Contato() {
        this(0, 0, null, null);
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
