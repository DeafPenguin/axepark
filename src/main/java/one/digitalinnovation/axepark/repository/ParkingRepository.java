package one.digitalinnovation.axepark.repository;

import one.digitalinnovation.axepark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {


}
