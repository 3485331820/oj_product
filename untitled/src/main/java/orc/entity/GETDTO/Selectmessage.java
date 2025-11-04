package orc.entity.GETDTO;

public class Selectmessage {
    private String difficulty;
    private String language;

    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return "Selectmessage{" +
                "difficulty='" + difficulty + '\'' +
                ", language='" + language + '\'' +
                '}';
    } 
}

