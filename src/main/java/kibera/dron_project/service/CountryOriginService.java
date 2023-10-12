package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.CountryOrigin;
import kibera.dron_project.dto.CountryOriginDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.mapper.CountryOriginMapper;
import kibera.dron_project.mapper.PositionMapper;
import kibera.dron_project.repository.CountryOriginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryOriginService {
    private final CountryOriginRepository countryOriginRepository;

    public List<CountryOriginDTO> getAllCountryOrigin() {
        List<CountryOrigin> countryOrigins = countryOriginRepository.findAll();
        return countryOrigins
                .stream()
                .map(CountryOriginMapper::toDTO)
                .toList();
    }

    public CountryOriginDTO createCountryOrigin(CountryOriginDTO countryOriginDTO) {
        return CountryOriginMapper.toDTO(
                countryOriginRepository.save(CountryOriginMapper.toEntity(countryOriginDTO))
        );
    }

    public CountryOriginDTO findById(Long id) {
        return countryOriginRepository
                .findById(id)
                .map(CountryOriginMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("CountryOrigin not found"));
    }

    public CountryOriginDTO updateCountryOrigin(CountryOriginDTO countryOriginDTO) {
        return CountryOriginMapper.toDTO(
                countryOriginRepository.save(CountryOriginMapper.toEntity(countryOriginDTO))
        );
    }

    public void delete(Long id) {
        countryOriginRepository.deleteById(id);
    }
}
