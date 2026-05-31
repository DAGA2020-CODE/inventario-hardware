package ec.edu.espe.inventario.controller;

import ec.edu.espe.inventario.dto.InventarioResponseDTO;
import ec.edu.espe.inventario.service.HardwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hardware")
@RequiredArgsConstructor
public class HardwareController {

    private final HardwareService service;

    @GetMapping("/imperativo")
    public InventarioResponseDTO imperativo() {
        return service.procesarImperativo();
    }

    @GetMapping("/streams")
    public InventarioResponseDTO streams() {
        return service.procesarStreams();
    }
}