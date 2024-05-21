package project.alphasolutionsproject.model;

public class Ekspertise {
    private int ekspertiseID;
    private String ekspertiseName;
    private int level;
    private int experience;


    public Ekspertise(int ekspertiseID, String ekspertiseName, int level, int experience) {
        this.ekspertiseID = ekspertiseID;
        this.ekspertiseName = ekspertiseName;
        this.level = level;
        this.experience = experience;
    }

    public int getEkspertiseID() {
        return ekspertiseID;
    }

    public void setEkspertiseID(int ekspertiseID) {
        this.ekspertiseID = ekspertiseID;
    }

    public String getEkspertiseName() {
        return ekspertiseName;
    }

    public void setEkspertiseName(String ekspertiseName) {
        this.ekspertiseName = ekspertiseName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
