public class ContaPoupanca extends Conta {
    private int diaAniversario;
    private double taxaDeJuros;

    public ContaPoupanca(int numero, int agencia, String banco, double saldo, int diaAniversario, double taxaDeJuros) {
        super(numero, agencia, banco, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getSaldo() {
        return this.saldo + this.taxaDeJuros * this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Saldo: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        this.saldo -= valorSaque;
        System.out.println("Saldo: R$ " + getSaldo());
    }
}
