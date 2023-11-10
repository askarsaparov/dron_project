package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.domain.Object;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.dto.EmployeeSaveDTO;
import kibera.dron_project.dto.ObjectDTO;
import kibera.dron_project.dto.ObjectSaveDTO;
import kibera.dron_project.mapper.EmployeeMapper;
import kibera.dron_project.mapper.ObjectMapper;
import kibera.dron_project.repository.ObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ObjectService {
    private final ObjectRepository objectRepository;

    public List<ObjectDTO> getAllObject() {
        List<Object> object = objectRepository.findAll();
        return object
                .stream()
                .map(ObjectMapper::toDTO)
                .toList();
    }

    public ObjectSaveDTO createObject(ObjectSaveDTO objectSaveDTO) {
        objectRepository.save(ObjectMapper.toEntity(objectSaveDTO));
        return objectSaveDTO;
    }

    public ObjectDTO findById(Long id) {
        return objectRepository
                .findById(id)
                .map(ObjectMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Object not found"));
    }

    public ObjectSaveDTO updateObject(ObjectSaveDTO objectDTO) {
        objectRepository.save(ObjectMapper.toEntity(objectDTO));
        return objectDTO;
    }

    public void delete(Long id) {
        objectRepository.deleteById(id);
    }

    public List<Object> searchObject(String keyword, Long category) {
        return (category != null) ?
                objectRepository.searchObject(keyword, category):
                objectRepository.searchObject(keyword);
    }

    public List<Object> filterObject(Long id) {
        return objectRepository.filterObject(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            objectRepository.deleteById(id);
        }
    }
}
