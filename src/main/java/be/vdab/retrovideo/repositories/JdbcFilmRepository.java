package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Film;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
class JdbcFilmRepository implements FilmRepository {
    private final JdbcTemplate template;

    JdbcFilmRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Film> filmMapper = (result, rowNum) -> new Film(result.getLong("id"), result.getLong("genreid"), result.getString("titel"), result.getLong("voorraad"), result.getLong("gereserveerd"), result.getBigDecimal("prijs"));

    @Override
    public List<Film> findByGenre(long genreId) {
        var sql = "SELECT id, genreid, titel, voorraad, gereserveerd, prijs FROM films WHERE genreid=? ORDER BY titel";
        return template.query(sql, filmMapper, genreId);
    }

    @Override
    public Optional<Film> findById(long id) {
        try {
            var sql = "SELECT id, genreid, titel, voorraad, gereserveerd, prijs FROM films WHERE id=?";
            return Optional.of(template.queryForObject(sql, filmMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Film> findByIds(Set<Long> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        var sql = "SELECT id, genreid, titel, voorraad, gereserveerd, prijs FROM films WHERE id in (" +
                "?,".repeat(ids.size() - 1) +
                "?)";
        return template.query(sql, filmMapper, ids.toArray());
    }
}
