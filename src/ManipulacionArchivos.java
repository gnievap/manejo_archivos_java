import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManipulacionArchivos {

    public static int contarLineasArchivo(String name){
      File archivo; // Apunta a un archivo físico del dd
      FileReader reader; // Llave con permiso de solo lectura
      BufferedReader bufer; // Recuperar info. del archivo
      String linea;  
      int numLineas = 0;

      try{
            archivo = new File("D:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            // Contar las líneas que contiene el archivo
            while ( (linea = bufer.readLine())!= null ){
                numLineas++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "
            + e.toString());
        }
        return numLineas;

    }

    public static void leerArchivo(String name){
        File archivo; // Apunta a un archivo físico del dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        String linea;
        
        try{
            // Crear un apuntador al archivo físico
            archivo = new File("D:\\archivos\\" + name + ".txt");
            // Abrir el archivo para lectura
            reader = new FileReader(archivo);
            // Configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            // Lectura del contenido del archivo
            while ( (linea = bufer.readLine())!= null ){
                System.out.println("Línea leída: " + linea);
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "
            + e.toString());
        }
        
    }


    public static void main(String[] args) throws IOException  {
        BufferedReader bufer = new BufferedReader(
            new InputStreamReader(System.in));
        String fileName;
        int t;

        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        leerArchivo(fileName);
        t = contarLineasArchivo(fileName);
        System.out.println("Líneas en el archivo " + fileName + ": " + t);
    }
}
