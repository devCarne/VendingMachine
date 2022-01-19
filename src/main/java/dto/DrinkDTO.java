package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DrinkDTO {
    String code;
    String name;
    int price;
    int stock;
    String img;
}
