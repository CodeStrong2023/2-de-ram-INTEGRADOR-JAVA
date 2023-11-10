package grid;

import function.Function;

public class FunctionGrid {
    private static StringBuilder idLine = new StringBuilder();
    private static StringBuilder titleLine = new StringBuilder();
    private static StringBuilder roomLine = new StringBuilder();
    private static StringBuilder scheduleLine = new StringBuilder();
    private static StringBuilder id = new StringBuilder();
    private static StringBuilder title = new StringBuilder();
    private static StringBuilder room = new StringBuilder();
    private static StringBuilder schedule = new StringBuilder();

    public static void generateHeader() {
        clearData();
        idLine.append("-".repeat(4));
        titleLine.append("-".repeat(50));
        roomLine.append("-".repeat(8));
        scheduleLine.append("-".repeat(10));
        id.append("| ID ");
        title.append("| TITULO DE LA PELÍCULA                            ");
        room.append("| SALA   ");
        schedule.append("| HORARIO  |");
        String line = "+" + idLine + "+" + titleLine + "+" + roomLine + "+" + scheduleLine + "+";
        String titles = id.toString() + title + room + schedule;
        System.out.println(line);
        System.out.println(titles);
        System.out.println(line);
    }

    public static void showFunctionLine(Function function) {
        clearData();
        id.append("| ");
        id.append(function.getId());
        id.append(" ".repeat(5 - id.length()));
        title.append("| ");
        title.append(function.getMovie().getTitle());
        title.append(" ".repeat(51 - title.length()));
        room.append("| ");
        room.append(function.getRoom());
        room.append(" ".repeat(9 - room.length()));
        schedule.append("| ");
        schedule.append(function.getSchedule());
        schedule.append(" ".repeat(11 - schedule.length()));
        schedule.append("|");
        String functionLine = id.toString() + title + room + schedule;
        System.out.println(functionLine);
    }
    private static void clearData() {
        id.delete(0, id.length());
        room.delete(0, room.length());
        title.delete(0, title.length());
        schedule.delete(0, schedule.length());
        idLine.delete(0, idLine.length());
        roomLine.delete(0, roomLine.length());
        titleLine.delete(0, titleLine.length());
        scheduleLine.delete(0, scheduleLine.length());
    }
}
