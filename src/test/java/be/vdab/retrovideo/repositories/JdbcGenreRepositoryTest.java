package be.vdab.retrovideo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcGenreRepository.class)
@Sql("/insertGenres.sql")
public class JdbcGenreRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JdbcGenreRepository repository;

    public JdbcGenreRepositoryTest(JdbcGenreRepository repository) {
        this.repository = repository;
    }

    private int genreId() {
        return jdbcTemplate.queryForObject("select id from genres where naam='test1'", Integer.class);
    }

    @Test
    void findAll() {
        assertThat(repository.findAll()).hasSize(countRowsInTable("genres"));
    }

    @Test
    void findById() {
        long id = genreId();
        assertThat(repository.findById(id).get().getNaam()).isEqualTo("test1");
    }
}
