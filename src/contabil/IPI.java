package contabil;

/**
 * Representa o calculo do IPI (Imposto sobre Produtos Industrializados).
 *
 * <p>Base de calculo = valorProduto + valorFrete + valorSeguro + outrasDespesas</p>
 * <p>Valor do imposto = base de calculo * aliquota</p>
 *
 * <p>Diferente do PIS, a aliquota do IPI nao e fixa: varia conforme o
 * produto, por isso e informada pelo usuario no momento do cadastro e
 * armazenada como atributo de instancia.</p>
 */
public class IPI extends ImpostoAbstrato {

    /** Aliquota do produto, representada em formato decimal (ex.: 0.05 para 5%). */
    private double aliquota;
    private double valorProduto;
    private double valorFrete;
    private double valorSeguro;
    private double outrasDespesas;

    public IPI(double aliquota, double valorProduto, double valorFrete,
            double valorSeguro, double outrasDespesas) {
        super("IPI");
        this.aliquota = aliquota;
        this.valorProduto = valorProduto;
        this.valorFrete = valorFrete;
        this.valorSeguro = valorSeguro;
        this.outrasDespesas = outrasDespesas;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    /**
     * @return a base de calculo do IPI (soma de produto, frete, seguro e
     * outras despesas).
     */
    public double getBaseCalculo() {
        return valorProduto + valorFrete + valorSeguro + outrasDespesas;
    }

    @Override
    public double calcularValor() {
        return getBaseCalculo() * aliquota;
    }

    @Override
    public String toString() {
        return String.format("IPI [base=%.2f, aliquota=%.2f%%, valor=%.2f]",
                getBaseCalculo(), aliquota * 100, calcularValor());
    }
}
