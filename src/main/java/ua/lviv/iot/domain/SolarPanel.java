/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: SolarPanel
 **/

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
    private String IPaddress;
}

