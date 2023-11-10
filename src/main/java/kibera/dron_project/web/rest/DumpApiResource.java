package kibera.dron_project.web.rest;

import kibera.dron_project.service.DumpApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DumpApiResource {

    private final DumpApiService dumpApiService;

    @PostMapping(value = "/dump", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> create(@RequestBody MultipartFile file) {
        dumpApiService.dumpCsvData(file);
        return ResponseEntity.ok("Saved");
    }

}
