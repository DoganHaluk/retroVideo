package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Film;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BIG_DECIMAL;

@JdbcTest
@Import(JdbcFilmRepository.class)
@Sql("/insertFilms.sql")
public class JdbcFilmRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JdbcFilmRepository repository;

    public JdbcFilmRepositoryTest(JdbcFilmRepository repository) {
        this.repository = repository;
    }

    private long genreIdVanFilm1(){
        return super.jdbcTemplate.queryForObject("select genreid from films where titel='Film1'", Integer.class);
    }

    private long filmIdVanFilm1() {
        return super.jdbcTemplate.queryForObject("SELECT id FROM films WHERE titel='Film1'", Long.class);
    }

    private long filmIdVanFilm2() {
        return super.jdbcTemplate.queryForObject("SELECT id from films WHERE titel='Film2'", Long.class);
    }

    @Test
    void findByGenreId(){
        long id=genreIdVanFilm1();
        assertThat(repository.findByGenre(id))
                .hasSize(super.countRowsInTableWhere("films","genreid=1"))
                .extracting(Film::getTitel).isSorted();
    }

    @Test
    void findById() {
        long id1 = filmIdVanFilm1();
        assertThat(repository.findById(id1).get().getTitel()).isEqualTo("Film1");
    }

    @Test
    void findByIds() {
        long id1 = filmIdVanFilm1();
        long id2 = filmIdVanFilm2();
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

    @Test
    void findTotaalPrijs() {
        long id1 = filmIdVanFilm1();
        long id2 = filmIdVanFilm2();
        assertThat(repository.totaalPrijs(Set.of(id1,id2)).doubleValue())
                .isEqualTo(3D);
    }

    @Test
    void update(){
        repository.update(filmIdVanFilm1());
        assertThat(repository.findById(filmIdVanFilm1()).get().getGereserveerd()).isEqualTo(1);
    }
}
