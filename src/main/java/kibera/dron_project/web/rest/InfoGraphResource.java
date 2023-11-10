package kibera.dron_project.web.rest;

import kibera.dron_project.dto.InfoGraphDTO;
import kibera.dron_project.service.InfoGraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class InfoGraphResource {
    private final InfoGraphService infoGraphService;

    @GetMapping("/info-graph")
    public ResponseEntity<InfoGraphDTO> getInfoGraph() {
        return ResponseEntity.ok(infoGraphService.getInfo());
    }
}
