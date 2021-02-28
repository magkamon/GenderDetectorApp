package detector.domain;

import java.io.IOException;
import java.util.Optional;

public class TokenProviderManager {

    private static final String FEMALE_TOKEN_FILE = "female_tokens.txt";
    private static final String MALE_TOKEN_FILE = "male_tokens.txt";
    private static final String FEMALE_TOKEN_JAR_PATH = "female_tokens.jar";
    private static final String MALE_TOKEN_JAR_PATH = "male_tokens.jar";

    private String relativeFilesPath = "";

    public TokenProviderManager(Optional<String> relativeFilesPath){
        if(relativeFilesPath.isPresent()){
            this.relativeFilesPath = relativeFilesPath.get() + "/";
        }
    }

    public Optional<TokenProvider> getProvider(Token token){
       try {
           if(token.equals(Token.MALE)){
               return Optional.of(new TokenProvider(relativeFilesPath + MALE_TOKEN_JAR_PATH, MALE_TOKEN_FILE));
           }else {
               return Optional.of(new TokenProvider(relativeFilesPath + FEMALE_TOKEN_JAR_PATH, FEMALE_TOKEN_FILE));
           }
       }catch (IOException ioException){
           ioException.printStackTrace();
           return Optional.empty();
       }
    }

}
