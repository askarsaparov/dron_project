package kibera.dron_project.service;

import kibera.dron_project.dto.TrackerDataDTO;
import kibera.dron_project.mapper.DroneMapper;
import kibera.dron_project.mapper.TrackerDataMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.TrackerDataRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrackerDataService {

    private final TrackerDataRepository trackerDataRepository;
    private final DroneRepository droneRepository;

    public List<TrackerDataDTO> getAllData() {

        return trackerDataRepository
                .getAllData()
                .stream()
                .map((tr) -> TrackerDataMapper.toDTO(
                                tr,
                                DroneMapper.toAttributesDTO(
                                        droneRepository.getDroneByDroneId(tr.getDrone_id())
                                )
                        )
                )
                .toList();

//        DroneAttributusDTO droneAttributusDTO = droneRepository.findById()
//
//        return trackerDataRepository
//                .getAllData()
//                .stream()
//                .map(TrackerDataMapper::toDTO)
//                .toList();
    }

}
