package br.com.subsistema.model;

public abstract class Item {
    public int codigo;
    public String descricao;
    public double valor;
    public double imposto;
    public double total;

    public Item(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
        this.total = valor + imposto;
    }

    public double getTotal() {
        return total;
    }
}
