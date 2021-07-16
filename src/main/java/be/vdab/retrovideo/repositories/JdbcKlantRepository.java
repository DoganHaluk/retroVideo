package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Klant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcKlantRepository implements KlantRepository {
    private final JdbcTemplate template;

    public JdbcKlantRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Klant> klantMapper = (result, rowNum) -> new Klant(result.getLong("id"), result.getString("familienaam"), result.getString("voornaam"), result.getString("straatNummer"), result.getString("postcode"), result.getString("gemeente"));

    @Override
    public List<Klant> findByFamilienaamBevat(String familienaamBevat) {
        var sql = "SELECT id, familienaam, voornaam, straatNummer, postcode, gemeente FROM klanten WHERE familienaam LIKE ? ORDER BY familienaam";
        return template.query(sql, klantMapper, '%' + familienaamBevat + '%');
    }

    @Override
    public String getNaam(long id) {
        var sql = "SELECT CONCAT(voornaam, ' ', familienaam) AS name FROM klanten WHERE id=?";
        return template.queryForObject(sql, String.class, id);
    }
}
