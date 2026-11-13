# Folha_de_Pagamento

## 1. Qual é a diferença entre classe e objeto? Identifique dois objetos do seu programa.

Classe é como um modelo que define as características e funções. Já o objeto é algo criado a partir dessa classe. No meu programa, Ana e Bruno são dois objetos da classe Funcionario.

## 2. O que o construtor garante na criação? Por que o regime não tem setter?

O construtor garante que o funcionário seja criado com os dados necessários e válidos, como nome, salário e regime. O regime não tem setter porque ele é definido na criação e não pode ser alterado depois.

## 3. Por que o FGTS aparece no demonstrativo, mas não reduz o líquido?

Porque o FGTS é um valor depositado pela empresa para o trabalhador, e não um desconto do salário dele. Por isso, aparece no demonstrativo, mas não diminui o salário líquido.

## 4. Qual método foi sobrescrito? O que acontece quando o cálculo de INSS chama esse método em um professor?

O método calcularBruto() foi sobrescrito nas classes FuncionarioPJ e Professor. Quando o INSS chama esse método em um professor, o programa usa o cálculo da classe Professor, considerando as horas-aula e o DSR.

## 5. Por que um professor CLT herdar de uma classe chamada FuncionarioPJ causa um problema de modelagem? Sugira um nome ou uma organização melhor para compartilhar o cálculo por hora, sem precisar implementar.

Porque um professor CLT não é um funcionário PJ, então essa herança não representa corretamente a realidade. Uma solução melhor seria criar uma classe chamada FuncionarioPorHora, que poderia ser usada tanto pelo professor quanto pelo funcionário PJ, sem misturar os regimes.
