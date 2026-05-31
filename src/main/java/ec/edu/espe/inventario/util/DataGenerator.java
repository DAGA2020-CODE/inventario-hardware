package ec.edu.espe.inventario.util;

import ec.edu.espe.inventario.entity.HardwareEntity;
import ec.edu.espe.inventario.enums.Categoria;
import ec.edu.espe.inventario.enums.Estado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static final List<HardwareEntity> DATOS = generarInventario();

    public static List<HardwareEntity> generarDatos() {
        return DATOS;
    }

    private static List<HardwareEntity> generarInventario() {

        List<HardwareEntity> lista = new ArrayList<>();

        Random random = new Random();

        for (long i = 1; i <= 10000; i++) {

            lista.add(
                    HardwareEntity.builder()
                            .id(i)
                            .modelo("Modelo-" + i)
                            .categoria(Categoria.values()[random.nextInt(3)])
                            .precio(BigDecimal.valueOf(500 + random.nextInt(9500)))
                            .fechaCompra(LocalDate.now().minusYears(random.nextInt(10)))
                            .estado(random.nextBoolean()
                                    ? Estado.ACTIVO
                                    : Estado.DEBAJA)
                            .build()
            );
        }

        return lista;
    }
}