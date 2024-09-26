# Sistema de Cálculo de Impostos para Produtos e Serviços

## Objetivo

Este projeto tem como objetivo desenvolver um subsistema que realiza o cálculo de impostos para produtos e serviços, utilizando a arquitetura orientada a objetos e seguindo boas práticas de programação. O sistema permite gerar etiquetas de produtos contendo o valor final dos itens, com os impostos calculados de acordo com as regras de negócio definidas.

## Estrutura do Projeto
### O projeto está dividido em pacotes para facilitar a manutenção e escalabilidade:

* model: Contém as classes que representam os itens (produtos e serviços) e a classe principal (Main).<

* imposto: Contém as implementações dos diferentes tipos de impostos (ICMS, IPI, PIS, ISS) e a interface Imposto.

* factory: Contém a ImpostoFactory, que é responsável por criar e retornar os impostos corretos, de acordo com o tipo de item e as regras de negócio.

## Pacotes e Classes
### model:

* Item: Classe abstrata que representa um item genérico com código, descrição, valor, imposto calculado e total.

* Produto: Classe que herda de Item e contém o atributo adicional industrial, que define se o produto é industrial.

* Servico: Classe que herda de Item e representa um serviço.

* Main: Classe principal onde os itens são criados e os impostos são aplicados, além de gerar o relatório final.

### imposto:
* Imposto: Interface que define o método calcular(Item item) para todas as implementações de impostos.

* ICMS, IPI, PIS, ISS: Classes que implementam a interface Imposto, cada uma representando um tipo de imposto com sua respectiva taxa de cálculo.

### factory:
* ImpostoFactory: Classe que implementa o padrão de projeto Factory, responsável por fornecer a implementação correta de imposto com base no tipo de imposto e no item (produto ou serviço).
* TipoImposto: Enum que define os diferentes tipos de impostos: ICMS, IPI, PIS, ISS.

## Regras de Negócio
### O sistema foi desenvolvido com base em duas regras de negócio principais:

* 1. Regra de Negócio 1: O imposto ISS só deve ser aplicado a itens do tipo Servico. Para produtos, o imposto ISS não é aplicável, gerando uma exceção caso seja tentado.

* 2. Regra de Negócio 2: O imposto IPI só deve ser aplicado a produtos industriais (definidos pelo atributo industrial da classe Produto). Se o produto não for industrial, o valor do imposto IPI será zero.

## Exemplo de Funcionamento
### No Main, foi criada uma lista de itens composta por:

* Um produto industrial.

* Um produto não industrial.

* Um serviço.

### Os impostos são aplicados de acordo com as regras de negócio e, no final, é gerado um relatório que apresenta:

* O valor do produto ou serviço.

* Os impostos aplicados.

* O valor total do item com os impostos.

* Um resumo final com a soma total dos valores e dos impostos, separados por produtos e serviços.

## Arquitetura do Sistema
### A arquitetura é baseada em:

* Polimorfismo: O método calcular da interface Imposto é implementado de forma diferente em cada classe de imposto (ICMS, IPI, PIS, ISS), permitindo a aplicação correta de acordo com o tipo do item (Produto ou Servico).

* Factory Pattern: A fábrica de impostos (ImpostoFactory) permite que o sistema escolha a implementação correta do imposto com base no tipo do item e do imposto desejado.

* Herança: A classe Item é abstrata, servindo de base para Produto e Servico, centralizando atributos e comportamentos comuns a ambos.


 
 
