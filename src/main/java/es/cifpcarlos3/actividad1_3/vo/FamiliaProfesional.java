package es.cifpcarlos3.actividad1_3.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FamiliaProfesional {
    private String nombre;
    private String codigo;

    @Override
    public String toString() {
        return "FamiliaProfesional: " + nombre + "( " + codigo + " )";
    }
}
