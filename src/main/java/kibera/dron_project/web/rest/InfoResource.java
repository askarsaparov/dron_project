package kibera.dron_project.web.rest;

import kibera.dron_project.dto.InfoDTO;
import kibera.dron_project.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class InfoResource {

    private final InfoService infoService;

    @GetMapping("/info")
    public ResponseEntity<InfoDTO> getInfo() {
        return ResponseEntity.ok(infoService.getInfo());
    }

}
