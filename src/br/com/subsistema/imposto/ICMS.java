package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;

public class ICMS implements Imposto {
    @Override
    public double calcular(Item item) {
        double imposto = item.getValor() * 0.18;
        item.setImposto(imposto);
        return imposto;
    }
}
