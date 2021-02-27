package detector.domain;

import detector.interfaces.Detector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListDetector implements Detector {

    private List<String> femaleNames = new ArrayList<>();
    private List<String> maleNames = new ArrayList<>();
    final private String separator = " ";

    public ListDetector(){
        femaleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[a]");
        femaleNames.add("Mercedes");

        maleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[^a]");
        maleNames.add("Kuba");
    }
    
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
        String[] splitName = name.split(separator);

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
        int femaleCounter = countTokensMatches(name,femaleNames);
        int maleCounter = countTokensMatches(name,maleNames);
        return decideOnGender(femaleCounter, maleCounter);
    }

    private int countTokensMatches(String name, List<String> tokens){
        int counter = 0;
        for (String token : tokens) {
            if(name.matches(token)){
                counter++;
            }
        }
        return counter;
    }





}
