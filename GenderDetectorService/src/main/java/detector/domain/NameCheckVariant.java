package detector.domain;

public enum  NameCheckVariant {

    FIRST_NAME("Check only by first name"),
    MAJORITY_NAME("Check by majority of names");

    String variant;

    NameCheckVariant(String variant) {
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }
}
