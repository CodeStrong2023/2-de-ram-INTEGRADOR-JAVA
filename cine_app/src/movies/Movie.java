package movies;

public class Movie {
    private int id = 0;
    private String title;
    private int classification;
    private String gender;
    private boolean isActive;

    private static int countId;
    public Movie(String title, int classification, String gender) {
        this.title = title;
        this.classification = classification;
        this.gender = gender;
        this.isActive = true;
        this.id = ++countId;
    }

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
