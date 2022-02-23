import java.util.Scanner;

public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
        super(numero, agencia, banco, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "chequeEspecial=" + chequeEspecial +
                '}';
    }

    public double getSaldo() {
        return this.chequeEspecial + this.saldo;
    }

    public void depositar(double valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
        System.out.println("Saldo: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        if ((getSaldo() - valorSaque) >= 0) {
            this.saldo -= valorSaque;
            System.out.println("Saldo: R$ " + getSaldo());
        } else {
            System.out.println("Saque não realizado. Limite do cheque especial excedido. Saldo: R$ " + getSaldo());
        }
    }
}
