package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarsDAO {

    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CarsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Cars> list(){
        String sql = "SELECT * FROM SAMOCHODY";

        List<Cars> listCars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cars.class));

        return listCars;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Cars cars) {
    }
    /* Read – odczytywanie danych z bazy */
    public Cars get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Cars cars) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
