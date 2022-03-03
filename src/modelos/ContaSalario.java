package modelos;

public class ContaSalario extends Conta{
    // Colocar número limite de saques.
    private int numLimiteSaques;

    public ContaSalario(int agencia, String banco, double saldo, int numLimiteSaques, TipoConta tipoConta) {
        super(agencia, banco, saldo, TipoConta.SALARIO);
        this.numLimiteSaques = numLimiteSaques;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
        System.out.println("Depósito efetuado. Saldo atual: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {

        if (numLimiteSaques > 0) {

            if (valorSaque > getSaldo()) {

                System.out.println("Saque não autorizado. Valor excede o saldo atual.");

            } else {

                this.saldo -= valorSaque;
                this.numLimiteSaques --;
                System.out.println("Saque efetuado. Saldo atual: R$ " + getSaldo() + ". Você tem " + getNumLimiteSaques() +
                        " saque(s) restante(s).");
            }

        } else {
            System.out.println("Saque não autorizado. Limite de saques excedido. Saldo: R$ " + getSaldo() + ".");
        }
    }

    public int getNumLimiteSaques() {
        return this.numLimiteSaques;
    }
}
