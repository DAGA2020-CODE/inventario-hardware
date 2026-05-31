package ec.edu.espe.inventario.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaResumenDTO {

    private String categoria;

    private Long cantidad;

    private BigDecimal total;

    private Double promedio;

    private String equipoMasCaro;
    private BigDecimal precioMasCaro;

}