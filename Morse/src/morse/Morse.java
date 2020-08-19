package morse;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Morse {

    public void converte(int[] vetor, int nrSimbolos, PrintWriter out) {
        switch (nrSimbolos) {
            case 1: {
                if (vetor[0] == 46) {
                    System.out.println("00100");//. (E)
                    out.printf("00100\n");
                } else if (vetor[0] == 45) {
                    System.out.println("10100");//- (T)
                    out.printf("10100\n");
                } else if (vetor[0] == 32) {
                    System.out.println("Espaço em Branco.");
                }
                break;
            }
            case 2: {
                if (vetor[0] == 46 && vetor[1] == 46) {
                    System.out.println("01000");
                    out.printf("01000\n");
                }//.. (I)
                else if (vetor[0] == 46 && vetor[1] == 45) {
                    System.out.println("00000");
                    out.printf("00000\n");
                }//.- (A)
                else if (vetor[0] == 45 && vetor[1] == 45) {
                    System.out.println("01100");
                    out.printf("01100\n");
                }//-- (M)
                else if (vetor[0] == 45 && vetor[1] == 46) {
                    System.out.println("01101");
                    out.printf("01101\n");
                }//-. (N)
                break;
            }
            case 3: {
                if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 46) {
                    System.out.println("00011");
                    out.printf("00011\n");
                }//-.. (D)
                else if (vetor[0] == 45 && vetor[1] == 45 && vetor[2] == 46) {
                    System.out.println("00110");
                    out.printf("00110\n");
                }//--. (G)
                else if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 45) {
                    System.out.println("01010");
                    out.printf("01010\n");
                }//-.- (K)
                else if (vetor[0] == 45 && vetor[1] == 45 && vetor[2] == 45) {
                    System.out.println("01111");
                    out.printf("01111\n");
                }//--- (O)
                else if (vetor[0] == 46 && vetor[1] == 45 && vetor[2] == 46) {
                    System.out.println("10010");
                    out.printf("10010\n");
                }//.-. (R)
                else if (vetor[0] == 46 && vetor[1] == 46 && vetor[2] == 46) {
                    System.out.println("10011");
                    out.printf("10011\n");
                }//... (S)
                else if (vetor[0] == 46 && vetor[1] == 46 && vetor[2] == 45) {
                    System.out.println("10101");
                    out.printf("10101\n");
                }//..- (U)
                else if (vetor[0] == 46 && vetor[1] == 45 && vetor[2] == 45) {
                    System.out.println("10111");
                    out.printf("10111\n");
                }//.-- (W)
                break;
            }
            case 4: {
                if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 46 && vetor[3] == 46) {
                    System.out.println("00001");
                    out.printf("00001\n");
                }//-... (B)
                else if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 45 && vetor[3] == 46) {
                    System.out.println("00010");
                    out.printf("00010\n");
                }//-.-. (C)
                else if (vetor[0] == 46 && vetor[1] == 46 && vetor[2] == 45 && vetor[3] == 46) {
                    System.out.println("00101");
                    out.printf("00101\n");
                }//..-. (F)
                else if (vetor[0] == 46 && vetor[1] == 46 && vetor[2] == 46 && vetor[3] == 46) {
                    System.out.println("00111");
                    out.printf("00111\n");
                }//.... (H)
                else if (vetor[0] == 46 && vetor[1] == 45 && vetor[2] == 45 && vetor[3] == 45) {
                    System.out.println("01001");
                    out.printf("01001\n");
                }//.--- (J)
                else if (vetor[0] == 46 && vetor[1] == 45 && vetor[2] == 46 && vetor[3] == 46) {
                    System.out.println("01011");
                    out.printf("01011\n");
                }//.-.. (L)
                else if (vetor[0] == 46 && vetor[1] == 45 && vetor[2] == 45 && vetor[3] == 46) {
                    System.out.println("10000");
                    out.printf("10000\n");
                }//.--. (P)
                else if (vetor[0] == 45 && vetor[1] == 45 && vetor[2] == 46 && vetor[3] == 45) {
                    System.out.println("10001");
                    out.printf("10001\n");
                }//--.- (Q)
                else if (vetor[0] == 46 && vetor[1] == 46 && vetor[2] == 46 && vetor[3] == 45) {
                    System.out.println("10110");
                    out.printf("10110\n");
                }//...- (V)
                else if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 46 && vetor[3] == 45) {
                    System.out.println("11000");
                    out.printf("11000\n");
                }//-..- (X)
                else if (vetor[0] == 45 && vetor[1] == 46 && vetor[2] == 45 && vetor[3] == 45) {
                    System.out.println("11001");
                    out.printf("11001\n");
                }//-.-- (Y)
                else if (vetor[0] == 45 && vetor[1] == 45 && vetor[2] == 46 && vetor[3] == 46) {
                    System.out.println("11010");
                    out.printf("11010\n");
                }//--.. (Z)           
                break;
            }
        }
    }

    public static void main(String[] args) {

        String nomeArquivo = "entrada.txt";
        //"Tenta" abrir o arquivo
        //Morse é a classe que está sendo instanciada
        //morse é o objeto em memória
        Morse morse = new Morse();
        int[] valor = new int[4];
        int indice = 0;
        //morse.imprime();
        try {
            FileReader leitor = new FileReader(new File(nomeArquivo));
            FileWriter escritor = new FileWriter(nomeArquivo + ".out");
            PrintWriter gravador = new PrintWriter(escritor);
            //enquanto o leitor estiver com conteúdo válido no arquivo
            while (leitor.ready()) {
                int data = leitor.read();
                if (data == 32) {//espaço em branco
                    morse.converte(valor, indice, gravador);
                    indice = 0;
                } else {
                    valor[indice] = data;
                    indice++;
                }
            }

            escritor.close();
            leitor.close();
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
    }
}
