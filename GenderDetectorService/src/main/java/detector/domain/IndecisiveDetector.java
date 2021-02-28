package detector.domain;

import detector.interfaces.Detector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("IndecisiveDetector")
public class IndecisiveDetector implements Detector {

    @Override
    public Gender getGenderByFirstName(String name) {
        return Gender.INDECISIVE;
    }

    @Override
    public Gender getGenderByMajority(String name) {
        return Gender.INDECISIVE;
    }
}
