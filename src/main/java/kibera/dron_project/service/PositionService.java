package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Position;
import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.dto.RegionDTO;
import kibera.dron_project.mapper.PositionMapper;
import kibera.dron_project.mapper.RegionMapper;
import kibera.dron_project.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public List<PostionDTO> getAllPosition() {
        List<Position> positions = positionRepository.findAll();
        return positions
                .stream()
                .map(PositionMapper::toDTO)
                .toList();
    }

    public PostionDTO createPosition(PostionDTO postionDTO) {
        return PositionMapper.toDTO(
                positionRepository.save(PositionMapper.toEntity(postionDTO))
        );
    }

    public PostionDTO findById(Long id) {
        return positionRepository
                .findById(id)
                .map(PositionMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
    }

    public PostionDTO updatePosition(PostionDTO postionDTO) {
        return PositionMapper.toDTO(
                positionRepository.save(PositionMapper.toEntity(postionDTO))
        );
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
