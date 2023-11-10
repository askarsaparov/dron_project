package kibera.dron_project.handler;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.dto.ErrorsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandle(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorsDTO<Map<String, List<String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {
        Map<String, List<String>> errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                                FieldError::getField,
                                Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                        )
                );

        ex.getAllErrors().forEach(
                e -> {
                    if (e.getCode() != null) {
                        if (e.getCode().endsWith("Region")) {
                            errors.put("regionId", Collections.singletonList(e.getDefaultMessage()));
                        }
                    }
                }
        );

        return new ErrorsDTO<>(errors);
    }

}
