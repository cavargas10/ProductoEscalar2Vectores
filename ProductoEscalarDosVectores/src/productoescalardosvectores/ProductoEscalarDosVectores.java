package productoescalardosvectores;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cavargas10
 */
public class ProductoEscalarDosVectores {

    /**
     * @param args the command line arguments
     */
    static int v[], w[];
    static int tamaño;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("INGRESE EL TAMANO DE LOS VECTORES: ");
        tamaño = input.nextInt();

        v = new int[tamaño];
        w = new int[tamaño];

        v = aleatorios(tamaño);
        w = aleatorios(tamaño);

        long tiempo1 = 0;
        long tiempo2 = 0;
        long tiempo3 = 0;

        long startTime2 = System.nanoTime();
        escalarOptimo(tamaño);
        long endTime2 = System.nanoTime();
        tiempo2 = endTime2 - startTime2;
        System.out.println("OPTIMO: " + tiempo2 + " ns");
        
        long startTime1 = System.nanoTime();
        escalarNormal(tamaño);
        long endTime1 = System.nanoTime();
        tiempo1 = endTime1 - startTime1;
        System.out.println("NORMAL: " + tiempo1 + " ns");

        long startTime3 = System.nanoTime();
        escalarComplejo(tamaño);
        long endTime3 = System.nanoTime();
        tiempo3 = endTime3 - startTime3;
        System.out.println("COMPLEJO: " + tiempo3 + " ns");

    }

    static int[] aleatorios(int tm) {
        int desde = 1;
        int hasta = 100;
        int[] numeros = new int[tamaño];
        Random rnd = new Random();
        for (int i = 0; i < tm; i++) {
            numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;
        }
        return numeros;
    }

        static double escalarOptimo(int tam) {
        int xEscalar = 0;
        for (int i = 0; i < tam; i++) {
            xEscalar = xEscalar + (v[i] * w[i]);
        }
        return xEscalar;
    }
    
    static void escalarNormal(int tamano) {
        int temp = 0;
        int xTem[] = new int[tamano];
        for (int i = 0; i < v.length; i++) {
            xTem[i] = v[i] * w[i];
        }

        for (int i = 0; i < v.length; i++) {
            temp = temp + xTem[i];
        }
    }

    static double escalarComplejo(int tam) {
        int xEscalar = 0;
        for (int i = 0; i < tam; i += 2) {
            xEscalar = xEscalar + (v[i] * w[i]);
            xEscalar = xEscalar + (v[i + 1] * w[i + 1]);
        }
        return xEscalar;
    }
}
