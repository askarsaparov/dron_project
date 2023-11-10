package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.District;
import kibera.dron_project.dto.DistrictDTO;
import kibera.dron_project.dto.DistrictSaveDTO;
import kibera.dron_project.mapper.DistrictMapper;
import kibera.dron_project.repository.DistrictRepository;
import kibera.dron_project.repository.ObjectRepository;
import kibera.dron_project.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final ObjectRepository objectRepository;
    private final OrganizationRepository organizationRepository;

    public List<DistrictDTO> getAllDistrict() {
        List<District> districts = districtRepository.getAll();
        return districts
                .stream()
                .map(DistrictMapper::toDTO)
                .toList();
    }

    public DistrictSaveDTO createDistrict(DistrictSaveDTO districtSaveDTO) {
        return DistrictMapper.toSaveResponse(
                districtRepository.save(DistrictMapper.toEntity(districtSaveDTO))
        );
    }

    public DistrictDTO findById(Long id) {
        return districtRepository
                .findById(id)
                .map(DistrictMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("District not found"));
    }

    public DistrictSaveDTO updateDistrict(DistrictSaveDTO districtSaveDTO) {
        return DistrictMapper.toSaveResponse(
                districtRepository.save(DistrictMapper.toEntity(districtSaveDTO))
        );
    }

    public void delete(Long id) {
        organizationRepository.setNullWhichHasDeletedDistrict(id);
        objectRepository.setNullWhichHasDeletedDistrict(id);

        districtRepository.deleteById(id);
    }


    public List<District> filterDistrict(Long id) {
        return districtRepository.filterDistrict(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            organizationRepository.setNullWhichHasDeletedDistrict(id);
            objectRepository.setNullWhichHasDeletedDistrict(id);
            districtRepository.deleteById(id);
        }
    }
}
