package es.cifpcarlos3.actividad1_2;


import java.io.*;

public class GestorFicheroFrases {
    public static void main(String[] args) throws IOException {
        File frases = new File("src/main/java/es/cifpcarlos3/actividad1_2/frases.txt"); // cambiar path al gusto
        File procesados = new File("src/main/java/es/cifpcarlos3/actividad1_2/procesados");

        if (!procesados.exists()) {
            procesados.mkdirs();
        }

        File frases_filtradas = new File("src/main/java/es/cifpcarlos3/actividad1_2/procesados/frases_filtradas.txt");

        try (
                FileReader fr = new FileReader(frases);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(frases_filtradas);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("2") || linea.endsWith("Monroe") || linea.endsWith("Davis")) {
                    bw.write(linea);
                    bw.newLine(); // salto de línea
                }
            }
        }

        frases.delete();
    }
}
