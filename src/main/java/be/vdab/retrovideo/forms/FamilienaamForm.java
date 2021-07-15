package be.vdab.retrovideo.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class FamilienaamForm {
    @NotBlank
    @NotEmpty
    private final String familienaamBevat;

    public FamilienaamForm(String familienaamBevat) {
        this.familienaamBevat = familienaamBevat;
    }
    public String getFamilienaamBevat(){
        return familienaamBevat;
    }
}
