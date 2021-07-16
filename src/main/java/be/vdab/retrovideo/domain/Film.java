package be.vdab.retrovideo.domain;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public class Film {
    private final long id;
    private final long genreId;
    private final String titel;
    private final long voorraad;
    private long gereserveerd;
    @NumberFormat(pattern = "0.00")
    private final BigDecimal prijs;

    public Film(long id, long genreId, String titel, long voorraad, long gereserveerd, BigDecimal prijs) {
        this.id = id;
        this.genreId = genreId;
        this.titel = titel;
        this.voorraad = voorraad;
        this.gereserveerd = gereserveerd;
        this.prijs = prijs;
    }

    public long getId() {
        return id;
    }

    public long getGenreId() {
        return genreId;
    }

    public String getTitel() {
        return titel;
    }

    public long getVoorraad() {
        return voorraad;
    }

    public long getGereserveerd() {
        return gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getBeschikbaar() {
        return voorraad - gereserveerd;
    }

    public boolean isBeschikbaar() {
        return getBeschikbaar() > 0;
    }
}
