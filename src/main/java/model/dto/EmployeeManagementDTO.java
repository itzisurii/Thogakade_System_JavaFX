package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class EmployeeManagementDTO {
    private String id;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private double salary;
}
