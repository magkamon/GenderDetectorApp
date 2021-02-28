package detector.services;

import detector.domain.*;
import detector.interfaces.Detector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DetectorService {
    private static final String serviceRelativePath = "GenderDetectorService";
    private final Detector detector;

    @Autowired
    public DetectorService(@Qualifier("ListDetector")Detector detector) {
        this.detector = detector;
    }

    public List<NameCheckVariant> getVariants(){
        return Arrays.asList(NameCheckVariant.values());
    }

    public List<Token> getTokens(){
        return Arrays.asList(Token.values());
    }

    public Gender getGender(String name, NameCheckVariant nameCheckVariant){
        if(nameCheckVariant.equals(NameCheckVariant.FIRST_NAME)){
            return detector.getGenderByFirstName(name);
        }else{
            return detector.getGenderByMajority(name);
        }
    }

    public Optional<TokenProvider> getProvider(Token token){
        return new TokenProviderManager(Optional.of(serviceRelativePath)).getProvider(token);
    }

}
