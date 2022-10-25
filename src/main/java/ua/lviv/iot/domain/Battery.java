/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: Battery
 **/

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
    private String IPaddress;
}
