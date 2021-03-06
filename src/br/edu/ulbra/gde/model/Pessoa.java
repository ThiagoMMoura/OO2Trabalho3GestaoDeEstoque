package br.edu.ulbra.gde.model;

import br.edu.ulbra.gde.control.*;
import java.sql.SQLException;
import java.util.logging.*;

/**
 *
 * @author Thiago Moura
 */
public class Pessoa extends DbModel {

    private String razaoSocial;
    private int idEndereco;
    private int numeroEndereco;
    private String complementoEndereco;
    private Endereco endereco;

    public Pessoa(int id, String razaoSocial, int idEndereco, int numeroEndereco, String complementoEndereco) {
        super(id);
        this.razaoSocial = razaoSocial;
        this.idEndereco = idEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
    }

    public Pessoa() {
        this(0, null, 0, 0, null);
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

    public Endereco getEndereco() {
        if(endereco==null){
            endereco = getEnderecoById(idEndereco);
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    private Endereco getEnderecoById(int id){
        EnderecoDAO ed;
        Endereco e = null;
        try {
            ed = EnderecoDAO.getInstance();
            e = (Endereco) ed.getObjectById(id);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}
