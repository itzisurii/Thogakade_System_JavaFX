package model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemManagementDTO {
    private String code;
    private String description;
    private String category;
    private int qtyOnHand;
    private double unitPrice;
}
