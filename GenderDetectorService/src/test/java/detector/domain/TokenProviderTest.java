package detector.domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class TokenProviderTest  {


    @Test
    public void testThrowingExceptionWhenInvalidPathAndFileUsed(){
        //given
        String filePath = "invalid/path";
        String fileName = "not.existing";
        //when&then
        assertThrows(IOException.class, ()-> new TokenProvider(filePath,fileName));
    }

    @Test
    public void testWhenValidPathAndFileUsedThenNonEmptyOptionalToken(){
        //given
       String filePath = "female_tokens.jar";
       String fileName = "female_tokens.txt";
       //when
        TokenProvider tokenProvider = null;
        try {
            tokenProvider = new TokenProvider(filePath,fileName);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            fail();
        }
        //then
        assertThat(tokenProvider.getNextToken().isPresent()).isTrue();
    }

    @Test
    public void testWhenReaderIsClosedThenEmptyOptionalReturned(){
        //given
        String filePath = "female_tokens.jar";
        String fileName = "female_tokens.txt";
        //when
        TokenProvider tokenProvider = null;
        try {
            tokenProvider = new TokenProvider(filePath,fileName);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            fail();
        }
        tokenProvider.closeReader();
        //then
        assertThat(tokenProvider.getNextToken().isEmpty()).isTrue();
    }

}