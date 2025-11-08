package es.cifpcarlos3.actividad1_3;
import es.cifpcarlos3.actividad1_3.vo.FamiliaProfesional;
import es.cifpcarlos3.actividad1_3.vo.Ciclo;
import java.io.*;
import java.util.*;

public class GestorFormacion {

    public static void main(String[] args) {
        // Validar parámetros
        if (args.length != 1) {
            System.out.println("Uso: java GestorFormacion <codigo_familia>");
            return;
        }

        String codigoFamilia = args[0].trim().toUpperCase();

        FamiliaProfesional familia = cargarFamilia(codigoFamilia);

        if (familia == null) {
            System.out.println("!! No se ha encontrado la familia profesional con código: " + codigoFamilia);
            return;
        }

        System.out.println(familia);

        List<Ciclo> ciclos = cargarCiclosPorFamilia(codigoFamilia);

        if (ciclos.isEmpty()) {
            System.out.println("!! No hay ciclos asociados a la familia " + familia.getNombre());
        } else {
            System.out.println("Listado de ciclos:");
            ciclos.forEach(System.out::println);
        }
    }

    /**
     * Carga una familia profesional desde el fichero familia_profesional.dat
     */
    private static FamiliaProfesional cargarFamilia(String codigo) {
        File fichero = new File("src/main/java/es/cifpcarlos3/actividad1_3/familia_profesional.dat");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    String cod = partes[0].trim().toUpperCase();
                    String nombre = partes[1].trim();
                    if (cod.equals(codigo)) {
                        return new FamiliaProfesional(cod, nombre);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("!! Error al leer familia_profesional.dat: " + e.getMessage());
        }

        return null;
    }

    /**
     * Carga los ciclos pertenecientes a una familia profesional desde informacion_ciclos.txt
     */
    private static List<Ciclo> cargarCiclosPorFamilia(String codigoFamilia) {
        List<Ciclo> lista = new ArrayList<>();
        File fichero = new File("src/main/java/es/cifpcarlos3/actividad1_3/informacion_ciclos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                // Limpiar y dividir los datos
                String limpia = linea.replace("'", "").trim();
                String[] partes = limpia.split(",");

                if (partes.length == 4) {
                    String cod = partes[0].trim();
                    String nombre = partes[1].trim();
                    int horas = Integer.parseInt(partes[2].trim());
                    String codFamilia = partes[3].trim();

                    if (codFamilia.equalsIgnoreCase(codigoFamilia)) {
                        lista.add(new Ciclo(cod, nombre, horas, codFamilia));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("!! Error al leer informacion_ciclos.txt: " + e.getMessage());
        }

        return lista;
    }
}