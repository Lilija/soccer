package soccer.enteties;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.Team;

import java.util.Collection;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
    Collection<Team> findByLeagueId(int leagueId);

}
