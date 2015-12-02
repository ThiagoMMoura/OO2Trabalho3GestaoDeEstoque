
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Endereco extends DbModel{
    
    private int cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(int id, int cep, String logradouro, String bairro, String cidade, String uf) {
       super(id);
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco() {
        this(0,0,null,null,null,null);
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
}
