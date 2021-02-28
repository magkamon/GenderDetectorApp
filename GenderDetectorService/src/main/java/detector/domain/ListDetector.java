package detector.domain;

import detector.interfaces.Detector;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ListDetector implements Detector {

    private static final String SEPARATOR = " ";
    
    @Override
    public Gender getGenderByFirstName(String name){
        Optional<String[]> split = splitName(name);
        if( split.isPresent() ){
            return getGender(split.get()[0]);
        }
        return Gender.INDECISIVE;
    }

    @Override
    public Gender getGenderByMajority(String name){
        Optional<String[]> split = splitName(name);
        if( split.isEmpty() ){
            return Gender.INDECISIVE;
        }

        int femaleCounter = 0;
        int maleCounter = 0;

        for (String singleName : split.get()) {
          Gender gender = getGender(singleName);
          if(gender.equals(Gender.FEMALE)){
              femaleCounter++;
          }else if(gender.equals(Gender.MALE)){
              maleCounter++;
          }
        }
        return decideOnGender(femaleCounter, maleCounter);
    }

    private Optional<String[]> splitName(String name){
        if( name == null){
            return Optional.empty();
        }
        String[] splitName = name.split(SEPARATOR);

        if( splitName.length == 0){
            return Optional.empty();
        }

        return Optional.of(splitName);
    }

    private Gender decideOnGender(int femaleCounter, int maleCounter){
        if(femaleCounter > maleCounter){
            return Gender.FEMALE;
        } else if(femaleCounter < maleCounter){
            return Gender.MALE;
        } else return Gender.INDECISIVE;
    }

    private Gender getGender(String name){
        TokenProviderManager tokenProviderManager = new TokenProviderManager();
        Optional<TokenProvider> femaleTokenProvider = tokenProviderManager.getProvider(Token.FEMALE);
        Optional<TokenProvider> maleTokenProvider = tokenProviderManager.getProvider(Token.MALE);

        if(femaleTokenProvider.isEmpty() || maleTokenProvider.isEmpty()){
            return Gender.INDECISIVE;
        }
        int femaleCounter = countTokensMatches(name, femaleTokenProvider.get());
        int maleCounter = countTokensMatches(name, maleTokenProvider.get());
        return decideOnGender(femaleCounter, maleCounter);
    }

    private int countTokensMatches(String name, TokenProvider tokenProvider){
        int counter = 0;
        Optional<String> token = tokenProvider.getNextToken();
        while (token.isPresent()){
            if(name.matches(token.get())){
                counter++;
            }
            token = tokenProvider.getNextToken();
        }
        tokenProvider.closeReader();
        return counter;
    }
}
