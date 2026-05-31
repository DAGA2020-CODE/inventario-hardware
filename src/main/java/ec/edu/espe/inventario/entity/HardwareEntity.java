package ec.edu.espe.inventario.entity;

import ec.edu.espe.inventario.enums.Categoria;
import ec.edu.espe.inventario.enums.Estado;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HardwareEntity {

    private Long id;

    private String modelo;

    private Categoria categoria;

    private BigDecimal precio;

    private LocalDate fechaCompra;

    private Estado estado;
}