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
    private Integer contact_info_id;
    private String password;
    private Boolean is_a_company;
}
