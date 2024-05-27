package view;

import model.dao.AeroportDAO;
import model.data.Aeroport;
import java.util.List;

public class BreizhDataApp {

    public static void main(String[] args) {
        
        AeroportDAO aeroportDAO = new AeroportDAO();

        List<Aeroport> aeroports = aeroportDAO.findAll();

        for (Aeroport aeroport : aeroports) {
            System.out.println(aeroport);
        }
    }
}
