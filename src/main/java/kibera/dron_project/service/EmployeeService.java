package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.mapper.EmployeeMapper;
import kibera.dron_project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeDTO findById(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        return EmployeeMapper.toDTO(
                employeeRepository.save(EmployeeMapper.toEntity(employeeDTO))
        );
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return EmployeeMapper.toDTO(
                employeeRepository.save(EmployeeMapper.toEntity(employeeDTO))
        );
    }

//    public List<Employee> findByName(String name) {
//        return employeeRepository.findByName(name);
//    }

//    public List<Employee> findAllByParam(String name) {
//        return employeeRepository.findAllByLikeNative(name);
//    }

}
