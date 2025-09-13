import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // Strings
        String nome = "CleitonMendes";
        String tipoConta = "Corrente";
        int saldo = 2500;
        int numUser  = 0;

        JOptionPane.showMessageDialog(null,
                "Dados iniciais do cliente:\n\n" +
                        "Nome:           " + nome + "\n" +
                        "Tipo de conta:  " + tipoConta + "\n" +
                        "Saldo Inicial:  " + saldo + "\n" +
                        "**********************************************\n");

        while (numUser  != 4) {
            String menu =    //obrigado compilador fex o block sozinho
                    """
                            Operações\s
                            
                            1 - Consultar Saldos
                            2 - Receber valor
                            3 - Enviar Pix
                            4 - Sair
                            
                            Digite a opção desejada:""";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) {
                // se cancelar op
                break;
            }
            try { //se cancelar tentar e capiturar o erro aquio
                numUser  = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número.");
                continue;
            }
            // switch case pra o codigo decidir sem ifs
            switch (numUser ) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo Atual: " + saldo);
                    break;
                // aqui precisei dos universitarios pra tirar os erros de syntax
                case 2:
                    String valorRecebidoStr = JOptionPane.showInputDialog("Digite um valor a receber:");
                    if (valorRecebidoStr == null) break;
                    try {
                        int valorRecebido = Integer.parseInt(valorRecebidoStr);
                        if (valorRecebido < 0) {
                            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um valor positivo.");
                            break;
                        }
                        saldo += valorRecebido;
                        JOptionPane.showMessageDialog(null, "Valor caiu com sucesso!\nSaldo Atual: " + saldo);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Digite um valor valido");
                    }
                    break;
                   //aqui ja foi de boa case3 para enviar o valor sem conflito de saldo
                case 3:
                    String valorEnviadoStr = JOptionPane.showInputDialog("Digite um valor para tranferir:");
                    if (valorEnviadoStr == null) break;

                    try {
                        int valorEnviado = Integer.parseInt(valorEnviadoStr);
                        if (valorEnviado < 0) {
                            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um valor positivo.");
                            break;
                        }
                        if (valorEnviado > saldo) {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        } else {
                            saldo -= valorEnviado;
                            JOptionPane.showMessageDialog(null, "Pix enviado com sucesso!\nSaldo Atual: " + saldo);
                        }
                        //ler erro e para
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Digite um valor válido!");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Tchau obrigado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número entre 1 e 4.");
                    break;
            }
        }
    }
}
