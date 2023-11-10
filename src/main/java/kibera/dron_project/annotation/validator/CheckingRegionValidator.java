package kibera.dron_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kibera.dron_project.annotation.CheckingRegion;
import kibera.dron_project.dto.DistrictSaveDTO;
import kibera.dron_project.repository.RegionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckingRegionValidator implements ConstraintValidator<CheckingRegion, DistrictSaveDTO> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(DistrictSaveDTO district, ConstraintValidatorContext context) {

        Long regionId = district.getRegionId();

        return regionRepository.existsById(regionId);

    }

}