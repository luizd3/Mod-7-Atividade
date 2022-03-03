package modelos;

public abstract class Conta {
    private int numeroConta;
    private int agencia;
    private String banco;
    protected double saldo;
    private TipoConta tipoConta;

    public Conta(int agencia, String banco, double saldo, TipoConta tipoConta) {
        this.agencia = agencia;
        this.banco = banco;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "contas.Conta{" +
                "numero=" + numeroConta +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                ", tipoConta=" + tipoConta +
                '}';
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public abstract double getSaldo();

    public TipoConta getTipoConta () {
        return tipoConta;
    }

    public abstract void depositar(double valorDeposito);

    public abstract void sacar(double valorSaque);

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
