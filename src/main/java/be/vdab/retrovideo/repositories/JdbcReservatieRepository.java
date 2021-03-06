package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Reservatie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcReservatieRepository implements ReservatieRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    public JdbcReservatieRepository(JdbcTemplate template) {
        this.template = template;
        insert = new SimpleJdbcInsert(template).withTableName("reservaties").usingColumns("klantid", "filmid", "reservatie");
    }

    @Override
    public void create(List<Reservatie> reservaties) {
        for (var reservatie : reservaties) {
            insert.execute(Map.of("klantid", reservatie.getKlantId(), "filmid", reservatie.getFilmId(), "reservatie", reservatie.getReservatie()));
        }
    }
}
