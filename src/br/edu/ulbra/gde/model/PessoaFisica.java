
package br.edu.ulbra.gde.model;

import java.util.Date;

/**
 *
 * @author Thiago Moura
 */
public class PessoaFisica{
    
    private int cpf;
    private int rg;
    private int id_pessoa;
    private Date data_nascimento;
    private char sexo;
    private Pessoa pessoa;

    public PessoaFisica(int cpf, int rg, int id_pessoa, Date data_nascimento, char sexo, Pessoa pessoa) {
        this.cpf = cpf;
        this.rg = rg;
        this.id_pessoa = id_pessoa;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.pessoa = pessoa;
    }

    public PessoaFisica(int cpf, int rg, int id_pessoa, Date data_nascimento, char sexo) {
        this(cpf,rg,id_pessoa,data_nascimento,sexo,null);
    }

    public PessoaFisica() {
        this(0,0,0,null,'f');
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
