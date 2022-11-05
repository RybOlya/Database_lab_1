package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.SolarSystem;

import java.util.List;
@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem, Integer> {
    List<SolarSystem> findByEnergySold(Integer energySold);
}