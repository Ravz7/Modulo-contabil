package contabil;

import java.util.Locale;
import java.util.Scanner;

/**
 * Programa de teste do modulo contabil.
 *
 * <p>Permite cadastrar, para uma empresa, uma quantidade indefinida de
 * impostos (PIS e/ou IPI, em qualquer ordem e quantidade), encerrando a
 * entrada de dados quando o usuario digitar "pare". Ao final, exibe a
 * descricao e o valor calculado de cada imposto cadastrado, alem do total
 * geral pago pela empresa.</p>
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // usado apenas para formatacao numerica interna (String.format)

        System.out.println("=====================================================");
        System.out.println("   MODULO CONTABIL - CADASTRO DE IMPOSTOS");
        System.out.println("=====================================================");

        System.out.print("Informe o nome da empresa: ");
        String nomeEmpresa = SCANNER.nextLine().trim();

        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        cadastrarImpostos(pagamentos);
        exibirRelatorio(pagamentos);
    }

    /**
     * Le, em loop, o tipo de imposto que o usuario deseja cadastrar,
     * encerrando somente quando "pare" for digitado.
     */
    private static void cadastrarImpostos(Pagamentos pagamentos) {
        System.out.println();
        System.out.println("Tipos de imposto disponiveis: PIS, IPI");
        System.out.println("Digite 'pare' a qualquer momento para encerrar o cadastro.");
        System.out.println();

        while (true) {
            System.out.print("Tipo de imposto (PIS/IPI/pare): ");
            String tipo = SCANNER.nextLine().trim();

            if (tipo.equalsIgnoreCase("pare")) {
                break;
            }

            switch (tipo.toUpperCase()) {
                case "PIS":
                    cadastrarPIS(pagamentos);
                    break;
                case "IPI":
                    cadastrarIPI(pagamentos);
                    break;
                default:
                    System.out.println(">> Tipo invalido. Digite PIS, IPI ou 'pare'.");
                    System.out.println();
            }
        }
    }

    private static void cadastrarPIS(Pagamentos pagamentos) {
        System.out.println();
        System.out.println("--- Cadastro de PIS ---");
        double debito = lerValor("Valor total de debito: R$ ");
        double credito = lerValor("Valor total de credito: R$ ");

        Imposto pis = new PIS(debito, credito);
        pagamentos.adicionarImposto(pis);

        System.out.printf("PIS cadastrado! Valor calculado: R$ %.2f%n", pis.calcularValor());
        System.out.println();
    }

    private static void cadastrarIPI(Pagamentos pagamentos) {
        System.out.println();
        System.out.println("--- Cadastro de IPI ---");
        double aliquotaPercentual = lerValor("Aliquota do IPI (em %, ex: 5 para 5%): ");
        double valorProduto = lerValor("Valor do produto: R$ ");
        double frete = lerValor("Valor do frete: R$ ");
        double seguro = lerValor("Valor do seguro: R$ ");
        double outrasDespesas = lerValor("Valor de outras despesas: R$ ");

        Imposto ipi = new IPI(aliquotaPercentual / 100.0, valorProduto, frete, seguro, outrasDespesas);
        pagamentos.adicionarImposto(ipi);

        System.out.printf("IPI cadastrado! Valor calculado: R$ %.2f%n", ipi.calcularValor());
        System.out.println();
    }

    /**
     * Le um valor numerico do teclado, aceitando tanto ponto quanto virgula
     * como separador decimal, repetindo a pergunta ate que um numero valido
     * seja informado.
     */
    private static double lerValor(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = SCANNER.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println(">> Valor invalido. Digite um numero (ex: 1500.50 ou 1500,50).");
            }
        }
    }

    private static void exibirRelatorio(Pagamentos pagamentos) {
        System.out.println("=====================================================");
        System.out.println("   RELATORIO DE PAGAMENTOS");
        System.out.println("=====================================================");
        System.out.println("Empresa: " + pagamentos.getNomeEmpresa());
        System.out.println("Impostos cadastrados: " + pagamentos.getQuantidadeImpostos());
        System.out.println("-----------------------------------------------------");

        if (pagamentos.getImpostos().isEmpty()) {
            System.out.println("Nenhum imposto foi cadastrado.");
        } else {
            int contador = 1;
            for (Imposto imposto : pagamentos.getImpostos()) {
                System.out.printf("%d) %-6s valor calculado: R$ %.2f%n",
                        contador, imposto.getDescricao(), imposto.calcularValor());
                contador++;
            }
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("TOTAL GERAL: R$ %.2f%n", pagamentos.getTotalImpostos());
        System.out.println("=====================================================");
    }
}
