package detector.domain;

import java.io.IOException;
import java.util.Optional;

public class TokenProviderManager {

    private static final String FEMALE_TOKEN_FILE = "female_tokens.txt";
    private static final String MALE_TOKEN_FILE = "male_tokens.txt";
    private static final String FEMALE_TOKEN_JAR_PATH = "src/female_tokens.jar";
    private static final String MALE_TOKEN_JAR_PATH = "src/male_tokens.jar";

    public Optional<TokenProvider> getProvider(Token token){
       try {
           if(token.equals(Token.MALE)){
               return Optional.of(new TokenProvider(MALE_TOKEN_JAR_PATH, MALE_TOKEN_FILE));
           }else {
               return Optional.of(new TokenProvider(FEMALE_TOKEN_JAR_PATH, FEMALE_TOKEN_FILE));
           }
       }catch (IOException ioException){
           return Optional.empty();
       }
    }

}
