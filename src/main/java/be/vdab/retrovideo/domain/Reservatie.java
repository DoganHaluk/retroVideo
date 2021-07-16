package be.vdab.retrovideo.domain;

import java.time.LocalDateTime;

public class Reservatie {
    private final long klantId;
    private final long filmId;
    private final LocalDateTime reservatie;

    public Reservatie(long klantId, long filmId) {
        this.klantId = klantId;
        this.filmId = filmId;
        this.reservatie = LocalDateTime.now();
    }

    public long getKlantId() {
        return klantId;
    }

    public long getFilmId() {
        return filmId;
    }

    public LocalDateTime getReservatie() {
        return reservatie;
    }
}
