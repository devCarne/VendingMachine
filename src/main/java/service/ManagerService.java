package service;

import dao.ManagerDAO;
import dto.ManagerDTO;

public class ManagerService {

    ManagerDAO dao = new ManagerDAO();

    public ManagerDTO login(String ID, String PW) {
        return dao.login(ID, PW);
    }

    public boolean signUp(String ID, String PW, String name) {
        ManagerDTO manager = new ManagerDTO(ID, PW, name);
        return dao.signUp(manager);
    }
}