package ec.edu.espe.inventario.service;

import ec.edu.espe.inventario.dto.CategoriaResumenDTO;
import ec.edu.espe.inventario.dto.InventarioResponseDTO;
import ec.edu.espe.inventario.entity.HardwareEntity;
import ec.edu.espe.inventario.enums.Categoria;
import ec.edu.espe.inventario.enums.Estado;
import ec.edu.espe.inventario.util.DataGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HardwareService {

    private final AiService aiService;

    /**
     * SOLUCIÓN IMPERATIVA
     */
    public InventarioResponseDTO procesarImperativo() {

        List<HardwareEntity> datos = DataGenerator.generarDatos();

        LocalDate fechaLimite = LocalDate.now().minusYears(5);

        List<HardwareEntity> filtrados = new ArrayList<>();

        // Filtrado usando for e if
        for (HardwareEntity equipo : datos) {

            if (equipo.getEstado() == Estado.ACTIVO
                    && equipo.getFechaCompra().isAfter(fechaLimite)) {

                filtrados.add(equipo);
            }
        }

        List<CategoriaResumenDTO> respuesta = new ArrayList<>();

        // Agrupación manual
        for (Categoria categoria : Categoria.values()) {

            long cantidad = 0;

            BigDecimal total = BigDecimal.ZERO;

            HardwareEntity masCaro = null;

            for (HardwareEntity equipo : filtrados) {

                if (equipo.getCategoria() == categoria) {

                    cantidad++;

                    total = total.add(equipo.getPrecio());

                    if (masCaro == null
                            || equipo.getPrecio().compareTo(masCaro.getPrecio()) > 0) {

                        masCaro = equipo;
                    }
                }
            }

            if (cantidad > 0) {

                double promedio = total.doubleValue() / cantidad;

                respuesta.add(
                        CategoriaResumenDTO.builder()
                                .categoria(categoria.name())
                                .cantidad(cantidad)
                                .total(total)
                                .promedio(promedio)
                                .equipoMasCaro(masCaro.getModelo())
                                .precioMasCaro(masCaro.getPrecio())
                                .build()
                );
            }
        }

        return InventarioResponseDTO.builder()
                .resumen(respuesta)
                .mensajeAI(aiService.generarResumen(filtrados.size()))
                .build();
    }

    /**
     * SOLUCIÓN FUNCIONAL / STREAMS
     */
    public InventarioResponseDTO procesarStreams() {

        List<HardwareEntity> datos = DataGenerator.generarDatos();

        LocalDate fechaLimite = LocalDate.now().minusYears(5);

        Map<Categoria, List<HardwareEntity>> agrupados =
                datos.stream()
                        .filter(e ->
                                e.getEstado() == Estado.ACTIVO
                                        && e.getFechaCompra().isAfter(fechaLimite))
                        .collect(Collectors.groupingBy(
                                HardwareEntity::getCategoria));

        List<CategoriaResumenDTO> respuesta = new ArrayList<>();

        for (Map.Entry<Categoria, List<HardwareEntity>> entry : agrupados.entrySet()) {

            Categoria categoria = entry.getKey();

            List<HardwareEntity> equipos = entry.getValue();

            DoubleSummaryStatistics estadisticas =
                    equipos.stream()
                            .collect(Collectors.summarizingDouble(
                                    e -> e.getPrecio().doubleValue()));

            Optional<HardwareEntity> masCaro =
                    equipos.stream()
                            .max(Comparator.comparing(
                                    HardwareEntity::getPrecio));

            respuesta.add(
                    CategoriaResumenDTO.builder()
                            .categoria(categoria.name())
                            .cantidad((long) equipos.size())
                            .total(BigDecimal.valueOf(
                                    estadisticas.getSum()))
                            .promedio(
                                    estadisticas.getAverage())
                            .equipoMasCaro(
                                    masCaro.map(
                                                    HardwareEntity::getModelo)
                                            .orElse("N/A"))
                            .precioMasCaro(
                                    masCaro.map(
                                                    HardwareEntity::getPrecio)
                                            .orElse(BigDecimal.ZERO))
                            .build()
            );
        }

        long totalProcesados =
                agrupados.values()
                        .stream()
                        .mapToLong(List::size)
                        .sum();

        return InventarioResponseDTO.builder()
                .resumen(respuesta)
                .mensajeAI(
                        aiService.generarResumen(
                                (int) totalProcesados))
                .build();
    }
}