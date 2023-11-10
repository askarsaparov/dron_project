package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSaveDTO {

    private Long id;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String surname;
    private Long organizationId;
    private Long positionId;
    @NotNull
    private LocalDate birthday;
    @NotNull
    @NotBlank
    private String placeOfBirth;
    @NotNull
    @NotBlank
    private String passportData;
}
