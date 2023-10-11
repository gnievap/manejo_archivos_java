package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Files {
    public int countFileLines(String name){
      File archivo; // Apunta a un archivo físico del dd
      FileReader reader; // Llave con permiso de solo lectura
      BufferedReader bufer; // Recuperar info. del archivo
      int numLineas = 0;

      try{
            archivo = new File("D:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            // Contar las líneas que contiene el archivo
            while ( ( bufer.readLine())!= null ){
                numLineas++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "
            + e.toString());
        }
        return numLineas;
    }

    public String[] fileToStringArray(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        String linea;
        String[] array = null;
        int t;
        int i = 0;
        
        try{
            // Obtenemos el tamaño del archivo
            t = countFileLines(name);
            // Con el tamaño del archivo, construimos el arreglo
            array = new String[t];
            // Crear un apuntador al archivo físico
            archivo = new File("D:\\archivos\\" + name + ".txt");
            // Abrir el archivo para lectura
            reader = new FileReader(archivo);
            // Configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            // Lectura del contenido del archivo
            while ( (linea = bufer.readLine())!= null ){
               array[i] = linea;
               i++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "
            + e.toString());
        }
        return array;
        
    }

public int[] fileToIntArray(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        String linea;
        int[] array = null;
        int t;
        int i = 0;
        
        try{
            t = countFileLines(name);
            array = new int[t];
            archivo = new File("D:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            while ( (linea = bufer.readLine())!= null ){
               array[i] = Integer.parseInt(linea);
               i++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "
            + e.toString());
        }
        return array;
    }

    public void writeKeyboardToFile(String name){
        // un apuntador a un espacio físico del dd
        FileWriter archivo;
        // La llave de acceso para escribir el archivo
        PrintWriter writer;
        // Para escribir de teclado al dd
        BufferedReader bufer = new BufferedReader(
            new InputStreamReader((System.in)));
        String entrada;
        char respuesta;

        try{
            // Apuntador al archivo que se va a crear
            archivo = new FileWriter("D:\\archivos\\" + name + ".txt");
            // Abrir el archivo en modo escritura
            writer = new PrintWriter(archivo);
            do {
                System.out.println("Escribe datos para guardar al archivo:");
                entrada = bufer.readLine();
                // Guardar lo recuperado desde teclado al archivo
                writer.println(entrada);
                System.out.println("Escribe x para salir, cualquier otra tecla para continuar");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            }while ( respuesta != 'x' );
            archivo.close();
        } catch ( Exception e ){
            System.out.println("Error al escribir el archivo " + e.toString());
        }
    }

    // Crear un archivo con información de un arreglo
    public void writeArrayToFile(String name, int[] array){
        FileWriter archivo;
        PrintWriter writer;

        try{
            archivo = new FileWriter("D:\\archivos\\" + name + ".txt");
            writer = new PrintWriter(archivo);
            // Guardar el arreglo a un archivo
            for ( int unDato : array ){
                writer.println(unDato);
            }
            archivo.close();
        } catch ( Exception e ){
            System.out.println("Error al escribir el archivo " + e.toString());
        }
    }

}
