package repos;

import org.springframework.data.repository.CrudRepository;
import soccer.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}
