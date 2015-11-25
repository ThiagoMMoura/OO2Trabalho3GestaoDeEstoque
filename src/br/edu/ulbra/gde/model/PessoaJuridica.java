
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class PessoaJuridica {

    private int cnpj;
    private int id_pessoa;
    private String nome_fantasia;
    private int inscricao_estadual;
    private Pessoa pessoa;

    public PessoaJuridica(int cnpj, int id_pessoa, String nome_fantasia, int inscricao_estadual, Pessoa pessoa) {
        this.cnpj = cnpj;
        this.id_pessoa = id_pessoa;
        this.nome_fantasia = nome_fantasia;
        this.inscricao_estadual = inscricao_estadual;
        this.pessoa = pessoa;
    }

    public PessoaJuridica(int cnpj, int id_pessoa, String nome_fantasia, int inscricao_estadual) {
        this(cnpj,id_pessoa,nome_fantasia,inscricao_estadual,null);
    }

    public PessoaJuridica() {
        this(0,0,null,0);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public int getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(int inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
