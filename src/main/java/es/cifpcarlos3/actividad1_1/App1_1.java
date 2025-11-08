package es.cifpcarlos3.actividad1_1;


import java.io.*;

public class App1_1 {
    public static void main(String[] args) throws IOException {
        File ciclos = new File("src/main/java/es/cifpcarlos3/actividad1_1/informacion_ciclos.txt"); // cambiar path al gusto
        FileReader fr = new FileReader(ciclos);
        BufferedReader br = new BufferedReader(fr);

        String linea;

        while ((linea = br.readLine()) != null) {
            if (!linea.startsWith("#") && !linea.trim().isEmpty() && linea.startsWith("'IFC0")){
                System.out.println("INSERT INTO T_CICLO VALUES (" + linea + ")");
            }
        }
    }
}
