package detector.services;

import detector.domain.Gender;
import detector.domain.ListDetector;
import detector.domain.NameCheckVariant;
import detector.interfaces.Detector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DetectorService {

    private final Detector detector;

    @Autowired
    public DetectorService() {
        this.detector = new ListDetector();
    }

    public List<NameCheckVariant> getVariants(){
        return Arrays.asList(NameCheckVariant.values());
    }

    public Gender getGender(String name, NameCheckVariant nameCheckVariant){
        if(nameCheckVariant.equals(NameCheckVariant.FIRST_NAME)){
            return detector.getGenderByFirstName(name);
        }else{
            return detector.getGenderByMajority(name);
        }
    }


}
