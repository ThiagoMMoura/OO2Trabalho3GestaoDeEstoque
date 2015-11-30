package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class PessoaJuridica {

    private int cnpj;
    private int idPessoa;
    private String nomeFantasia;
    private int inscricaoEstadual;
    private Pessoa pessoa;

    public PessoaJuridica(int cnpj, int idPessoa, String nomeFantasia, int inscricaoEstadual, Pessoa pessoa) {
        this.cnpj = cnpj;
        this.idPessoa = idPessoa;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.pessoa = pessoa;
    }

    public PessoaJuridica(int cnpj, int idPessoa, String nomeFantasia, int inscricaoEstadual) {
        this(cnpj, idPessoa, nomeFantasia, inscricaoEstadual, null);
    }

    public PessoaJuridica() {
        this(0, 0, null, 0);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
