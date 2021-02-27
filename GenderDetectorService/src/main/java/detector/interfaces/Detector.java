package detector.interfaces;

import detector.domain.Gender;

public interface Detector {

    public Gender getGenderByFirstName(String name);

    public Gender getGenderByMajority(String name);

}
