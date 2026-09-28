# ModuloContabil - Sistema de Gestão de Impostos Corporativos

Aplicação em linha de comando (CLI) desenvolvida em **Java** para registo, cálculo automatizado de tributos corporativos (**PIS** e **IPI**) e emissão de relatórios de pagamentos empresariais.

---

##  Sobre o Projeto

O **ModuloContabil** foi desenvolvido como atividade prática para simular a gestão fiscal e tributária de uma empresa. O sistema permite o registo dinâmico de múltiplos impostos com regras de cálculo específicas (alíquotas fixas e variáveis) e calcula o total geral devido de forma automatizada.

---

##  Funcionalidades

- **Registo Dinâmico de Impostos:** Entrada contínua de impostos no terminal até o utilizador digitar `pare`.
- **Cálculo do PIS:** Aplicação automática da alíquota fixa de **1,65%** sobre a diferença entre o valor total de débito e crédito.
- **Cálculo do IPI:** Cálculo baseado na soma do valor do produto, frete, seguro e outras despesas, aplicando a alíquota informada.
- **Relatório de Pagamentos:** Listagem detalhada de cada imposto cadastrado e cálculo do valor total acumulado pela empresa.

---

##  Conceitos de POO Aplicados

* **Interfaces (`Imposto`):** Define o contrato padrão (`calcularValor()` e `getDescricao()`) para qualquer tributo do sistema.
* **Classes Abstratas (`ImpostoAbstrato`):** Centraliza a gestão do nome/descrição dos impostos.
* **Herança (`PIS` e `IPI`):** Subclasses concretas que estendem `ImpostoAbstrato` e definem as suas próprias bases e alíquotas de cálculo.
* **Polimorfismo:** A classe `Pagamentos` gere uma lista genérica `List<Imposto>`, permitindo calcular o valor total de qualquer combinação de impostos de forma dinâmica.
* **Encapsulamento:** Proteção de atributos privados e disponibilização de vista só de leitura para a lista de impostos (`Collections.unmodifiableList`).

---

##  Estrutura do Repositório

```text
modulo-contabil/
├── src/
│   └── contabil/
│       ├── Imposto.java
│       ├── ImpostoAbstrato.java
│       ├── IPI.java
│       ├── Main.java
│       ├── Pagamentos.java
│       └── PIS.java
├── .gitignore
├── README.md
└── print.png
```
Como Executar
Pré-requisitos
Java Development Kit (JDK) 8 ou superior instalado.

Demonstração Visual

![Execução do Sistema](print.png)

---

👤 Autor

Desenvolvido por **Eduardo Amaral**  
[GitHub Profile](https://github.com/Ravz7) | [LinkedIn](https://www.linkedin.com/in/eduardo-amaral-de-morais-2785a53a0/)
