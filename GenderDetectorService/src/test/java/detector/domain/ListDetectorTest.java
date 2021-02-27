package detector.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void testGetGenderByFistNameForFemaleName(){
        //given
        String name = "Magda";
        //when
        Gender gender = listDetector.getGenderByFirstName(name);
        //then
        assertThat(gender).isEqualTo(Gender.FEMALE);
    }

    @Test
    public void testGetGenderByMajorityForNamesFromEachGender(){
        //given
        String name = "Magda Mikołaj";
        //when
        Gender gender = listDetector.getGenderByMajority(name);
        //then
        assertThat(gender).isEqualTo(Gender.INDECISIVE);
    }

    @Test
    public void testGetGenderByMajorityForMajorityOfMaleNames(){
        //given
        String name = "Magda Mikołaj Marek";
        //when
        Gender gender = listDetector.getGenderByMajority(name);
        //then
        assertThat(gender).isEqualTo(Gender.MALE);
    }

    @Test
    public void testGetGenderByMajorityForMajorityOfFemaleNames(){
        //given
        String name = "Marek Magda Marlena";
        //when
        Gender gender = listDetector.getGenderByMajority(name);
        //then
        assertThat(gender).isEqualTo(Gender.FEMALE);
    }

}