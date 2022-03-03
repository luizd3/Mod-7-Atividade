package modelos;

public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(int agencia, String banco, double saldo, double chequeEspecial, TipoConta tipoConta) {
        super(agencia, banco, saldo, TipoConta.CORRENTE);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "contas.ContaCorrente{" +
                "chequeEspecial=" + chequeEspecial +
                '}';
    }

    public double getSaldo() {
        return this.chequeEspecial + this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
        System.out.println("Depósito efetuado. Saldo atual: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        if ((getSaldo() - valorSaque) >= 0) {
            if ((getSaldo() - valorSaque) > chequeEspecial) {
                this.saldo -= valorSaque;
                System.out.println("Saque efetuado. Saldo atual: R$ " + getSaldo() + ". Cheque especial: " + chequeEspecial);
            } else {
                this.saldo -= valorSaque;
                System.out.println("Saque efetuado. Saldo principal zero. Saldo cheque especial: " + getSaldo());
            }
        } else {
            System.out.println("Saque não autorizado. Limite do cheque especial excedido. Saldo atual: R$ " + getSaldo());
        }
    }

    public double getChequeEspecial() {
        return this.chequeEspecial;
    }

}
