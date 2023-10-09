package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.District;
import kibera.dron_project.dto.DistrictDTO;
import kibera.dron_project.dto.DistrictSaveDTO;
import kibera.dron_project.mapper.DistrictMapper;
import kibera.dron_project.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictDTO findById(Long id) {
        return districtRepository
                .findById(id)
                .map(DistrictMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("District not found"));
    }

    public void delete(Long id) {
        districtRepository.deleteById(id);
    }

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

    public DistrictSaveDTO updateDistrict(DistrictSaveDTO districtSaveDTO) {
        return DistrictMapper.toSaveResponse(
                districtRepository.save(DistrictMapper.toEntity(districtSaveDTO))
        );
    }
}
