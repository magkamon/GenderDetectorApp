package domain;

import interfaces.Detector;

import java.util.ArrayList;
import java.util.List;

public class ListDetector implements Detector {

    List<String> femaleNames = new ArrayList<>();
    List<String> maleNames = new ArrayList<>();


    public ListDetector(){
        femaleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[a]");
        femaleNames.add("Mercedes");


        maleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[^a]");
        maleNames.add("Kuba");
    }
    
    @Override
    public Gender getGenderByFirstName(String name){
        String[] splitName = name.split(" ");
        return getGender(splitName[0]);
    }

    @Override
    public Gender getGenderByMajority(String name){
        String[] splitName = name.split(" ");
        int femaleCounter = 0;
        int maleCounter = 0;

        for (String singleName : splitName) {
          Gender gender = getGender(singleName);
          if(gender.equals(Gender.FEMALE)){
              femaleCounter++;
          }else if(gender.equals(Gender.MALE)){
              maleCounter++;
          }
        }

        if(femaleCounter > maleCounter){
            return Gender.FEMALE;
        } else if(femaleCounter < maleCounter){
            return Gender.MALE;
        } else return Gender.INDECISIVE;
    }


    public Gender getGender(String name){
        int femaleCounter = countTokensMatches(name,femaleNames);
        int maleCounter = countTokensMatches(name,maleNames);
        if(femaleCounter > maleCounter){
            return Gender.FEMALE;
        } else if(femaleCounter < maleCounter){
            return Gender.MALE;
        } else return Gender.INDECISIVE;

//        if(name.matches(femaleNames.get(0)) || name.matches(femaleNames.get(1)) ){
//            System.out.println(name + " - it is a female");
//            return domain.Gender.FEMALE;
//        }
//        if(name.matches(maleNames.get(0)) || name.matches(maleNames.get(1)) ){
//            System.out.println(name + " - it is a men");
//            return domain.Gender.MALE;
//        }
//        System.out.println("Cannot decide");
//        return domain.Gender.INDECISIVE;
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
