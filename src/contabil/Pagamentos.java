package contabil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa o "boletim de pagamentos" de impostos de uma empresa.
 *
 * <p>Guarda o nome da empresa e a lista de impostos cadastrados. A lista
 * aceita qualquer objeto que implemente a interface {@link Imposto},
 * permitindo que novos tipos de impostos sejam adicionados no futuro sem
 * qualquer alteracao nesta classe.</p>
 */
public class Pagamentos {

    private String nomeEmpresa;
    private List<Imposto> impostos;

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.impostos = new ArrayList<>();
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * @return uma visao somente-leitura da lista de impostos cadastrados.
     */
    public List<Imposto> getImpostos() {
        return Collections.unmodifiableList(impostos);
    }

    /**
     * Adiciona um novo imposto (PIS, IPI ou qualquer implementacao futura
     * de {@link Imposto}) a lista de pagamentos da empresa.
     */
    public void adicionarImposto(Imposto imposto) {
        if (imposto != null) {
            impostos.add(imposto);
        }
    }

    public int getQuantidadeImpostos() {
        return impostos.size();
    }

    /**
     * @return a soma do valor calculado de todos os impostos cadastrados.
     */
    public double getTotalImpostos() {
        double total = 0.0;
        for (Imposto imposto : impostos) {
            total += imposto.calcularValor();
        }
        return total;
    }
}
