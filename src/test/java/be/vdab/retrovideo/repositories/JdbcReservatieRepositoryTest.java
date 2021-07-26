package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Reservatie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcReservatieRepository.class)
@Sql("/insertReservaties.sql")
public class JdbcReservatieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String RESERVATIES = "reservaties";
    private final JdbcReservatieRepository repository;

    public JdbcReservatieRepositoryTest(JdbcReservatieRepository repository) {
        this.repository = repository;
    }

    @Test
    void createEenNieuweReservatieHeeftEenRij(){
        repository.create(List.of(new Reservatie(1L,1L)));
        assertThat(countRowsInTableWhere(RESERVATIES, "klantid= "+1L)).isOne();
    }
}
