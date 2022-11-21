package one.digitalinnovation.axepark.service;

import one.digitalinnovation.axepark.exception.ParkingNotFoundException;
import one.digitalinnovation.axepark.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();
    static {
        var id = getUUID();
        var id2 = getUUID();
        Parking parking = new Parking(id, "OMO-1H52", "GO", "Ford/Fiesta 1.6 Flex", "Cinza");
        Parking parking2 = new Parking(id2, "NVS-4080", "GO", "Chevrolet/Celta 1.0", "Cinza");
        parkingMap.put(id, parking);
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
//        parking.setLicense(parkingCreate.getLicense());
//        parking.setState(parkingCreate.getState());
//        parking.setModel(parkingCreate.getModel());
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }

    public Parking exit(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        // TODO Calcular o valor do estacionamento
        parkingMap.put(id, parking);
        return parking;
    }
}
