package br.com.myapp.myapplication;

/**
 * Created by darlei on 17/11/15.
 */
public class Itens {

    String descricao;
    Double valor;

    public Itens() {
        super();
    }

    public Itens(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
