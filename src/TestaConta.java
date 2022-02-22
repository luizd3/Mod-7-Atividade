public class TestaConta {
    public static void main(String[] args) {

        ContaCorrente cc1 = new ContaCorrente(22,1,"Banco AA",100,1000);
        System.out.println(cc1);

        System.out.println("O saldo da conta corrente é R$ " + cc1.getSaldo());

        ContaPoupanca p1 = new ContaPoupanca(33,3,"Banco CCC", 10, 20, 0.05);
        System.out.println("O saldo da conta poupança é R$ " + p1.getSaldo());
    }
}
