
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Pessoa {
    private int id;
    private String razao_social;
    private int id_endereco;
    private int numero_endereco;
    private String complemento_endereco;
    private Endereco endereco;

    public Pessoa(int id, String razao_social, int id_endereco, int numero_endereco, String complemento_endereco) {
        this.id = id;
        this.razao_social = razao_social;
        this.id_endereco = id_endereco;
        this.numero_endereco = numero_endereco;
        this.complemento_endereco = complemento_endereco;
    }

    public Pessoa() {
        this(0,null,0,0,null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getNumero_endereco() {
        return numero_endereco;
    }

    public void setNumero_endereco(int numero_endereco) {
        this.numero_endereco = numero_endereco;
    }

    public String getComplemento_endereco() {
        return complemento_endereco;
    }

    public void setComplemento_endereco(String complemento_endereco) {
        this.complemento_endereco = complemento_endereco;
    }

}
