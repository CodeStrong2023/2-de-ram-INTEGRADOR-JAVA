package menus;

public class Menus {

    public static void customHeaderMenu(String title) {
        // Este método crea una cabecera de menú flexible, se adapta el tamaño a cualquier título
        String _title = "|          " + title + "          |";
        StringBuilder line = new StringBuilder();

        for(var i = 0; i < _title.length(); i++) {
            line.append("=");
        }
        System.out.println(line);
        System.out.println(_title);
        System.out.println(line);

    }
}
