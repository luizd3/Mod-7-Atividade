import db.ContasDB;
import modelos.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class TestaConta {

    static ContasDB contasDB = new ContasDB();

    public static void main(String[] args) {

        System.out.println("----------- BANCO -----------");
        int opcao;
        do {
            System.out.println("1- Cadastrar nova conta");
            System.out.println("2- Exibir lista de contas cadastradas");
            System.out.println("3- Depositar");
            System.out.println("4- Sacar");
            System.out.println("5- Para teste: cadastrar várias contas automaticamente");
            System.out.println("0- Sair");
            System.out.print("Digite o número da operação desejada: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            menu(opcao);

        } while (opcao != 0);
    }

    public static void menu (int opcao){
        switch (opcao) {
            case 1 : { // Nova conta
                int opcao1 = 0;

                do {
                    System.out.println("1- Cadastrar nova Conta Corrente");
                    System.out.println("2- Cadastrar nova Conta Poupança");
                    System.out.println("3- Cadastrar nova Conta Salário");
                    System.out.println("0- Voltar");
                    System.out.print("Digite o número da operação desejada: ");
                    Scanner scanner = new Scanner(System.in);
                    opcao1 = scanner.nextInt();

                    submenu1(opcao1);

                } while (opcao1 != 0);

                break;
            }

            case 2 : { // Exibir lista de contas
                System.out.println("---------------------------------- LISTANDO CONTAS CADASTRADAS ----------------------------------");
                for (Conta conta : contasDB.getListaDeContas()) {
                    System.out.print("Conta nº: " + conta.getNumeroConta() + " -->");
                    System.out.print(" Banco: " + conta.getBanco());
                    System.out.print(" | Agência: " + conta.getAgencia());
                    System.out.print(" | Saldo: " + conta.getSaldo());
                    if (conta.getTipoConta() == TipoConta.CORRENTE) {
                        System.out.print(" | Tipo: Corrente");
                        int index = conta.getNumeroConta() - 1;
                        ContaCorrente contaCorrente = (ContaCorrente) contasDB.getListaDeContas().get(index);
                        System.out.print(" | Cheque especial: " + contaCorrente.getChequeEspecial());
                    }
                    if (conta.getTipoConta() == TipoConta.POUPANCA) {
                        System.out.print(" | Tipo: Poupança");
                        int index = conta.getNumeroConta() - 1;
                        ContaPoupanca contaPoupanca = (ContaPoupanca) contasDB.getListaDeContas().get(index);
                        System.out.print(" | Dia Aniversário: " + contaPoupanca.getDiaAniversario());
                        System.out.print(" | Taxa de Juros: " + contaPoupanca.getTaxaDeJuros());
                    }
                    if (conta.getTipoConta() == TipoConta.SALARIO) {
                        System.out.print(" | Tipo: Salário");
                        int index = conta.getNumeroConta() - 1;
                        ContaSalario contaSalario = (ContaSalario) contasDB.getListaDeContas().get(index);
                        System.out.print(" | Limite de Saques: " + contaSalario.getNumLimiteSaques());
                    }
                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                }
                break;
            }

            case 3 : { // Depositar
                if (contasDB.getListaDeContas().isEmpty()) {
                    System.out.println("Não há contas cadastradas. Cadastre uma conta.");
                } else {
                    System.out.print("Digite o número da conta para fazer o depósito: ");
                    Scanner scanner = new Scanner(System.in);
                    int numeroConta = scanner.nextInt();

                    while (numeroConta > contasDB.getListaDeContas().size()) {
                        System.out.print("Não existe esta conta. Digite um número entre 1 e " +
                                contasDB.getListaDeContas().size() + ": ");
                        numeroConta = scanner.nextInt();
                    }

                    Conta conta = contasDB.getListaDeContas().get(numeroConta - 1);
                    System.out.println("O saldo desta conta é R$ " + conta.getSaldo());
                    System.out.print("Digite o valor que deseja DEPOSITAR: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                }
                break;
            }
            case 4 : { // Sacar
                if (contasDB.getListaDeContas().isEmpty()) {
                    System.out.println("Não há contas cadastradas. Cadastre uma conta.");
                } else {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite o número da conta para fazer o saque: ");
                    int numeroConta = scanner.nextInt();

                    while (numeroConta > contasDB.getListaDeContas().size()) {
                        System.out.print("Não existe esta conta. Digite um número entre 1 e " +
                                contasDB.getListaDeContas().size() + ": ");
                        numeroConta = scanner.nextInt();
                    }

                    Conta conta = contasDB.getListaDeContas().get(numeroConta - 1);
                    System.out.println("O saldo desta conta é R$ " + conta.getSaldo());
                    System.out.print("Digite o valor que deseja SACAR: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                }
                break;
            }
            case 5 : { // Cadastrar algumas contas automaticamente
                System.out.println("Cadastrando algumas contas automaticamente...");
                ContaCorrente novaContaCorrente = new ContaCorrente(10,"A",100,500,TipoConta.CORRENTE);
                contasDB.addNovaConta(novaContaCorrente);
                ContaPoupanca novaContaPoupanca = new ContaPoupanca(20,"B",200,15,0.05,TipoConta.POUPANCA);
                contasDB.addNovaConta(novaContaPoupanca);
                ContaSalario novaContaSalario = new ContaSalario(3, "C", 500, 2, TipoConta.SALARIO);
                contasDB.addNovaConta(novaContaSalario);
                break;
            }

        }
    }

    public static void submenu1(int opcao1) {
        switch (opcao1) {
            case 1 : { // Nova conta corrente
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o nome do banco: ");
                String banco = scanner.nextLine();
                System.out.print("Digite o número da agência: ");
                int agencia = scanner.nextInt();
                System.out.print("Digite o valor do saldo: ");
                double saldo = scanner.nextDouble();
                System.out.print("Digite o valor do cheque especial: ");
                double chequeEspecial = scanner.nextDouble();

                ContaCorrente novaContaCorrente = new ContaCorrente(agencia, banco, saldo, chequeEspecial, TipoConta.CORRENTE);

                contasDB.addNovaConta(novaContaCorrente);

                System.out.println("Conta corrente cadastrada.");
                break;
            }
            case 2 : { // Nova Conta poupança
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o nome do banco: ");
                String banco = scanner.nextLine();
                System.out.print("Digite o número da agência: ");
                int agencia = scanner.nextInt();
                System.out.print("Digite o valor do saldo: ");
                double saldo = scanner.nextDouble();
                System.out.print("Digite o dia do aniversário: ");
                int diaAniversario = scanner.nextInt();
                System.out.print("Digite a taxa de juros: ");
                double taxaDeJuros = scanner.nextDouble();

                ContaPoupanca novaContaPoupanca = new ContaPoupanca(agencia,banco,saldo,diaAniversario,taxaDeJuros,TipoConta.POUPANCA);

                contasDB.addNovaConta(novaContaPoupanca);

                System.out.println("Conta Poupança cadastrada.");
                break;
            }
            case 3 : {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o nome do banco: ");
                String banco = scanner.nextLine();
                System.out.print("Digite o número da agência: ");
                int agencia = scanner.nextInt();
                System.out.print("Digite o valor do saldo: ");
                double saldo = scanner.nextDouble();
                System.out.print("Digite o número limite de saques: ");
                int numLimiteSaques = scanner.nextInt();

                ContaSalario novaContaSalario = new ContaSalario(agencia,banco,saldo,numLimiteSaques,TipoConta.SALARIO);

                contasDB.addNovaConta(novaContaSalario);

                System.out.println("Conta Salário cadastrada.");
                break;
            }
        }
    }
}
