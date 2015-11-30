package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Pessoa {

    private int id;
    private String razaoSocial;
    private int idEndereco;
    private int numeroEndereco;
    private String complementoEndereco;
    private Endereco endereco;

    public Pessoa(int id, String razaoSocial, int idEndereco, int numeroEndereco, String complementoEndereco) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.idEndereco = idEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
    }

    public Pessoa() {
        this(0, null, 0, 0, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

}
