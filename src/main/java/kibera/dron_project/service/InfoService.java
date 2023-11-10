package kibera.dron_project.service;

import kibera.dron_project.dto.InfoDTO;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.ObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final DroneRepository droneRepository;
    private final ObjectRepository objectRepository;

    public InfoDTO getInfo() {

        InfoDTO response = new InfoDTO();

        response.setDrones(droneRepository.count());
        response.setObjects(objectRepository.count());
        response.setTargetDrones(droneRepository.countTargetDrones());

        return response;
    }

}
