package kibera.dron_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private OrganizationDTO organizationDTO;
    private PostionDTO positionDTO;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String placeOfBirth;
    private String passportData;

}
