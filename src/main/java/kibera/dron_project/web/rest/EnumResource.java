package kibera.dron_project.web.rest;

import kibera.dron_project.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class EnumResource {
    @GetMapping("/enum/condition")
    public ResponseEntity<Condition[]> getConditionList() {
        return ResponseEntity.ok(Condition.values());
    }

    @GetMapping("/enum/level")
    public ResponseEntity<Level[]> getLevelList() {
        return ResponseEntity.ok(Level.values());
    }

    @GetMapping("/enum/status")
    public ResponseEntity<Status[]> getStatusList() {
        return ResponseEntity.ok(Status.values());
    }

    @GetMapping("/enum/type-host")
    public ResponseEntity<TypeHost[]> getTypeHostList() {
        return ResponseEntity.ok(TypeHost.values());
    }

    @GetMapping("/enum/type-filter-dashboard")
    public ResponseEntity<Type[]> getTypeList() {
        return ResponseEntity.ok(Type.values());
    }
}
