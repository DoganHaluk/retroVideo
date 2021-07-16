package be.vdab.retrovideo.sessions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KlantGekozenTest {
    private KlantGekozen klantGekozen;

    @BeforeEach
    void beforeEach() {
        klantGekozen = new KlantGekozen();
    }

    @Test
    void alsEenKlantWordtToegevoegdIsErDezefdeKlant() {
        klantGekozen.setKlantId(1);
        assertThat(klantGekozen.getKlantId()).isEqualByComparingTo(1L);
    }
}
