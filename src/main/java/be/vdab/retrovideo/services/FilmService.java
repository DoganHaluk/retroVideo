package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Film;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FilmService {
    List<Film> findByGenre(long genreId);

    Optional<Film> findById(long id);

    List<Film> findByIds(Set<Long> ids);

    BigDecimal totaalPrijs(Set<Long> ids);

    void update(long id);
}
