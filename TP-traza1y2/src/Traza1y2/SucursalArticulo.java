package Traza1y2;

import TRAZA1.Sucursal;
import TRAZA2.Articulo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class SucursalArticulo {

    private Long id;
    private Sucursal sucursal;
    private Articulo articulo;
    private double precio;           // Precio en esta sucursal
    private int stock;               // Cantidad disponible
    private boolean aprobacion;      // Si está aprobado o no
    private LocalDate fechaAlta;     // Desde cuándo se vende en la sucursal


    @Override
    public String toString() {
        return "SucursalArticulo{" +
                "id=" + id +
                ", Sucursal=" + sucursal +
                ", Articulo=" + articulo +
                ", precio=" + precio +
                ", stock=" + stock +
                ", aprobacion=" + aprobacion +
                ", LocalDate=" + fechaAlta +
                '}';
    }
}