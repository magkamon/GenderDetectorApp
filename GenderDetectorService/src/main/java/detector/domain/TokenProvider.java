package detector.domain;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Enumeration;
import java.util.Optional;
import java.util.jar.JarFile;

public class TokenProvider {

    public Optional<String> getNextFemaleToken(){
        JarFile jarFile = null;
        try {
            jarFile = new JarFile("female_tokens.jar");
        }catch (IOException ioException){
            System.out.println(ioException.getCause());
            return Optional.empty();
        }
        Enumeration enumeration = jarFile.entries();
        if(enumeration.hasMoreElements()){
            return Optional.of(enumeration.nextElement().toString());
        }
        else {
            return Optional.empty();
        }
    }
//
//    public Optional<String> getNextMaleToken(){
//
//    }



}
