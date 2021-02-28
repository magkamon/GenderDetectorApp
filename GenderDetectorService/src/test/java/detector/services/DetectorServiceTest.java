package detector.services;

import detector.domain.Gender;
import detector.domain.NameCheckVariant;
import detector.interfaces.Detector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DetectorServiceTest {

    private final Detector detector = mock(Detector.class);
    private final DetectorService detectorService = new DetectorService(detector);

    @Test
    public void testGetGenderMethodForFirstNameVariant(){
        //given
        String name = "Magda";
        NameCheckVariant nameCheckVariant = NameCheckVariant.FIRST_NAME;
        when(detector.getGenderByFirstName(name)).thenReturn(Gender.FEMALE);
        //when
        Gender gender = detectorService.getGender(name,nameCheckVariant);
        //then
        verify(detector,times(1)).getGenderByFirstName(name);
        assertThat(gender).isEqualTo(Gender.FEMALE);
    }

    @Test
    public void testGetGenderMethodForMajorityNameVariant(){
        //given
        String name = "Magda Mikołaj Marek";
        NameCheckVariant nameCheckVariant = NameCheckVariant.MAJORITY_NAME;
        when(detector.getGenderByMajority(name)).thenReturn(Gender.MALE);
        //when
        Gender gender = detectorService.getGender(name, nameCheckVariant);
        //then
        verify(detector,times(1)).getGenderByMajority(name);
        assertThat(gender).isEqualTo(Gender.MALE);
    }

}
