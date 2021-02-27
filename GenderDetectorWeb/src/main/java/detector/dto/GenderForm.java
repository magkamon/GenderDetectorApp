package detector.dto;

import detector.domain.NameCheckVariant;
import javax.validation.constraints.Size;

public class GenderForm {


    @Size(min=3, message = "Name must be minimum of 3 characters")
    String name;

    NameCheckVariant nameCheckVariant;

    public String getName() {
        return name;
    }

    public NameCheckVariant getNameCheckVariant() {
        return nameCheckVariant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameCheckVariant(NameCheckVariant nameCheckVariant) {
        this.nameCheckVariant = nameCheckVariant;
    }
}
