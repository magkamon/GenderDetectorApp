package detector.domain;

import detector.interfaces.Detector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("InconclusiveDetector")
public class InconclusiveDetector implements Detector {

    @Override
    public Gender getGenderByFirstName(String name) {
        return Gender.INCONCLUSIVE;
    }

    @Override
    public Gender getGenderByMajority(String name) {
        return Gender.INCONCLUSIVE;
    }
}
