package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.repositories.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultFilmService implements FilmService {
    private final FilmRepository filmRepository;

    DefaultFilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Film> findByGenre(long genreId) {
        return filmRepository.findByGenre(genreId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Film> findById(long id) {
        return Optional.empty();
    }
}
