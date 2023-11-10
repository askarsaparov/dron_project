package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Category;
import kibera.dron_project.domain.Object;
import kibera.dron_project.domain.Position;
import kibera.dron_project.dto.CategoryDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.mapper.CategoryMapper;
import kibera.dron_project.mapper.PositionMapper;
import kibera.dron_project.repository.BrandRepository;
import kibera.dron_project.repository.CategoryRepository;
import kibera.dron_project.repository.ObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ObjectRepository objectRepository;

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return CategoryMapper.toDTO(
                categoryRepository.save(CategoryMapper.toEntity(categoryDTO))
        );
    }

    public CategoryDTO findById(Long id) {
        return categoryRepository
                .findById(id)
                .map(CategoryMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return CategoryMapper.toDTO(
                categoryRepository.save(CategoryMapper.toEntity(categoryDTO))
        );
    }

    public void delete(Long id) {
        objectRepository.setNullWhichHasDeletedCategory(id);

        categoryRepository.deleteById(id);
    }

    public List<Category> filterCategory(Boolean onDashboard) {
        return categoryRepository.filterCategory(onDashboard);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            categoryRepository.deleteById(id);
        }
    }
}
