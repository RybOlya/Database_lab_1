package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.IpAddress;

@Repository
public interface IpAddressRepository extends JpaRepository<IpAddress, Integer> {
}