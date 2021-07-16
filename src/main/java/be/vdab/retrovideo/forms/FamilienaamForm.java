package be.vdab.retrovideo.forms;

import javax.validation.constraints.NotEmpty;

public class FamilienaamForm {
    @NotEmpty
    private final String familienaamBevat;

    public FamilienaamForm(String familienaamBevat) {
        this.familienaamBevat = familienaamBevat;
    }

    public String getFamilienaamBevat() {
        return familienaamBevat;
    }
}
