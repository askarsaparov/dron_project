package kibera.dron_project.mapper;


import kibera.dron_project.domain.Category;
import kibera.dron_project.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category entity) {
        return CategoryDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto) {
        return new Category()
                .id(dto.getId())
                .name(dto.getName());
    }
}
