package detector.domain;

public enum Gender {
    FEMALE("Female"),
    MALE("Male"),
    INDECISIVE("Indecisive");

    String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
