
package br.edu.ulbra.gde.model;

/**
 *
 * @author Thiago Moura
 */
public class Estado {
    private String nome;
    private String sigla;
    private static final String[] estados = new String[]{
                                        "Acre - AC",
                                        "Alagoas - AL",
                                        "Amapá - AP",
                                        "Amazonas - AM",
                                        "Bahia  - BA",
                                        "Ceará - CE",
                                        "Distrito Federal  - DF",
                                        "Espírito Santo - ES",
                                        "Goiás - GO",
                                        "Maranhão - MA",
                                        "Mato Grosso - MT",
                                        "Mato Grosso do Sul - MS",
                                        "Minas Gerais - MG",
                                        "Pará - PA",
                                        "Paraíba - PB",
                                        "Paraná - PR",
                                        "Pernambuco - PE",
                                        "Piauí - PI",
                                        "Rio de Janeiro - RJ",
                                        "Rio Grande do Norte - RN",
                                        "Rio Grande do Sul - RS",
                                        "Rondônia - RO",
                                        "Roraima - RR",
                                        "Santa Catarina - SC",
                                        "São Paulo - SP",
                                        "Sergipe - SE",
                                        "Tocantins - TO"
                                    };

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return this.nome+" - "+this.sigla;
    }

    public static String[] getEstados() {
        return estados;
    }
    
}
