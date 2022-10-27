package ua.lviv.iot.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Battery {
    private Integer id;
    private String model;
    private Integer capacity;
    private String ip_address_id;
}
