package detector.domain;

public enum Token {
    FEMALE ("Female names"),
    MALE("Male names");

    String token;

    Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
