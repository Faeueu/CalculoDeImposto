package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;
import br.com.subsistema.model.Servico;

public class ISS implements Imposto {
    @Override
    public double calcular(Item item) {
        if (item instanceof Servico) {
            double imposto = item.getValor() * 0.22;
            item.setImposto(imposto);
            return imposto;
        } else {
            throw new IllegalArgumentException("O ISS só pode ser aplicado a serviços.");
        }
    }
}
