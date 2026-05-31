package ec.edu.espe.inventario.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioResponseDTO {

    private List<CategoriaResumenDTO> resumen;

    private String mensajeAI;

}