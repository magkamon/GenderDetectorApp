import java.util.ArrayList;
import java.util.List;

public class Detector {

    List<String> femaleNames = new ArrayList<>();
    List<String> maleNames = new ArrayList<>();

    Detector(){
        femaleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[a]");
        femaleNames.add("Mercedes");
        maleNames.add("[a-zA-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+[^a]");
        maleNames.add("Kuba");
    }


    public Gender getGender(String name){
        if(name.matches(femaleNames.get(0)) || name.matches(femaleNames.get(1)) ){
            System.out.println(name + " - it is a female");
            return Gender.FEMALE;
        }
        if(name.matches(maleNames.get(0)) || name.matches(maleNames.get(1)) ){
            System.out.println(name + " - it is a men");
            return Gender.MALE;
        }
        System.out.println("Cannot decide");
        return Gender.INDECISIVE;
    }

}
