package dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Set;

@Data
public class BasketDTO {

    Timestamp timestamp;
    HashMap<String, Integer> orders;

    public BasketDTO() {
        timestamp = new Timestamp(System.currentTimeMillis());
        orders = new HashMap<>();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public HashMap<String, Integer> getSelection() {
        return orders;
    }

    public void print() {
        Set<String> strings = orders.keySet();
        for (String s : strings){
            Integer integer = orders.get(s);
        }
    }
}
