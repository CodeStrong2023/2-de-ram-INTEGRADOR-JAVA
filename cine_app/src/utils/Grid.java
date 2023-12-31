package utils;

import function.Function;
import movies.Movie;
import users.User;

import java.util.ArrayList;

public class Grid {

    public static void userGrid(ArrayList<User> users) {

        String idLine = "+------";
        String nameLine = "+---------------------------";
        String ageLine = "+------";
        String emailLine = "+---------------------------";
        String roleLine = "+--------+";
        StringBuilder idTitle = new StringBuilder();
        StringBuilder nameTitle = new StringBuilder();


        // For de lineas 
        for (int row = 0; row <= users.size() - 1; row++) {
            idTitle.append("|  " + users.get(row).getId() + " ".repeat(idLine.length() - users.get(0).getId() - 5) + " |");
            if (row == 0) {
                System.out.print(idLine + nameLine + ageLine + emailLine + roleLine);
                System.out.println("");
                idTitle.delete(0, idTitle.length());
                idTitle.append("|  " + "0" + users.get(row).getId() + " ".repeat(idLine.length() - users.get(0).getId() - 5) + " |");
                nameTitle.append(" " + users.get(row).getName() + " " + users.get(row).getLastName() + " ".repeat(nameLine.length() - users.get(row).getName().length() - users.get(row).getLastName().length() - 4) + " |");
                System.out.print(idTitle);
                System.out.println(nameTitle);
                idTitle.delete(0, idTitle.length());
            } else if (row < 10) {
                idTitle.delete(0, idTitle.length());
                nameTitle.delete(0, nameTitle.length());
                idTitle.append("|  " + "0" + users.get(row).getId() + " ".repeat(idLine.length() - users.get(0).getId() - 5) + " |");
                nameTitle.append(" " + users.get(row).getName() + " " + users.get(row).getLastName() + " ".repeat(nameLine.length() - users.get(row).getName().length() - users.get(row).getLastName().length() - 4) + " |");
                System.out.print(idTitle);
                System.out.println(nameTitle);
                idTitle.delete(0, idTitle.length());

            }
        }

    }

    public static void movieGrid(ArrayList<Movie> moviers) {
    }

    public static void functionGrid(ArrayList<Function> functions) {
    }
}
