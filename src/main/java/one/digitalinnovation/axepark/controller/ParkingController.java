package one.digitalinnovation.axepark.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.axepark.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.axepark.controller.dto.ParkingDTO;
import one.digitalinnovation.axepark.controller.mapper.ParkingMapper;
import one.digitalinnovation.axepark.model.Parking;
import one.digitalinnovation.axepark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking Controller")
public class ParkingController {


    @Autowired
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @Operation(summary = "Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a parking by Id")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a parking by Id")
    public ResponseEntity delete(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Operation(summary = "Create a entry for a car parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a entry for a car parking")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto){
        Parking parkingUpdate = parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.update(id, parkingUpdate);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping("/{id}")
    @Operation(summary = "Exit a car parking, then issue the amount to be paid")
    public ResponseEntity<ParkingDTO> exit(@PathVariable String id){
        Parking parking = parkingService.exit(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }
}
