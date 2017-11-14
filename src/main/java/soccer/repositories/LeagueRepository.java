package soccer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.League;
import soccer.enteties.Player;
import soccer.enteties.Team;
import soccer.repositories.LeagueRepositoryCustom;

import java.util.Optional;

@Repository
public interface LeagueRepository extends CrudRepository<League, Integer>,
        LeagueRepositoryCustom<League, Integer> {
    Optional<Team> findBestTeamById (int id);
    Optional<Player> findBestPlayerById (int id);
    Optional<League> findByTitle (String Title);
}
