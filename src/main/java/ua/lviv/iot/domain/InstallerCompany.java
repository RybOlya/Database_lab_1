package ua.lviv.iot.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstallerCompany {
    private Integer id;
    private String name;
    private Integer contact_info_id;
    private Integer area_coverage;
}
