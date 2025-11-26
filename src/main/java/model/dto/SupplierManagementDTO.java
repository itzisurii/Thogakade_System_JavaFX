package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SupplierManagementDTO {
    private String id;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private int postalCode;
    private String phone;
    private String email;
}
