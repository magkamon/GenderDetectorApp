package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ListDetectorTest {

    private final ListDetector listDetector = new ListDetector();

    @Test
    public void testGetByFirstNameWhenInputIsEmptyString(){
        //given
        String name = " ";
        //when
        Gender gender = listDetector.getGenderByFirstName(name);
        //then
        assertThat(gender).isEqualTo(Gender.INDECISIVE);
    }
    @Test
    public void testGetByFirstNameWhenInputIsNullString(){
        //given
        String name = null;
        //when
        Gender gender = listDetector.getGenderByFirstName(name);
        //then
        assertThat(gender).isEqualTo(Gender.INDECISIVE);
    }

    @Test
    public void testGetByMajorityWhenInputIsEmptyString(){
        //given
        String name = " ";
        //when
        Gender gender = listDetector.getGenderByFirstName(name);
        //then
        assertThat(gender).isEqualTo(Gender.INDECISIVE);
    }
    @Test
    public void testGetByMajorityWhenInputIsNullString(){
        //given
        String name = null;
        //when
        Gender gender = listDetector.getGenderByFirstName(name);
        //then
        assertThat(gender).isEqualTo(Gender.INDECISIVE);
    }
}