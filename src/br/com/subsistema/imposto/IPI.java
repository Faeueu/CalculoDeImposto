package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;
import br.com.subsistema.model.Produto;

public class IPI implements Imposto {
    @Override
    public double calcular(Item item) {
        if (item instanceof Produto) {
            Produto produto = (Produto) item;
            if (produto.isIndustrial()) {
                double imposto = item.getValor() * 0.12;
                item.setImposto(imposto);
                return imposto;
            } else {
                item.setImposto(0);
                return 0;
            }
        } else {
            throw new IllegalArgumentException("O IPI só pode ser aplicado a produtos.");
        }
    }
}
