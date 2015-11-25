
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Contato {

    private int id;
    private int id_pessoa;
    private String descricao;
    private String contato;

    public Contato(int id, int id_pessoa, String descricao, String contato) {
        this.id = id;
        this.id_pessoa = id_pessoa;
        this.descricao = descricao;
        this.contato = contato;
    }

    public Contato() {
        this(0,0,null,null);
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
