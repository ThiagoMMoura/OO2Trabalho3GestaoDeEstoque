package br.edu.ulbra.gde.model;

import br.edu.ulbra.gde.control.PessoaDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago Moura
 */
public class PessoaFisica extends DbModel {

    private String cpf;
    private String rg;
    private int idPessoa;
    private Date dataNascimento;
    private char sexo;
    private Pessoa pessoa;

    public PessoaFisica(int id, String cpf, String rg, int idPessoa,
            Date dataNascimento, char sexo, Pessoa pessoa) {
        super(id);
        this.cpf = cpf;
        this.rg = rg;
        this.idPessoa = idPessoa;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.pessoa = pessoa;
    }

    public PessoaFisica(int id, String cpf, String rg, int idPessoa,
            Date dataNascimento, char sexo) {
        this(id, cpf, rg, idPessoa, dataNascimento, sexo, null);
    }

    public PessoaFisica() {
        this(0, "", "", 0, null, 'f');
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Pessoa getPessoa() {
        if(pessoa==null){
            pessoa = getPessoaById(this.idPessoa);
        }
        return pessoa;
    }
    
    private Pessoa getPessoaById(int id){
        PessoaDAO ps;
        Pessoa p = null;
        try {
            ps = PessoaDAO.getInstance();
            p = (Pessoa) ps.getObjectById(id);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
