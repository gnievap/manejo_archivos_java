import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import files.Files;

public class ManipulacionArchivos {

    public static void main(String[] args) throws IOException  {
        Files files = new Files();
        BufferedReader bufer = new BufferedReader(
            new InputStreamReader(System.in));
        String fileName;
        String[] mascotas;
        int[] numeros;
        int[] numerosX3;

        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        mascotas = files.fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de mascotas:");
        for ( String unaMascota : mascotas ){
            System.out.println(unaMascota);
        }

        System.out.println("Lectura de datos numéricos");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        numeros = files.fileToIntArray(fileName);
        System.out.println("Contenido del arreglo de numeros: ");
        for ( int unNumero : numeros ){
            System.out.println(unNumero);
        }
        // Crear y llenar el arreglo numerosX3
        System.out.println("Numeros Por 3");
        numerosX3 = new int[numeros.length];
        for ( int i = 0; i < numeros.length; i++ ){
            numerosX3[i] = numeros[i] * 3;
            System.out.println("numerosX3[" + i + "]: " + numerosX3[i]);
        }
        System.out.println("Escribe el nombre del archivo de numerosX3: ");
        fileName = bufer.readLine();
        files.writeArrayToFile(fileName, numerosX3);


        // System.out.println("Crear un archivo de texto");
        // System.out.println("Escribe el nombre del archivo: ");
        // fileName = bufer.readLine();
        // writeFile(fileName);
    }
}
