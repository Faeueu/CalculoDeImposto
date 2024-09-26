package br.com.subsistema.factory;

import br.com.subsistema.imposto.*;
import br.com.subsistema.model.Item;

public class ImpostoFactory {
    public Imposto getImposto(TipoImposto tipo, Item item) {
        if (tipo == TipoImposto.ISS && item instanceof br.com.subsistema.model.Servico) {
            return new ISS();
        } else if ((tipo == TipoImposto.ICMS || tipo == TipoImposto.PIS || tipo == TipoImposto.IPI) && item instanceof br.com.subsistema.model.Produto) {
            switch (tipo) {
                case ICMS:
                    return new ICMS();
                case PIS:
                    return new PIS();
                case IPI:
                    return new IPI();
            }
        }
        throw new IllegalArgumentException("Tipo de imposto ou item incompatível");
    }
}
