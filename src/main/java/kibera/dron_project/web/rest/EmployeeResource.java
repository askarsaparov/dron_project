package kibera.dron_project.web.rest;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.service.EmployeeService;
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
    public ResponseEntity<?> create(@RequestBody EmployeeDTO employeeDTO) {
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
    public ResponseEntity<?> update(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(
                employeeService.updateEmployee(employeeDTO)
        );
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }

//    @GetMapping("/employee/{name}")
//    public ResponseEntity<?> getAll(@PathVariable String name) {
//        List<Employee> employeeList =  employeeService.findByName(name);
//        return ResponseEntity.ok(employeeList);
//    }

//    @GetMapping("/employee/search")
//    public ResponseEntity<?> getAllSearch(@RequestParam String name) {
//        List<Employee> employeeList =  employeeService.findAllByParam(name);
//        return ResponseEntity.ok(employeeList);
//    }
}
