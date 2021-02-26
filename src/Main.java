import domain.ListDetector;
import interfaces.Detector;

public class Main {
    public static void main(String[] args) {

        Detector detector = new ListDetector();
//        System.out.println( "Michał " + detector.getGender("Michał ").getGender());
//        System.out.println( "Magda " + detector.getGender("Magda").getGender());
//
//        System.out.println( "Mercedes " + detector.getGender("Mercedes").getGender());
//        System.out.println( "Kuba " + detector.getGender("Kuba").getGender());

        System.out.println("Anna Maria " +detector.getGenderByFirstName("Anna Maria").getGender());
        System.out.println("Anna Maria 2 " +detector.getGenderByMajority("Anna Maria").getGender());
        System.out.println("Anna Maria Jan Irek Michał " +detector.getGenderByMajority("Anna Maria Jan Irek Michał").getGender());


    }
}
