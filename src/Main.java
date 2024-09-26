import br.com.subsistema.model.*;
import br.com.subsistema.factory.ImpostoFactory;
import br.com.subsistema.factory.TipoImposto;
import br.com.subsistema.imposto.Imposto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();

        Produto produtoIndustrial = new Produto(123, "Milho", 100.00, true);
        Produto produtoNaoIndustrial = new Produto(456, "Espiga", 200.00, false);
        Servico servicoA = new Servico(3, "Serviço", 300.00);

        itens.add(produtoIndustrial);
        itens.add(produtoNaoIndustrial);
        itens.add(servicoA);

        ImpostoFactory impostoFactory = new ImpostoFactory();

        double totalProdutos = 0;
        double totalServicos = 0;
        double totalImpostosProdutos = 0;
        double totalImpostosServicos = 0;

        for (Item item : itens) {
            if (item instanceof Produto) {
                Produto produto = (Produto) item;

                // Aplicando ICMS
                Imposto icms = impostoFactory.getImposto(TipoImposto.ICMS, produto);
                double impostoICMS = icms.calcular(produto);

                // Aplicando IPI
                Imposto ipi = impostoFactory.getImposto(TipoImposto.IPI, produto);
                double impostoIPI = ipi.calcular(produto);

                totalProdutos += produto.getValor();
                totalImpostosProdutos += produto.getImposto();

                System.out.println("Produto: " + produto.descricao);
                System.out.println("Valor: R$ " + produto.getValor());
                System.out.println("Imposto ICMS: R$ " + impostoICMS);
                System.out.println("Imposto IPI: R$ " + impostoIPI);
                System.out.println("Total com Impostos: R$ " + produto.getTotal());
                System.out.println();
            } else if (item instanceof Servico) {
                Servico servico = (Servico) item;

                // Aplicando ISS
                Imposto iss = impostoFactory.getImposto(TipoImposto.ISS, servico);
                double impostoISS = iss.calcular(servico);

                // Total do serviço e do imposto
                totalServicos += servico.getValor();
                totalImpostosServicos += servico.getImposto();

                System.out.println("Serviço: " + servico.descricao);
                System.out.println("Valor: R$ " + servico.getValor());
                System.out.println("Imposto ISS: R$ " + impostoISS);
                System.out.println("Total com Impostos: R$ " + servico.getTotal());
                System.out.println();
            }
        }

        double totalGeral = totalProdutos + totalServicos;
        double totalImpostosGeral = totalImpostosProdutos + totalImpostosServicos;

        System.out.println("--> Resumo Final <--");
        System.out.println("Total Produtos: R$ " + totalProdutos);
        System.out.println("Total Impostos Produtos: R$ " + totalImpostosProdutos);
        System.out.println("Total Serviços: R$ " + totalServicos);
        System.out.println("Total Impostos Serviços: R$ " + totalImpostosServicos);
        System.out.println("Total Geral: R$ " + totalGeral);
        System.out.println("Total Impostos Geral: R$ " + totalImpostosGeral);
    }
}
