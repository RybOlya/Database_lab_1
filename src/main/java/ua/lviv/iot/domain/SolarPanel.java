package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolarPanel {
    private Integer id;
    private String model;
    private String type;
    private Integer currentAngle;
    private Integer ip_address_id;
}

