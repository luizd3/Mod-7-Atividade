package db;

import modelos.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContasDB {

    private List<Conta> listaDeContas = new ArrayList<>();

    public List<Conta> getListaDeContas() {
        return listaDeContas;
    }

    public void addNovaConta(Conta conta) {
        int numeroConta = listaDeContas.size() + 1;
        conta.setNumeroConta(numeroConta); // Atribuindo número da conta automaticamente conforme o tamanho da lista.
        listaDeContas.add(conta);
    }
}
