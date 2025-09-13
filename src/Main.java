//menu com interface co
import javax.swing.JOptionPane;

import Cliente.Cliente;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Cleiton", "Corrente", 2500);


        mostrarDadosCliente(cliente);

        int opcao = 0;

        while (opcao != 4) {
            opcao = mostrarMenu();

            switch (opcao) {
                case 1:
                    consultarSaldo(cliente);
                    break;
                case 2:
                    receberValor(cliente);
                    break;
                case 3:
                    enviarPix(cliente);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Tchau, obrigado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número entre 1 e 4.");
                    break;
            }
        }
    }


    public static void mostrarDadosCliente(Cliente cliente) {
        String mensagem = "Dados iniciais do cliente:\n\n" +
                "Nome:           " + cliente.getNome() + "\n" +
                "Tipo de conta:  " + cliente.getTipoConta() + "\n" +
                "Saldo Inicial:  " + cliente.getSaldo() + "\n" +
                "**********************************************\n";
        JOptionPane.showMessageDialog(null, mensagem);
    }

    //menu de opcao
    public static int mostrarMenu() {
        String menu = "Operações\n\n" +
                "1 - Consultar Saldo\n" +
                "2 - Receber valor\n" +
                "3 - Enviar Pix\n" +
                "4 - Sair\n\n" +
                "Digite a opção desejada:";
        String input = JOptionPane.showInputDialog(menu);
         //se 0 apeta 4 auto
        if (input == null) {
           //input vazio retorna 4 = sair
            return 4;
        }
        //loop pra se seleciona caractere errado
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número.");
            return 0; // opção inválida
        }
    }


    public static void consultarSaldo(Cliente cliente) {
        JOptionPane.showMessageDialog(null, "Saldo Atual: R$ " + cliente.getSaldo());
    }


    public static void receberValor(Cliente cliente) {
        String input = JOptionPane.showInputDialog("Digite um valor a receber:");
        if (input == null) {
            return; // retorna nada se 0
        }
        try {
            int valor = Integer.parseInt(input);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um valor positivo.");
                return;
            }
            cliente.receberValor(valor);
            JOptionPane.showMessageDialog(null, "Valor recebido com sucesso!\nSaldo Atual: R$ " + cliente.getSaldo());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido!");
        }
    }


    public static void enviarPix(Cliente cliente) {
        String input = JOptionPane.showInputDialog("Digite um valor para enviar:");
        if (input == null) {
            return; // 0 retorna nada
        }
        try { // calculo para tranferencias > ou <
            int valor = Integer.parseInt(input);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um valor positivo.");
                return;
            }
            boolean sucesso = cliente.enviarPix(valor);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Pix enviado com sucesso!\nSaldo Atual: R$ " + cliente.getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido!");
            //System.out.println(mostrarDadosCliente(cliente);
        }
    }


}
