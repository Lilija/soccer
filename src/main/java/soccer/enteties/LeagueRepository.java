package soccer.enteties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import soccer.enteties.League;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LeagueRepository extends CrudRepository<League, Integer>,
                                            LeagueRepositoryCustom<League, Integer>{
    Optional<Team> findBestTeamById (int Id);
    Optional<Player> findBestPlayerByID (int Id);
    Optional<League> findOne(int Id);
}
