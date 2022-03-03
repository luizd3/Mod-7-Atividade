package modelos;

import java.util.Calendar;

public class ContaPoupanca extends Conta {
    private int diaAniversario;
    private double taxaDeJuros;

    public ContaPoupanca(int agencia, String banco, double saldo, int diaAniversario, double taxaDeJuros, TipoConta tipoConta) {
        super(agencia, banco, saldo, TipoConta.POUPANCA);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getSaldo() {
        Calendar data = Calendar.getInstance();
        int diaHoje = data.get(Calendar.DAY_OF_MONTH);
        if (diaHoje > diaAniversario) {
            return this.saldo + this.taxaDeJuros * this.saldo;
        } else {
            return this.saldo;
        }
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Depósito efetuado. Saldo atual: R$ " + getSaldo());
    }

    public void sacar(double valorSaque) {
        this.saldo -= valorSaque;
        System.out.println("Saque efetuado. Saldo atual: R$ " + getSaldo());
    }

    public int getDiaAniversario() {
        return this.diaAniversario;
    }

    public double getTaxaDeJuros() {
        return this.taxaDeJuros;
    }

}
