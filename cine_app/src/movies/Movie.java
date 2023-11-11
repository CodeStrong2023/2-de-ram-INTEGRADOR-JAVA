package movies;
// Clase que representa una película en el sistema
public class Movie {
    // Atributos de la clase para almacenar información sobre la película
    private int id = 0;
    private String title;
    private int classification;
    private String gender;
    private boolean isActive;
    // Contador estático para asignar un identificador único a cada película
    private static int countId;
    // Constructor de la clase para crear una nueva película con información proporcionada por el usuario
    public Movie(String title, int classification, String gender) {
        this.title = title;
        this.classification = classification;
        this.gender = gender;
        this.isActive = true;
        this.id = ++countId;
    }
    //GETTERS Y SETTERS
    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
