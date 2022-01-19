package service;

import com.oreilly.servlet.MultipartRequest;
import dao.DrinkDAO;
import dto.DrinkDTO;

import java.util.ArrayList;

public class DrinkService {

    DrinkDAO dao = new DrinkDAO();

    public boolean insert(MultipartRequest multi) {
        DrinkDTO drink = new DrinkDTO(
                multi.getParameter("code"),
                multi.getParameter("name"),
                Integer.parseInt(multi.getParameter("price")),
                Integer.parseInt(multi.getParameter("stock")),
                "images/" + multi.getFilesystemName("img")
        );
        return dao.insert(drink);
    }

    public ArrayList<DrinkDTO> getList() {
        return dao.getList();
    }

    public DrinkDTO getDrink(String code) {
        return dao.getDrink(code);
    }

    public boolean update(MultipartRequest multi) {
        String fileName = multi.getFilesystemName("newImg");
        if (fileName == null) {
            fileName = multi.getParameter("originImg").replace("images/", "");
        }

        DrinkDTO drink = new DrinkDTO(
                        multi.getParameter("code"),
                        multi.getParameter("name"),
                        Integer.parseInt(multi.getParameter("price")),
                        Integer.parseInt(multi.getParameter("stock")),
                        "images/" + fileName
        );
        return dao.update(drink);
    }

    public boolean delete(String code) {
        return dao.delete(code);
    }
}
