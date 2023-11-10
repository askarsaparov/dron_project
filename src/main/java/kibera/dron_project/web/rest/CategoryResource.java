package kibera.dron_project.web.rest;

import jakarta.validation.Valid;
import kibera.dron_project.domain.Category;
import kibera.dron_project.domain.Object;
import kibera.dron_project.dto.CategoryDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.service.CategoryService;
import kibera.dron_project.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CategoryResource {
    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> categoryDTOS =  categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDTOS);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryDTO categoryDTO) {
        return ResponseEntity.ok(
                categoryService.createCategory(categoryDTO)
        );
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/category")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(
                categoryService.updateCategory(categoryDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @GetMapping("/category/filter")
    public List<Category> filterObject(@RequestParam(required = false) Boolean onDashboard) {
        return categoryService.filterCategory(onDashboard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/category/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        categoryService.deleteItems(ids);
    }
}
