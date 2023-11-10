package kibera.dron_project.web.rest;
import jakarta.validation.Valid;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.dto.EmployeeSaveDTO;
import kibera.dron_project.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<?> getAll() {
        List<EmployeeDTO> employeeList =  employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> create(@RequestBody @Valid EmployeeSaveDTO employeeDTO) {
        return ResponseEntity.ok(
                employeeService.createEmployee(employeeDTO)
        );
    }

    @GetMapping("/employee/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<?> getById(@PathVariable Long id) {
        EmployeeDTO employee = employeeService.findById(id);

        if (employee != null) {
            return ResponseEntity.ok(employee); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/employee")
    public ResponseEntity<?> update(@RequestBody EmployeeSaveDTO employeeDTO) {
        return ResponseEntity.ok(
                employeeService.updateEmployee(employeeDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/employee/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        employeeService.deleteItems(ids);
    }

}
