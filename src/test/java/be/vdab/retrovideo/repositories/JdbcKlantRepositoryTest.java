package be.vdab.retrovideo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcKlantRepository.class)
@Sql("/insertKlanten.sql")
public class JdbcKlantRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JdbcKlantRepository repository;

    public JdbcKlantRepositoryTest(JdbcKlantRepository repository) {
        this.repository = repository;
    }

    private int idVanTestKlant() {
        return jdbcTemplate.queryForObject("select id from klanten where familienaam='test'", Integer.class);
    }

    @Test
    void findByOnbestaandeFamilieNaamGeeftLeeg() {
        assertThat(repository.findByFamilienaamBevat("xx")).isEmpty();
    }

    @Test
    void getNaamGeeftVoornaamEnFamilienaamSamen() {
        assertThat(repository.getNaam(idVanTestKlant())).isEqualTo("test test");
    }
}
