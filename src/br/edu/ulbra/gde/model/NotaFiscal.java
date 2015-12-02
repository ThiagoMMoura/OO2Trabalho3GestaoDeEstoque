package br.edu.ulbra.gde.model;

import java.util.Date;

/**
 *
 * @author Thiago Moura
 */
public class NotaFiscal extends DbModel {

    private int numero;
    private String serie;
    private String chaveAcesso;
    private int entradaSaida;
    private String naturezaOperacao;
    private Date dataEmissao;
    private Date dataEntradaSaida;
    private int idPessoa;
    private String informacoesComplementares;

    public NotaFiscal(int id, int numero, String serie, String chaveAcesso,
            int entradaSaida, String naturezaOperacao, Date dataEmissao,
            Date dataEntradaSaida, int idPessoa, String informacoesComplementares) {
        super(id);
        this.numero = numero;
        this.serie = serie;
        this.chaveAcesso = chaveAcesso;
        this.entradaSaida = entradaSaida;
        this.naturezaOperacao = naturezaOperacao;
        this.dataEmissao = dataEmissao;
        this.dataEntradaSaida = dataEntradaSaida;
        this.idPessoa = idPessoa;
        this.informacoesComplementares = informacoesComplementares;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public int getEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(int entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntradaSaida() {
        return dataEntradaSaida;
    }

    public void setDataEntradaSaida(Date dataEntradaSaida) {
        this.dataEntradaSaida = dataEntradaSaida;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }

}
