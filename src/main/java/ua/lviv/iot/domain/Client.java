/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.domain
 * Class: Client
 **/

package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private Integer id;
    private String surname;
    private String name;
    private String password;
    private Boolean is_a_company;
}
