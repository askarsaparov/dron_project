package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kibera.dron_project.enums.Type;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjDroneSensorDTO {

    public ObjDroneSensorDTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;

        if(type.equals(Type.OBJECT.name())) {
            this.type = Type.OBJECT;
        } else if(type.equals(Type.DRONE.name())) {
            this.type = Type.DRONE;
        } else if(type.equals(Type.SENSOR.name())) {
            this.type = Type.SENSOR;
        }

    }

    private Long id;
    private String name;
    private Type type;
}
