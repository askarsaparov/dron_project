package kibera.dron_project.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsDTO<T> {

    private T errors;

}