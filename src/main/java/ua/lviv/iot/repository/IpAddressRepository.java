package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.IpAddress;

@Repository
public interface IpAddressRepository extends JpaRepository<IpAddress, Integer> {
    @Procedure("insert_ten_rows_into_ip_address")
    void insertTenRowsInIpAddress();
    @Procedure("insert_into_ip_address")
    String insertIntoIpAddress(Integer id, String ip_address);
}