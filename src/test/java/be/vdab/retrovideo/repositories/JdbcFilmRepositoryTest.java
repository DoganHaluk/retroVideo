package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Film;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcFilmRepository.class)
@Sql("/insertFilms.sql")
public class JdbcFilmRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JdbcFilmRepository repository;

    public JdbcFilmRepositoryTest(JdbcFilmRepository repository) {
        this.repository = repository;
    }

    private int idVanFilm1() {
        return super.jdbcTemplate.queryForObject("SELECT id FROM films WHERE titel='Film1'", Integer.class);
    }

    private int idVanFilm2() {
        return super.jdbcTemplate.queryForObject("SELECT id from films WHERE titel='Film2'", Integer.class);
    }

    @Test
    void findByIds() {
        long id1 = idVanFilm1();
        long id2 = idVanFilm2();
        assertThat(repository.findByIds(Set.of(id1, id2)))
                .extracting(Film::getId).containsOnly(id1, id2)
                .isSorted();
    }

    @Test
    void findByIdsGeeftLegeVerzamelingFilmsBijLegeVerzamelingIds() {
        assertThat(repository.findByIds(Set.of())).isEmpty();
    }

    @Test
    void findByIdsGeeftLegeVerzamelingFilmsBijOnbestaandeIds() {
        assertThat(repository.findByIds(Set.of(-1L))).isEmpty();
    }
}
