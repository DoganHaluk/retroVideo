package be.vdab.retrovideo.sessions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MandjeTest {
    private Mandje mandje;

    @BeforeEach
    void beforeEach() {
        mandje = new Mandje();
    }

    @Test
    void eenNieuweMandjeIsLeeg() {
        assertThat(mandje.getIds()).isEmpty();
    }

    @Test
    void alsEenItemWordtToegevoegdIsErMaarEenItem() {
        mandje.voegToe(1);
        assertThat(mandje.getIds()).containsOnly(1L);
    }

    @Test
    void alsTweeItemsWordenToegevoegdZijnErMaarTweeItems() {
        mandje.voegToe(1);
        mandje.voegToe(2);
        assertThat(mandje.getIds()).containsOnly(1L, 2L);
    }

    @Test
    void alsEenItemWordtToegevoegdVervolgensWordtVerwijdertIsErGeenItem() {
        mandje.voegToe(10);
        var films = new Long[]{10L};
        mandje.verwijder(films);
        assertThat(mandje.getIds()).isEmpty();
    }
}
