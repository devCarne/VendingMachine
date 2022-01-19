package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class OrderDTO {

    String code;
    int quantity;
    Date order_time;
}
