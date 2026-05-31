package ec.edu.espe.inventario.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String generarResumen(int totalEquipos) {

        return "Se analizaron "
                + totalEquipos
                + " equipos del inventario institucional.";
    }
}