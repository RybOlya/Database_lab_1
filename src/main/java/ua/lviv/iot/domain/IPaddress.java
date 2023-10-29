package ua.lviv.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ip_address")
public class IpAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ip_address", nullable = false, length = 15)
    private String ipAddress;
    @OneToMany(mappedBy="ipAddress")
    private List<SolarPanel> solarPanels;
    public List<SolarPanel> getSolarPanels() {
        return solarPanels;
    }
    public void setSolarPanels(List<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }
    @OneToMany(mappedBy="ipAddress")
    private List<SolarBattery> solarBatteries;
    public List<SolarBattery> getSolarBatteries() {
        return solarBatteries;
    }
    public void setSolarBatteries(List<SolarBattery> solarBatteries) {
        this.solarBatteries = solarBatteries;
    }
}