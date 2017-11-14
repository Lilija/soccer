package soccer.repositories;

import org.springframework.data.repository.CrudRepository;
import soccer.enteties.Team;

public interface TeamRepository extends CrudRepository<Team,Integer> {
}
