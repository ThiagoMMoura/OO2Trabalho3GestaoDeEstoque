package br.edu.ulbra.gde.model;

import java.util.Date;

/**
 *
 * @author Douglas, Thiago
 */
public class Pedido extends DbModel {

    private String cnpj;
    private Date data;
    private String observacao;
    private String descricao;

    public Pedido(int id, String cnpj, Date data, String observacao, String descricao) {
        super(id);
        this.cnpj = cnpj;
        this.data = data;
        this.observacao = observacao;
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
