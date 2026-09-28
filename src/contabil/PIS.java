package contabil;

/**
 * Representa o calculo do PIS (Programa de Integracao Social).
 *
 * <p>Formula: {@code (valorDebito - valorCredito) * 1,65%}</p>
 *
 * <p>A aliquota do PIS e fixa (1,65%), por isso e representada por uma
 * constante da classe.</p>
 */
public class PIS extends ImpostoAbstrato {

    /** Aliquota fixa do PIS: 1,65%. */
    private static final double ALIQUOTA_PIS = 0.0165;

    private double valorDebito;
    private double valorCredito;

    public PIS(double valorDebito, double valorCredito) {
        super("PIS");
        this.valorDebito = valorDebito;
        this.valorCredito = valorCredito;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    /**
     * @return a aliquota fixa aplicada ao PIS (1,65%, representada como 0.0165).
     */
    public double getAliquota() {
        return ALIQUOTA_PIS;
    }

    @Override
    public double calcularValor() {
        return (valorDebito - valorCredito) * ALIQUOTA_PIS;
    }

    @Override
    public String toString() {
        return String.format("PIS [debito=%.2f, credito=%.2f, valor=%.2f]",
                valorDebito, valorCredito, calcularValor());
    }
}
