public class TestaConta {
    public static void main(String[] args) {

        ContaCorrente cc1 = new ContaCorrente(22,1,"Banco AA",100,1000);
        System.out.println(cc1);

        System.out.println("O saldo da conta corrente é R$ " + cc1.getSaldo());

        ContaPoupanca p1 = new ContaPoupanca(33,3,"Banco CCC", 10, 20, 0.05);
        System.out.println("O saldo da conta poupança é R$ " + p1.getSaldo());

        ContaSalario s1 = new ContaSalario(41,3,"Banco CCC",200,2);
        System.out.println("O saldo da conta salário é R$ " + s1.getSaldo());

        // Sacando 25,55 reais da conta corrente cc1:
        double valorSaque = 1100;
        System.out.println("Saque na conta corrente: R$ " + valorSaque);
        cc1.sacar(valorSaque);

        // Depositando 200 reais na conta corrente cc1:
        double valorDeposito = 200;
        System.out.println("Depósito na conta corrente: R$ " + valorDeposito);
        cc1.depositar(valorDeposito);

        // Depositando 300 reais na conta poupança p1:
        valorDeposito = 300;
        System.out.println("Depósito na conta poupança: R$ " + valorDeposito);
        p1.depositar(valorDeposito);


    }
}
