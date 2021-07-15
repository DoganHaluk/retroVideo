package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Film;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FilmRepository {
    List<Film> findByGenre(long genreId);

    Optional<Film> findById(long id);

    List<Film> findByIds(Set<Long> ids);
}
