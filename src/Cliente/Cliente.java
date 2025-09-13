//atributos

package Cliente;

import java.lang.annotation.Target;

public class Cliente {
    private String nome;
    private String tipoConta;
    private int saldo;
    // linkando obj com atributos/variavel
    public Cliente(String nome, String tipoConta, int saldoInicial) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
    }
     //pega o nome e retorna ex
    public String getNome() {
        return nome;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void receberValor(int valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
    // calculo saldo pra enviar
    public boolean enviarPix(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
