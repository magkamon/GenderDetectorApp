package interfaces;

import domain.Gender;

public interface Detector {

    public Gender getGenderByFirstName(String name);

    public Gender getGenderByMajority(String name);

}
