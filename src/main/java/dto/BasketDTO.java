package dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class BasketDTO {

    Date date;
    HashMap<String, Integer> orders;

    public BasketDTO() {
        date = new Date(System.currentTimeMillis());
        orders = new HashMap<>();
    }

    public Date getDate() {
        return date;
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
