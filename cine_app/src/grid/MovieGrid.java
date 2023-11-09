package grid;

import movies.Movie;

public class MovieGrid {
    private static StringBuilder idLine = new StringBuilder();
    private static StringBuilder titleLine = new StringBuilder();
    private static StringBuilder clasificationLine = new StringBuilder();
    private static StringBuilder genderLine = new StringBuilder();
    private static StringBuilder id = new StringBuilder();
    private static StringBuilder title = new StringBuilder();
    private static StringBuilder clasification = new StringBuilder();
    private static StringBuilder gender = new StringBuilder();

    public static void generateHeader() {
        clearData();
        idLine.append("-".repeat(4));
        titleLine.append("-".repeat(50));
        clasificationLine.append("-".repeat(17));
        genderLine.append("-".repeat(50));
        id.append("| ID ");
        title.append("| TITULO DE LA PELÍCULA                            ");
        clasification.append("| CLASIFICACIÓN + ");
        gender.append("| GÉNERO DE LA PELÍCULA                            |");
        String line = "+" + idLine + "+" + titleLine + "+" + clasificationLine + "+" + genderLine + "+";
        String titles = id.toString() + title + clasification + gender;
        System.out.println(line);
        System.out.println(titles);
        System.out.println(line);
    }

    public static void showMovieLine(Movie movie) {
        clearData();
        id.append("| ");
        id.append(movie.getId());
        id.append(" ".repeat(5 - id.length()));
        title.append("| ");
        title.append(movie.getTitle());
        title.append(" ".repeat(51 - title.length()));
        clasification.append("| ");
        clasification.append(movie.getClassification());
        clasification.append(" ".repeat(18 - clasification.length()));
        gender.append("| ");
        gender.append(movie.getGender());
        gender.append(" ".repeat(51 - gender.length()));
        gender.append("|");
        String movieLine = id.toString() + title + clasification + gender;
        System.out.println(movieLine);
    }

    private static void clearData() {
        id.delete(0, id.length());
        title.delete(0, title.length());
        clasification.delete(0, clasification.length());
        gender.delete(0, gender.length());
        idLine.delete(0, idLine.length());
        titleLine.delete(0, titleLine.length());
        clasificationLine.delete(0, clasificationLine.length());
        genderLine.delete(0, genderLine.length());
    }
}