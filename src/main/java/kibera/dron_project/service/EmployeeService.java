package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.dto.EmployeeSaveDTO;
import kibera.dron_project.mapper.EmployeeMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DroneRepository droneRepository;

    public EmployeeDTO findById(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public void delete(Long id) {

        droneRepository.setNullWhichHasDeletedEmployee(id);

        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public EmployeeSaveDTO createEmployee(EmployeeSaveDTO employeeDTO) {
        employeeRepository.save(EmployeeMapper.toEntity(employeeDTO));
        return employeeDTO;
    }

    public EmployeeDTO updateEmployee(EmployeeSaveDTO employeeDTO) {
        return EmployeeMapper.toDTO(
                employeeRepository.save(EmployeeMapper.toEntity(employeeDTO))
        );
    }


}
