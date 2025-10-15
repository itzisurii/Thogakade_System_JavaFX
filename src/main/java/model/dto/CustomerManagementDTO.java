package model.dto;
import lombok.*;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CustomerManagementDTO {
    private String id;
    private String title;
    private String name;
    private String dob;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;
}
