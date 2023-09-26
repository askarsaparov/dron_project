package kibera.dron_project.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSaveDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private Long organizationId;
    private String position;
    private LocalDate birthday;
    private String placeOfBirth;
    private String passportData;

}
