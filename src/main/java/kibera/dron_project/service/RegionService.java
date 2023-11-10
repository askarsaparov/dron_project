package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.RegionDTO;
import kibera.dron_project.mapper.RegionMapper;
import kibera.dron_project.repository.DistrictRepository;
import kibera.dron_project.repository.ObjectRepository;
import kibera.dron_project.repository.OrganizationRepository;
import kibera.dron_project.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    private final OrganizationRepository organizationRepository;
    private final DistrictRepository districtRepository;
    private final ObjectRepository objectRepository;


    public RegionDTO findById(Long id) {
        return regionRepository
                .findById(id)
                .map(RegionMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Region not found"));
    }

    public void delete(Long id) {
        organizationRepository.setNullWhichHasDeletedRegion(id);
        districtRepository.setNullWhichHasDeletedRegion(id);
        objectRepository.setNullWhichHasDeletedRegion(id);

        regionRepository.deleteById(id);
    }

    public List<RegionDTO> getAllRegion() {
        List<Region> regions = regionRepository.findAll();
        return regions
                .stream()
                .map(RegionMapper::toDTO)
                .toList();
    }

    public RegionDTO createRegion(RegionDTO regionDTO) {
        return RegionMapper.toDTO(
                regionRepository.save(RegionMapper.toEntity(regionDTO))
        );
    }

    public RegionDTO updateRegion(RegionDTO regionDTO) {
        return RegionMapper.toDTO(
                regionRepository.save(RegionMapper.toEntity(regionDTO))
        );
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            organizationRepository.setNullWhichHasDeletedRegion(id);
            districtRepository.setNullWhichHasDeletedRegion(id);
            objectRepository.setNullWhichHasDeletedRegion(id);

            regionRepository.deleteById(id);
        }
    }
}
