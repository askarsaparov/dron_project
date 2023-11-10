package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Brand;
import kibera.dron_project.dto.BrandDTO;
import kibera.dron_project.mapper.BrandMapper;
import kibera.dron_project.repository.BrandRepository;
import kibera.dron_project.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final DroneRepository droneRepository;

    public List<BrandDTO> getAllBrand() {
        List<Brand> brands = brandRepository.findAll();
        return brands
                .stream()
                .map(BrandMapper::toDTO)
                .toList();
    }

    public BrandDTO createBrand(BrandDTO brandDTO) {
        return BrandMapper.toDTO(
                brandRepository.save(BrandMapper.toEntity(brandDTO))
        );
    }

    public BrandDTO findById(Long id) {
        return brandRepository
                .findById(id)
                .map(BrandMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }

    public BrandDTO updateBrand(BrandDTO brandDTO) {
        return BrandMapper.toDTO(
                brandRepository.save(BrandMapper.toEntity(brandDTO))
        );
    }

    public void delete(Long id) {
        droneRepository.setNullWhichHasDeletedBrand(id);

        brandRepository.deleteById(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            droneRepository.setNullWhichHasDeletedBrand(id);
            brandRepository.deleteById(id);
        }
    }
}
