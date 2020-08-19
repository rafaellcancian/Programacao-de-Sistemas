/*/
4 Exceções:
-> Soma não pode exceder 8 bits;
-> Subtração não pode ter numero negativo;
-> Multiplicação não pode exceder 8 bits;
-> Divisão não pode fração, e nem ser dividido por 0.
/*/

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        String matriz[][] = criarMatriz();

        String valorbinario1 = getBinario();
        String valorbinario2 = getBinario();
        int valorint1 = converterValorBinario(valorbinario1, matriz);
        int valorint2 = converterValorBinario(valorbinario2, matriz);

        if ((valorint1 == -1) && (valorint2 == -1)) {
            JOptionPane.showMessageDialog(null, "ERRO: Os valores inseridos são inválidos.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        } else if ((valorint1 == -1) || (valorint2 == -1)) {
            JOptionPane.showMessageDialog(null, "ERRO: Um dos valores inseridos é inválido.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        }

        int resultado = getResultado(valorint1, valorint2);

        String resultadobinario = converterValorInt(resultado, matriz);

        if (resultadobinario.equals("null")) {
            JOptionPane.showMessageDialog(null, "ERRO: O resultado excede a memória.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        }

        JOptionPane.showMessageDialog(null, "Resultado:\n" + "Binário: " + resultadobinario + "\nDecimal: " + resultado);
        reiniciar();
    }

    public static String[][] criarMatriz() {
        String matriz[][] = new String[256][2];

        File file = new File("Binarios.txt");
        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < 256; i++) {
                matriz[i][0] = String.valueOf(i);
                matriz[i][1] = scanner.nextLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            reiniciar();
        }

        return matriz;
    }

    public static String getBinario() {
        String valorbinario = JOptionPane.showInputDialog(null, "Digite um número binário (de no máximo 8 bits):", "Calculadora Binária", JOptionPane.PLAIN_MESSAGE);

        return valorbinario;
    }

    public static int converterValorBinario(String valorbinario, String matriz[][]) {
        for (int i = 0; i < 256; i++) {
            if (String.valueOf(valorbinario).equals(matriz[i][1])) {
                return Integer.parseInt(matriz[i][0]);
            }
        }

        return -1;
    }

    public static int getResultado(int valor1, int valor2) {
        String[] escolhas = {"00 (Soma)", "01 (Subtração)", "10 (Multiplicação)", "11 (Divisão)"};
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
            case 2: {
                resultado = valor1 * valor2;
                break;
            }
            case 3: {
                try {
                    resultado = valor1 / valor2;
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, "ERRO: Não é possível dividir por 0.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    reiniciar();
                }
                break;
            }
        }

        return resultado;
    }

    public static String converterValorInt(int resultado, String matriz[][]) {
        for (int i = 0; i < 256; i++) {
            if (String.valueOf(resultado).equals(matriz[i][0])) {
                return matriz[i][1];
            }
        }

        return "null";
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
