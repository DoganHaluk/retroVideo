package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Genre;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class JdbcGenreRepository implements GenreRepository {
    private final JdbcTemplate template;

    JdbcGenreRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Genre> genreMapper = (result, rowNum) -> new Genre(result.getLong("id"), result.getString("naam"));

    @Override
    public List<Genre> findAll() {
        var sql = "SELECT id, naam FROM genres ORDER BY naam";
        return template.query(sql, genreMapper);
    }

    @Override
    public Optional<Genre> findById(long id) {
        try {
            var sql = "SELECT id, naam FROM genres WHERE id=?";
            return Optional.of(template.queryForObject(sql, genreMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }
}
