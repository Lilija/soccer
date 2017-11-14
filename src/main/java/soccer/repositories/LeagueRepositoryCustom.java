package soccer.repositories;

import org.springframework.stereotype.Repository;
import soccer.enteties.Player;
import soccer.enteties.Team;

import java.util.Optional;
@Repository
public interface LeagueRepositoryCustom<League, Integer> {
    Optional<Team> findBestTeamById (int id);
    Optional<Player> findBestPlayerById (int id);

}
