package org.example;

import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Bingo(){
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        int bolas = random.nextInt(31) + 10; // Numero de bolas aleatorio (10 - 40)
        int[] numerosSalidos = new int[bolas]; // Array de numeros salidos
        int [][] Carton = new int[3][3]; // Tamaño del carton (3x3)
        Boolean[][] CartonVerificar = new Boolean[3][3];
        int bolaAleatoria = 0;
        int bolaBuena = 0;
        String fila1,fila2,fila3;
        String[] fila = new String[3];
        Boolean bingo = true,linea1=true,linea2=true,linea3=true;


        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTABRICO ***");

        for (int i = 0; i < bolas; i++){
            bolaAleatoria = random.nextInt(91);
            bolaBuena = bolaAleatoria;
            for (int j = 0;j<numerosSalidos.length;j++){
                if (bolaAleatoria == numerosSalidos[j]){
                    bolaBuena=0;
                }
            }
            if (bolaBuena == 0){
                i--;
            }
            else{
                numerosSalidos[i] = bolaBuena;
            }
        }

        System.out.print(bolas+" bolas extraidas hasta ahora: [");
        for (int bola : numerosSalidos){
            System.out.print(bola+", ");
        }
        System.out.print("]");

        System.out.println();
        System.out.println("*** Introduce los datos de tu carton ***");
        System.out.println("Fila 1:");
        fila1 = teclado.nextLine();
        try{
            fila = fila1.split("-");
            for (int k = 0;k < fila.length;k++){
                Carton[0][k] = Integer.parseInt(fila[k]);
                if (Carton[0][k] > 99 && Carton[0][k] < 1){
                    Carton[0][k] = Integer.parseInt("Error");
                }
            }
        }catch (Exception e){
            System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
        }


        System.out.println("Fila 2:");
        fila2 = teclado.nextLine();
        try{
            fila = fila2.split("-");
            for (int h = 0;h < fila.length;h++){
                Carton[1][h] = Integer.parseInt(fila[h]);
                if (Carton[1][h] > 99 && Carton[1][h] < 1){
                    Carton[1][h] = Integer.parseInt("Error");
                }
            }
        }catch (Exception e){
            System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
        }


        System.out.println("Fila 3:");
        fila3 = teclado.nextLine();
        try{
            fila = fila3.split("-");
            for (int l = 0;l < fila.length;l++){

                Carton[2][l] = Integer.parseInt(fila[l]);
                if (Carton[2][l] > 99 && Carton[2][l] < 1){
                    Carton[2][l] = Integer.parseInt("Error");
                }
            }
        }catch (Exception e){
            System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
        }

        System.out.println("Datos del carton Introducidos: ");
        for (int filas = 0; filas < 3;filas++){
            System.out.println();
            for (int columnas = 0; columnas < 3; columnas++){
                System.out.print(Carton[filas][columnas]+" ");
            }
        }
        for (int filas = 0; filas < 3;filas++){
            for (int columnas = 0; columnas < 3; columnas++){
                for (int bo : numerosSalidos) {
                    if (Carton[filas][columnas] == bo){
                        CartonVerificar[filas][columnas] = true;
                        break;
                    }else {
                        CartonVerificar[filas][columnas] = false;
                    }
                }
            }
        }

        for (int filas = 0; filas < 3;filas++){
            for (int columnas = 0; columnas < 3; columnas++){
                if (!CartonVerificar[filas][columnas])
                {
                    bingo = false;
                    if (filas ==0){
                        linea1 = false;
                    }else if (filas==1){
                        linea2 = false;
                    }else{
                        linea3 = false;
                    }
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("PREMIOS: ");
        if (bingo){
            System.out.println("HAY BINGO !!");
        }else {
            System.out.println("NO HAY  BINGO.");
            if (linea1){
                System.out.println("Linea 1: CORRECTA!!");
            }else{
                System.out.println("Linea 1: No");
            }
            if (linea2){
                System.out.println("Linea 2: CORRECTA!!");
            }else{
                System.out.println("Linea 2: No");
            }
            if (linea3){
                System.out.println("Linea 3: CORRECTA!!");
            }else{
                System.out.println("Linea 3: No");
            }
        }
    }
}
