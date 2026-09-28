package contabil;

/**
 * Classe abstrata que concentra o unico comportamento realmente comum a
 * todos os impostos: o armazenamento e a exibicao de sua descricao (nome).
 *
 * <p>A base de calculo e a forma de calcular o valor do imposto variam de
 * imposto para imposto (e as aliquotas podem ser fixas ou nao), por isso o
 * metodo {@link #calcularValor()} permanece abstrato: cada subclasse
 * concreta e responsavel por implementa-lo de acordo com sua propria regra
 * de negocio.</p>
 */
public abstract class ImpostoAbstrato implements Imposto {

    private String descricao;

    protected ImpostoAbstrato(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public abstract double calcularValor();
}
