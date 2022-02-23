public class ContaSalario extends Conta{
    // Colocar número limite de saques.
    private int numLimiteSaques;

    public ContaSalario(int numero, int agencia, String banco, double saldo, int numLimiteSaques) {
        super(numero, agencia, banco, saldo);
        this.numLimiteSaques = numLimiteSaques;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
        System.out.println("Saldo: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        if (numLimiteSaques > 0) {
            this.saldo = this.saldo - valorSaque;
            this.numLimiteSaques -= 1;
            System.out.println("Saldo: R$ " + getSaldo());
        } else {
            System.out.println("Limite de saque excedido.");
        }
    }
}
