package kibera.dron_project.web.rest;

import kibera.dron_project.domain.Object;
import kibera.dron_project.dto.ObjDroneSensorDTO;
import kibera.dron_project.service.ObjectDroneSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ObjectDroneSensorResource {
    private final ObjectDroneSensorService objectDroneSensorService;

    @GetMapping("/object-drone-sensor/search")
    public List<ObjDroneSensorDTO> search(@RequestParam(required = true) String keyword,
                                          @RequestParam(required = false) Boolean name, @RequestParam(required = false) Boolean code,
                                          @RequestParam(required = false) Boolean object, @RequestParam(required = false) Boolean drone,
                                          @RequestParam(required = false) Boolean sensor) {

        return objectDroneSensorService.search(keyword, name, code, object, drone, sensor);

    }
}
