
import static java.lang.Math.abs;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        int valor1 = 0, valor2 = 0;

        try {
            valor1 = getValor();
            valor2 = getValor();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "ERRO: Um dos valores inseridos é inválido.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        }

        if ((valor1 > 127) || (valor2 > 127)) {
            JOptionPane.showMessageDialog(null, "ERRO: O resultado excede a memória.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        } else if ((valor1 < -127) || (valor2 < -127)) {
            JOptionPane.showMessageDialog(null, "ERRO: O resultado excede a memória.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        }

        String[] escolhas = {"00 (Soma)", "01 (Subtração)"};
        int n = JOptionPane.showOptionDialog(null, "Escolha uma operação abaixo:", "Calculadora Binária", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhas, null);
        int resultado = 0;

        switch (n) {
            case 0: {
                resultado = valor1 + valor2;
                break;
            }
            case 1: {
                resultado = valor1 - valor2;
                break;
            }
        }

        String binario1 = converterValorInt(valor1);
        String binario2 = converterValorInt(valor2);
        String resultadobinario = converterValorInt(resultado);

        JOptionPane.showMessageDialog(null, "Valor1: " + binario1 + "\nValor2: " + binario2 + "\n\nResultado: " + resultadobinario);
    }

    public static int getValor() {
        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número decimal (entre -128 e +128):", "Calculadora Binária", JOptionPane.PLAIN_MESSAGE));
        return valor;
    }

    public static String converterValorInt(int valor) {
        String binario = Integer.toString(abs(valor), 2);

        while (binario.length() < 7) {
            binario = "0" + binario;
        }

        if (valor < 0) {
            binario = "0" + binario;
        } else {
            binario = "1" + binario;
        }

        return binario;
    }

    public static void reiniciar() {
        String[] args = new String[1];
        String[] escolhas = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null, "Você quer reiniciar o programa?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhas, null);

        if (n == 0) {
            main(args);
        }

        System.exit(0);
    }

}
