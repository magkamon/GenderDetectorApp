public class Main {
    public static void main(String[] args) {

        Detector detector = new Detector();
        detector.getGender("Michał");
        detector.getGender("Magda");

        detector.getGender("Mercedes");
        detector.getGender("Kuba");
    }
}
