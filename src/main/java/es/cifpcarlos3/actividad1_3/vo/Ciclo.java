package es.cifpcarlos3.actividad1_3.vo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ciclo {
    private String codigo;
    private String nombre;
    private int horas;
    private String codigoFamilia;

    @Override
    public String toString() {
        return "'" + codigo + "', '" + nombre + "', " + horas + ", '" + codigoFamilia + "'";
    }
}