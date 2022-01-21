package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDTO {

    String code;
    int quantity;
    Timestamp order_time;
}
