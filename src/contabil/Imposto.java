package contabil;

/**
 * Interface que define o contrato comum a todos os impostos do sistema.
 *
 * <p>Qualquer novo imposto criado no futuro (ICMS, ISS, COFINS, etc.) deve
 * implementar esta interface — diretamente ou por meio da classe abstrata
 * {@link ImpostoAbstrato} — para poder ser cadastrado na lista de impostos
 * de um objeto {@link Pagamentos}, sem que seja necessário alterar nenhuma
 * outra classe do sistema.</p>
 */
public interface Imposto {

    /**
     * Calcula o valor do imposto de acordo com a regra de negocio especifica
     * de cada implementacao (cada imposto possui sua propria base de
     * calculo e sua propria aliquota, fixa ou variavel).
     *
     * @return o valor monetario calculado do imposto.
     */
    double calcularValor();

    /**
     * @return a descricao (nome) do imposto, por exemplo "PIS" ou "IPI".
     */
    String getDescricao();
}
